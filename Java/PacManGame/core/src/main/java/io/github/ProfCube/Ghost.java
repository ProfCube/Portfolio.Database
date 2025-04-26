package io.github.ProfCube;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

public class Ghost {
    public int x, y;
    private final Texture image;
    private final Texture vulnerableImage;
    private float moveCooldown = 0.20f;
    private float moveTimer = 0f;

    public Ghost(int startX, int startY, String imagePath) {
        this.x = startX;
        this.y = startY;
        this.image = new Texture(imagePath);
        this.vulnerableImage = new Texture("ghost_vulnerable.png");
    }

    public void update(float deltaTime, int[][] maze) {
        moveTimer += deltaTime;
        if (moveTimer >= moveCooldown) {
            moveTimer = 0;
            moveRandom(maze);
        }
    }

    public void moveRandom(int[][] maze) {
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        Random rand = new Random();
        int move = rand.nextInt(4);
        int newX = x + dx[move];
        int newY = y + dy[move];
        if (newX >= 0 && newX < maze[0].length && newY >= 0 && newY < maze.length && maze[newY][newX] != 0) {
            x = newX;
            y = newY;
        }
    }

    public void resetPosition(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void draw(SpriteBatch batch, boolean isVulnerable) {
        Texture ghostImage = isVulnerable ? vulnerableImage : image;
        batch.draw(ghostImage, x * 24, y * 24, 24, 24);
    }
}
