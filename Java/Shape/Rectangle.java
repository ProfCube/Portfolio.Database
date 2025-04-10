import java.awt.Color;
import java.awt.Graphics;

// Rectangle.java
public class Rectangle extends Shape {
    protected int width;
    protected int height;

    // Default constructor with default width and height
    public Rectangle() {
        super(); // Calls the default constructor of Shape
        this.width = 0;
        this.height = 0;
    }

    // Constructor that initializes x, y, width, and height
    public Rectangle(int x, int y, int width, int height) {
        super(x, y); // Calls the Shape constructor
        this.width = width;
        this.height = height;
    }

    // Method to draw the rectangle
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        g.fillRect(x, y, width, height);
    }
}