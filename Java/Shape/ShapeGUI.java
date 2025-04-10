import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapeGUI {
    private JPanel panel1;
    private JButton bSquare;
    private JButton bRectangle;
    private JButton bClear;
    private JTextField yInput;
    private JTextField hInput;
    private JTextField xInput;
    private JTextField wInput;
    private JPanel bDrawings;

    // Variables for mouse position
    private int x = 0, y = 0, x2 = 0, y2 = 0;

    // Create drawing panel with overridden paintComponent
    private void createUIComponents() {
        bDrawings = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };
        bDrawings.setBackground(Color.WHITE);
    }

    public ShapeGUI() {
        // Rectangle button action
        bRectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int width = Integer.parseInt(wInput.getText());
                    int height = Integer.parseInt(hInput.getText());

                    Rectangle rect = new Rectangle(x, y, width, height);
                    Graphics g = bDrawings.getGraphics();
                    rect.draw(g, Color.RED);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel1, "Please enter valid numbers!");
                }
            }
        });

        // Square button action
        bSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int length = Integer.parseInt(wInput.getText());

                    Square square = new Square(x, y, length);
                    Graphics g = bDrawings.getGraphics();
                    square.draw(g, Color.BLUE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel1, "Please enter a valid number!");
                }
            }
        });

        // Clear button action
        bClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bDrawings.repaint();
                xInput.setText("");
                yInput.setText("");
                wInput.setText("");
                hInput.setText("");

            }
        });

        // Add MouseListener to get initial x/y from clicks
        bDrawings.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                // Update textFields to show the coordinates
                xInput.setText(String.valueOf(x));
                yInput.setText(String.valueOf(y));
            }
        });

        // Add MouseMotionListener for line drawing
        bDrawings.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();

                Graphics g = bDrawings.getGraphics();
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x2, y2);
            }
        });
    }

    // Main method (generated via GUI Form right-click)
    public static void main(String[] args) {
        JFrame frame = new JFrame("ShapeGUI");
        frame.setContentPane(new ShapeGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);  // Manually set size
        frame.setVisible(true);
    }
}