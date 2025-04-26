package io.github.ProfCube;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PacMan {
    public int x, y;
    final Texture image;
    private int dx, dy;
    private float moveCooldown = 0.19f; // Slow down Pac-Man's movement speed
    private float moveTimer = 0f;

    public PacMan(int startX, int startY, String imagePath) {
        this.x = startX;
        this.y = startY;
        this.image = new Texture(imagePath);
        this.dx = 0;
        this.dy = 0;
    }

    public void update(float deltaTime, int[][] maze) {
        moveTimer += deltaTime;

        // Only move Pac-Man if enough time has passed to simulate slower movement
        if (moveTimer >= moveCooldown) {
            moveTimer = 0;
            move(maze);  // Move Pac-Man
        }
    }

    public void move(int[][] maze) {
        int newX = x + dx;
        int newY = y + dy;

        // Check if new position is valid (not hitting walls)
        if (newX >= 0 && newX < maze[0].length && newY >= 0 && newY < maze.length && maze[newY][newX] != 0) {
            x = newX;
            y = newY;
        }
    }

    public void setDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void resetPosition(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(image, x * 24, y * 24, 24, 24); // Scale to tile size
    }
}
