package io.github.ProfCube;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Maze {
    public int[][] grid;
    private final int ROWS = 21;
    private final int COLS = 19;

    private Texture wallTexture;
    private Texture pelletTexture;
    private Texture powerPelletTexture;

    public Maze() {
        wallTexture = new Texture("wall.png");
        pelletTexture = new Texture("pellet.png");
        powerPelletTexture = new Texture("power_pellet.png");
        generateMaze();
    }

    public void generateMaze() {
        grid = new int[][] {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0},
            {0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,0},
            {0,1,1,1,1,0,0,1,1,3,1,1,0,0,1,1,1,1,0},
            {0,1,0,0,1,1,1,1,0,1,0,1,1,1,1,0,0,1,0},
            {0,1,0,0,1,0,0,1,0,1,0,1,0,0,1,0,0,1,0},
            {0,1,1,1,3,0,0,1,0,1,0,1,0,0,3,1,1,1,0},
            {0,1,0,0,1,0,0,1,0,1,0,1,0,0,1,0,0,1,0},
            {0,1,0,0,1,0,0,1,1,1,0,1,1,0,1,0,0,1,0},
            {0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0},
            {0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0},
            {0,1,0,1,1,0,1,1,0,1,0,1,1,0,1,1,0,1,0},
            {0,1,0,0,1,3,1,0,0,1,0,0,1,3,1,0,0,1,0},
            {0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,1,0},
            {0,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,0,1,0},
            {0,1,0,0,0,1,0,1,1,3,1,1,0,1,0,1,0,1,0},
            {0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}

        };

        // Fill the remaining rows if needed
        while (grid.length < ROWS) {
            int[] row = new int[COLS];
            for (int i = 0; i < COLS; i++) {
                row[i] = (Math.random() > 0.8) ? 3 : 1;
            }
            grid = java.util.Arrays.copyOf(grid, grid.length + 1);
            grid[grid.length - 1] = row;
        }
    }

    public void draw(SpriteBatch batch) {
        for (int y = 0; y < ROWS; y++) {
            for (int x = 0; x < COLS; x++) {
                int tile = grid[y][x];
                if (tile == 0) {
                    batch.draw(wallTexture, x * 24 - 1, y * 24 - 1, 26, 26); // Slightly bigger and centered
                } else if (tile == 1) {
                    // Draw regular pellet with smaller size (12x12)
                    batch.draw(pelletTexture, x * 24 + 10.5f, y * 24 + 10.5f, 3, 3); // Adjusting size to 12x12 and centering
                } else if (tile == 3) {
                    // Draw power pellet with smaller size (12x12)
                    batch.draw(powerPelletTexture, x * 24 + 8.5f, y * 24 + 8.5f, 7, 7); // Adjusting size to 12x12 and centering
                }
            }
        }
    }

    public int getTile(int x, int y) {
        return grid[y][x];
    }

    public void setTile(int x, int y, int value) {
        grid[y][x] = value;
    }
}
