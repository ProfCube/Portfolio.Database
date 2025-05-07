package io.github.ProfCube;

import com.badlogic.gdx.graphics.Texture;

public class Pipe {
    public float x, y, w, h;
    public Texture image;
    public boolean isTop;
    public boolean scored = false;

    public Pipe(float x, float y, float w, float h, Texture image, boolean isTop) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.image = image;
        this.isTop = isTop;
    }

    public boolean collidesWith(Player player) {
        return player.x < x + w &&
            player.x + player.w > x &&
            player.y < y + h &&
            player.y + player.h > y;
    }
}
