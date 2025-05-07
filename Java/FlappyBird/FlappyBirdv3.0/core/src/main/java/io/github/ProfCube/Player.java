package io.github.ProfCube;

import com.badlogic.gdx.graphics.Texture;

public class Player {
    public float x, y;
    public int w, h;
    public Texture image;
    public float rotation = 0; // NEW!

    public Player(float x, float y, int w, int h, Texture image) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.image = image;
    }
}
