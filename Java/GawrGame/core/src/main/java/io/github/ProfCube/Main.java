package io.github.ProfCube;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main implements ApplicationListener {

//    private Texture guraImage;
    private Texture background;
    private FitViewport viewport;
    private Player gura;
    private SpriteBatch spriteBatch;
    private Ball ball;

    @Override
    public void create() {
        // Prepare your application here.
//        guraImage = new Texture("gura.png");
        gura = new Player();
        ball = new Ball();
        background = new Texture("background.jpg");
        viewport = new FitViewport(8, 5);
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void resize(int width, int height) {
        // Resize your application here. The parameters represent the new window size.
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        // Draw your application here.
        float delta = Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(Color.BLACK);
        //move();
        gura.input(viewport);
        ball.update(viewport);
        onCollision();
        gura.update(delta);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0,
            viewport.getWorldWidth(), viewport.getWorldHeight());
        gura.draw(spriteBatch);
        ball.draw(spriteBatch);
        spriteBatch.end();
    }

    public void move() {
        gura.translateX(.1f);

        gura.setX(MathUtils.clamp(gura.getX(),
            0, viewport.getWorldWidth() - gura.getWidth()));
    }

    public void onCollision() {
        Rectangle guraHitbox = gura.getBoundingRectangle();
        Rectangle ballHitBox = ball.getBoundingRectangle();
        if (guraHitbox.overlaps(ballHitBox)) {
            System.out.println("Collision");
            ball.randomPosn(viewport);
        }
    }


/*
    public void input() {
        float speed = 1.50f;
        float delta = Gdx.graphics.getDeltaTime(); //for all hw frame rate
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ||
            Gdx.input.isKeyPressed(Input.Keys.D)) {
            gura.translateX(speed*delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ||
            Gdx.input.isKeyPressed(Input.Keys.A)) {
            gura.translateX(-1*speed*delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) ||
            Gdx.input.isKeyPressed(Input.Keys.W)) {
            gura.translateX(speed*delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) ||
            Gdx.input.isKeyPressed(Input.Keys.S)) {
            gura.translateX(speed*delta);
        }

        gura.setX(MathUtils.clamp(gura.getX(),
            0, viewport.getWorldWidth() - gura.getWidth()));

        gura.setY(MathUtils.clamp(gura.getY(),
            0, viewport.getWorldHeight() - gura.getHeight()));


    }
*/
    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void dispose() {
        // Destroy application's resources here.
    }
}
