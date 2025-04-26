import java.awt.Image;

public class Player {

    public int x, y, w, h;
    public Image image;

    public Player (int startX, int startY, int width, int height, Image img) {

        this.x = startX;
        this.y = startY;
        this.w = width;
        this.h = height;
        this.image = img;

    }

}