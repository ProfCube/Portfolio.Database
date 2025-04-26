package io.github.ProfCube;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class GameScreen implements Screen {

    private FlappyBirdGame game;
    private SpriteBatch batch;
    private Texture background, flappy, bPipe, tPipe;

    private Player player;
    private Array<Pipe> obstacles;

    private float timeSinceLastPipe;
    private final float pipeSpawnInterval = 1.5f;

    private int xVelocity = -200; // pixels per second
    private int yVelocity = 0;
    private int gravity = -15;
    private float score = 0;
    private boolean gameOver = false;

    public GameScreen(FlappyBirdGame game) {
        this.game = game;
        batch = new SpriteBatch();
        loadAssets();
        initializeGame();
    }

    private void loadAssets() {
        background = new Texture("background.png");
        flappy = new Texture("flappy.png");
        bPipe = new Texture("bPipe.png");
        tPipe = new Texture("tPipe.png");
    }

    private void initializeGame() {
        player = new Player(48, 213, 34, 24, flappy);
        obstacles = new Array<>();
        timeSinceLastPipe = 0;
        score = 0;
        yVelocity = 0;
        gameOver = false;
    }

    private void spawnPipes() {
        int pipeW = 62, pipeH = 512, gap = 160;
        int offsetY = (int) (-pipeH / 4 - Math.random() * (pipeH / 2));

        obstacles.add(new Pipe(480, offsetY, pipeW, pipeH, tPipe));
        obstacles.add(new Pipe(480, offsetY + pipeH + gap, pipeW, pipeH, bPipe));
    }

    private void update(float delta) {
        if (gameOver) return;

        timeSinceLastPipe += delta;
        if (timeSinceLastPipe > pipeSpawnInterval) {
            spawnPipes();
            timeSinceLastPipe = 0;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            yVelocity = 250;
        }

        yVelocity += gravity;
        player.y += yVelocity * delta;
        if (player.y < 0) player.y = 0;

        for (Pipe pipe : obstacles) {
            pipe.x += xVelocity * delta;
            if (!pipe.scored && pipe.x + pipe.w < player.x) {
                score += 0.5;
                pipe.scored = true;
            }

            if (pipe.collidesWith(player)) {
                gameOver = true;
            }
        }

        if (player.y > 640) {
            gameOver = true;
        }
    }

    @Override
    public void render(float delta) {
        update(delta);

        batch.begin();
        batch.draw(background, 0, 0, 480, 640);
        batch.draw(player.image, player.x, player.y, player.w, player.h);

        for (Pipe pipe : obstacles) {
            batch.draw(pipe.image, pipe.x, pipe.y, pipe.w, pipe.h);
        }

        // Optional: draw score using BitmapFont
        batch.end();
    }

    @Override public void dispose() {
        batch.dispose();
        background.dispose();
        flappy.dispose();
        bPipe.dispose();
        tPipe.dispose();
    }

    // Empty overrides
    @Override public void resize(int w, int h) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void show() {}
    @Override public void hide() {}
}
