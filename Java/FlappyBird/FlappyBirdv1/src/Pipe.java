import java.awt.Image;

public class Pipe{

    public int x, y, w, h;
    public boolean scored = false;
    public Image image;

    public Pipe(int startX, int startY, int width, int height, Image img){

        this.x = startX;
        this.y = startY;
        this.w = width;
        this.h = height;
        this.image = img;

    }

}