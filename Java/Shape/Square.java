public class Square extends Rectangle {

    // Default constructor
    public Square() {
        super(); // Calls the Rectangle constructor
    }

    // Constructor for creating a square (both width and height are the same)
    public Square(int x, int y, int length) {
        super(x, y, length, length); // Calls Rectangle constructor with equal width and height
    }
}