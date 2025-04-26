package io.github.ProfCube;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.ArrayList;
import java.util.List;

public class GameScreen {

    private SpriteBatch batch;
    private PacMan pacman;
    private Maze maze;
    private List<Ghost> ghosts;
    private int score;
    private int lives;
    private boolean ghostsVulnerable = false;
    private long vulnerableStartTime;

    private BitmapFont font;  // Font to display the score

    public GameScreen() {
        batch = new SpriteBatch();
        maze = new Maze();
        pacman = new PacMan(1, 1, "pacman.png");

        ghosts = new ArrayList<>();
        ghosts.add(new Ghost(17, 1, "ghost_red.png"));
        ghosts.add(new Ghost(1, 18, "ghost_pink.png"));
        ghosts.add(new Ghost(17, 18, "ghost_cyan.png"));
        ghosts.add(new Ghost(9, 10, "ghost_orange.png"));
        ghosts.add(new Ghost(1, 1, "ghost_purple.png"));

        score = 0;
        lives = 4;

        // Initialize BitmapFont for score display
        font = new BitmapFont();
        font.getData().setScale(2);  // Optional: Scale the font size if needed
    }

    public void render() {
        if (lives <= 0) {
            System.out.println("Game Over! Final Score: " + score);
            return;
        }

        // Clear screen to remove any leftover trails
        Gdx.gl.glClearColor(0, 0, 0, 1); // Black background
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen

        update();  // Game update logic
        draw();    // Draw the updated game objects
    }

    private void update() {
        if (Gdx.input.isKeyPressed(Keys.LEFT)) pacman.setDirection(-1, 0);
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) pacman.setDirection(1, 0);
        if (Gdx.input.isKeyPressed(Keys.UP)) pacman.setDirection(0, 1);
        if (Gdx.input.isKeyPressed(Keys.DOWN)) pacman.setDirection(0, -1);

        pacman.update(Gdx.graphics.getDeltaTime(), maze.grid);

        for (Ghost ghost : ghosts) {
            ghost.update(Gdx.graphics.getDeltaTime(), maze.grid);
        }

        // Check if Pac-Man eats any pellets
        if (maze.getTile(pacman.x, pacman.y) == 1) {
            maze.setTile(pacman.x, pacman.y, 2); // Pellet eaten
            score += 20;
        }

        // Check for power pellets
        if (maze.getTile(pacman.x, pacman.y) == 3) {
            maze.setTile(pacman.x, pacman.y, 2); // Power pellet eaten
            score += 25;
            ghostsVulnerable = true;
            vulnerableStartTime = System.currentTimeMillis();
        }

        // Check for collisions with ghosts
        for (Ghost ghost : ghosts) {
            if (pacman.x == ghost.x && pacman.y == ghost.y) {
                if (ghostsVulnerable) {
                    score += 100;
                    ghost.resetPosition(1, 1); // Reset ghost position
                } else {
                    lives--;
                    pacman.resetPosition(1, 1); // Reset Pac-Man position
                    for (Ghost g : ghosts) g.resetPosition(17, 1); // Reset ghosts
                }
            }
        }

        // Check if ghosts are vulnerable for 30 seconds
        if (ghostsVulnerable && System.currentTimeMillis() - vulnerableStartTime > 30000) {
            ghostsVulnerable = false;
        }
    }

    private void draw() {
        batch.begin();
        maze.draw(batch); // Draw the maze
        pacman.draw(batch); // Draw Pac-Man
        for (Ghost ghost : ghosts) {
            ghost.draw(batch, ghostsVulnerable); // Draw ghosts
        }

        // Draw the score on the right side of the screen
        float scoreX = Gdx.graphics.getWidth() - 187;  // Position it 150px from the right edge
        font.draw(batch, "Score: " + score, scoreX, Gdx.graphics.getHeight() - 10);  // Display score at the top-right

        // Draw lives horizontally below the score on the right side
        float livesX = scoreX;  // Align lives with the score
        float livesY = Gdx.graphics.getHeight() - 70;  // Position the lives below the score

        for (int i = 0; i < lives; i++) {
            batch.draw(pacman.image, livesX + (i * 30), livesY, 24, 24);  // Draw each life horizontally
        }

        batch.end();
    }


    public void dispose() {
        batch.dispose();
        font.dispose();  // Dispose font when done
    }
}
