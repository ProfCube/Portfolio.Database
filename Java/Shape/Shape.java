import java.awt.*;

public class Shape {
    protected int x;
    protected int y;

    // Default constructor (sets x and y to 0)
    public Shape() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor with x and y coordinates
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Default method for speaking
    public void draw(Graphics g, Color c) {
        // This will be overridden in subclasses
    }
}