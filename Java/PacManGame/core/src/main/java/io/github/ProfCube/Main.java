package io.github.ProfCube;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class Main implements ApplicationListener {

    private SpriteBatch batch;
    private Texture texture;
    private GameScreen gameScreen;

    @Override
    public void create() {
        batch = new SpriteBatch();
        texture = new Texture("pacman.png");
        gameScreen = new GameScreen();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void render() {
        gameScreen.render();
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
