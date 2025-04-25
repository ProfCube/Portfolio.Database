package io.github.ProfCube;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Player  extends Sprite {
    private float speed = 1.5f;
    float velocityY = 0;
    float gravity = -30f;
    float jumpStrength = 8.9f;
    boolean isJumping = false;


    public Player() {
        super(new Texture("gura.png"));
        setSize(1,1);
    }

    public void update(float delta) {
        // Handle jump input
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && !isJumping) {
            velocityY = jumpStrength;
            isJumping = true;
        }

        // Apply gravity
        velocityY += gravity * delta;

        // Apply velocity to position
        this.translateY(velocityY * delta);

        // Simple ground collision
        if (this.getY() <= 0) {
            this.setY(0);
            velocityY = 0;
            isJumping = false;
        }
    }

    public void input(Viewport viewport) {
        float delta = Gdx.graphics.getDeltaTime(); //for all hw frame rate
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ||
            Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.translateX(speed*delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ||
            Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.translateX(-1*speed*delta);
        }
/*        if (Gdx.input.isKeyPressed(Input.Keys.UP) ||
            Gdx.input.isKeyPressed(Input.Keys.W)) {
            gura.translateX(speed*delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) ||
            Gdx.input.isKeyPressed(Input.Keys.S)) {
            gura.translateX(speed*delta);
        }
*/
        this.setX(MathUtils.clamp(this.getX(),
            0, viewport.getWorldWidth() - this.getWidth()));
/*
        gura.setY(MathUtils.clamp(gura.getY(),
            0, viewport.getWorldHeight() - gura.getHeight()));

*/
    }

}
