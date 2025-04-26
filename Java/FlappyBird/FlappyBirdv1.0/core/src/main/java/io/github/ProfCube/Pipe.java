package io.github.ProfCube;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Pipe {
    public float x, y;
    public int w, h;
    public boolean scored = false;
    public Texture image;

    public Pipe(float x, float y, int w, int h, Texture image) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.image = image;
    }

    public boolean collidesWith(Player p) {
        Rectangle pipeRect = new Rectangle(x, y, w, h);
        Rectangle playerRect = new Rectangle(p.x, p.y, p.w, p.h);
        return pipeRect.overlaps(playerRect);
    }
}
