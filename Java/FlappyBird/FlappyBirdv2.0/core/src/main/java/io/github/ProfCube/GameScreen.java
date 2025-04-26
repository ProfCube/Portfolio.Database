package io.github.ProfCube;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    private FlappyBirdGame game;
    private SpriteBatch batch;
    private Texture background, flappy, bPipe, tPipe;
    private BitmapFont font;

    private Player player;
    private Array<Pipe> obstacles;

    private float timeSinceLastPipe;
    private final float pipeSpawnInterval = 1.5f;

    private int xVelocity = -150; // Slower movement
    private int yVelocity = 0;
    private int gravity = -15;
    private float score = 0;
    private boolean gameOver = false;

    private final int screenWidth = 360;
    private final int screenHeight = 640;

    private OrthographicCamera camera;
    private Viewport viewport;

    public GameScreen(FlappyBirdGame game) {
        this.game = game;
        batch = new SpriteBatch();
        loadAssets();
        font = new BitmapFont();
        initializeGame();

        camera = new OrthographicCamera();
        viewport = new StretchViewport(screenWidth, screenHeight, camera);
        viewport.apply();
        camera.position.set(screenWidth / 2f, screenHeight / 2f, 0);
    }

    private void loadAssets() {
        background = new Texture("background.png");
        flappy = new Texture("flappy.png");
        bPipe = new Texture("bPipe.png");
        tPipe = new Texture("tPipe.png");
    }

    private void initializeGame() {
        player = new Player(50, screenHeight / 2, 34, 24, flappy);
        obstacles = new Array<>();
        timeSinceLastPipe = 0;
        score = 0;
        yVelocity = 0;
        gameOver = false;
    }

    private void spawnPipes() {
        int pipeW = 52;
        int pipeH = 320;
        int gap = 170; // Wider gap for easier gameplay on smaller screen

        int minCenterY = gap / 2 + 50;
        int maxCenterY = screenHeight - gap / 2 - 50;
        int centerY = minCenterY + (int)(Math.random() * (maxCenterY - minCenterY));

        int bottomPipeY = centerY - gap / 2 - pipeH;
        int topPipeY = centerY + gap / 2;

        obstacles.add(new Pipe(screenWidth, bottomPipeY, pipeW, pipeH, bPipe, false));
        obstacles.add(new Pipe(screenWidth, topPipeY, pipeW, pipeH, tPipe, true));
    }

    private void update(float delta) {
        if (gameOver) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.justTouched()) {
                initializeGame();
            }
            return;
        }

        timeSinceLastPipe += delta;
        if (timeSinceLastPipe > pipeSpawnInterval) {
            spawnPipes();
            timeSinceLastPipe = 0;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.justTouched()) {
            yVelocity = 350;
        }

        yVelocity += gravity;
        player.y += yVelocity * delta;

        // Check ground collision
        if (player.y <= 0) {
            player.y = 0;
            gameOver = true;
        }

        // Check ceiling collision
        if (player.y + player.h >= screenHeight) {
            player.y = screenHeight - player.h;
            gameOver = true;
        }

        if (yVelocity > 0) {
            player.rotation = 20;
        } else {
            player.rotation = -90 * (yVelocity / -1000f);
            if (player.rotation < -90) player.rotation = -90;
        }

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

        // Remove pipes that moved off screen
        for (int i = obstacles.size - 1; i >= 0; i--) {
            Pipe pipe = obstacles.get(i);
            if (pipe.x + pipe.w < 0) {
                obstacles.removeIndex(i);
            }
        }
    }

    @Override
    public void render(float delta) {
        update(delta);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        // Draw background
        batch.draw(background, 0, 0, screenWidth, screenHeight);

        // Draw player (with rotation)
        batch.draw(
            player.image,
            player.x + player.w / 2, player.y + player.h / 2,
            0, 0,
            player.w, player.h,
            1, 1,
            player.rotation,
            0, 0,
            player.image.getWidth(), player.image.getHeight(),
            false, false
        );

        // Draw pipes
        for (Pipe pipe : obstacles) {
            batch.draw(pipe.image, pipe.x, pipe.y, pipe.w, pipe.h);
        }

        // Draw score (small, top-left)
        font.getData().setScale(1.2f);
        font.draw(batch, "Score: " + (int)score, 20, screenHeight - 20);

        // Draw Game Over UI if needed
        if (gameOver) {
            // Game Over text
            font.getData().setScale(2f);
            String gameOverText = "Game Over!";
            float gameOverWidth = gameOverText.length() * -9f * font.getData().scaleX; // rough estimate
            font.draw(batch, gameOverText, (screenWidth - gameOverWidth) / 5f, screenHeight / 2f + 60);

            // Restart text
            font.getData().setScale(1.5f);
            String restartText = "Tap or SPACE to Restart";
            float restartWidth = restartText.length() * 1f * font.getData().scaleX; // rough estimate
            font.draw(batch, restartText, (screenWidth - restartWidth) / 5f, screenHeight / 2f + 20);
        }

        batch.end();
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(screenWidth / 2f, screenHeight / 2f, 0);
    }

    @Override public void dispose() {
        batch.dispose();
        background.dispose();
        flappy.dispose();
        bPipe.dispose();
        tPipe.dispose();
        font.dispose();
    }

    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void show() {}
    @Override public void hide() {}
}
