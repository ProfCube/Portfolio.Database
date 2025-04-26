import javax.swing.*;

public class GameFrame {

    public static void main(String[] arg){
        JFrame frame = new JFrame("Flappy Bird");
        FlappyBird gamePanel = new FlappyBird();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(flase);
        frame.setVisible(true);
    }

}