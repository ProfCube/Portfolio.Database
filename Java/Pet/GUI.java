import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel GUI;
    private JButton Play;
    private JButton Feed;
    private JButton Walk;
    private JLabel Name;
    private JLabel Age;
    private JLabel Timer;
    private JLabel imgLabel;
    private JPanel Panel; // Placeholder for image to show better nothing to call upon it
    private javax.swing.Timer timer;
    /* Create an object of class Pet to connect to Pet.java class */
    private Pet p = new Pet();

    private int timeElapsed = 0;

    public void rName() {
        String name = JOptionPane.showInputDialog(GUI, "Enter your pet's name:");
        if (name != null && !name.isEmpty()){
            Name.setText("Pet's Name: " + name);
            p.setName(name);
        } else {
            Name.setText("Pet's Name: Unknown");
        }
    }

    public void rAge() {
        String ageInput = JOptionPane.showInputDialog(GUI, "Enter your pet's age:");
        if (ageInput != null && !ageInput.isEmpty()){
            try {
                int age = Integer.parseInt(ageInput);
                Age.setText("Pet's Age: " + age + " yrs");
                p.setAge(age);
            } catch (NumberFormatException e) {
                Age.setText("Pet's Age: Invalid input");
            }
        } else {
            Age.setText("Pet's Age: Unknown");
        }
    }

    public void initTimer() {
        ActionListener timerTick = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeElapsed++;

                Timer.setText("Time: " + timeElapsed + " seconds");

                if (timeElapsed >= 10){
                    ImageIcon img = new ImageIcon("Resources/question.png");  // Replace with the actual path to your GIF
                    Image scaledImg = img.getImage().getScaledInstance(500, 410, Image.SCALE_SMOOTH); // Scale the image
                    imgLabel.setIcon(new ImageIcon(scaledImg));
                } if (timeElapsed >= 20){
                    ImageIcon img = new ImageIcon("Resources/hungry.png");  // Replace with the actual path to your GIF
                    Image scaledImg = img.getImage().getScaledInstance(500, 410, Image.SCALE_SMOOTH); // Scale the image
                    imgLabel.setIcon(new ImageIcon(scaledImg));
                } if (timeElapsed >= 30){
                    ImageIcon img = new ImageIcon("Resources/question.png");  // Replace with the actual path to your GIF
                    Image scaledImg = img.getImage().getScaledInstance(500, 410, Image.SCALE_SMOOTH); // Scale the image
                    imgLabel.setIcon(new ImageIcon(scaledImg));
                } if (timeElapsed >= 45) {
                    ImageIcon img = new ImageIcon("Resources/happy.png");  // Replace with the actual path to your GIF
                    Image scaledImg = img.getImage().getScaledInstance(500, 410, Image.SCALE_SMOOTH); // Scale the image
                    imgLabel.setIcon(new ImageIcon(scaledImg));
                } if (timeElapsed >= 55){
                    ImageIcon img = new ImageIcon("Resources/loved.png");  // Replace with the actual path to your GIF
                    Image scaledImg = img.getImage().getScaledInstance(500, 410, Image.SCALE_SMOOTH); // Scale the image
                    imgLabel.setIcon(new ImageIcon(scaledImg));
                } else{
                    return;
                }
            }};
        timer = new Timer(1000, timerTick);
        timer.start();
    }

    public GUI() {
        initTimer();
        rName();
        rAge();

        ImageIcon img = new ImageIcon("Resources/normal.png");  // Replace with the actual path to your GIF
        Image scaledImg = img.getImage().getScaledInstance(500, 410, Image.SCALE_SMOOTH); // Scale the image
        imgLabel.setIcon(new ImageIcon(scaledImg));



        Feed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.feedPet();
                ImageIcon img = new ImageIcon("Resources/eating.png");  // Replace with the actual path to your GIF
                Image scaledImg = img.getImage().getScaledInstance(500, 410, Image.SCALE_SMOOTH); // Scale the image
                imgLabel.setIcon(new ImageIcon(scaledImg));
            }
        });
        Play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.playWithPet();
                ImageIcon img = new ImageIcon("Resources/play2.png");  // Replace with the actual path to your GIF
                Image scaledImg = img.getImage().getScaledInstance(500, 410, Image.SCALE_SMOOTH); // Scale the image
                imgLabel.setIcon(new ImageIcon(scaledImg));
            }
        });
        Walk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.walkPet();
                ImageIcon img = new ImageIcon("Resources/walking.png");  // Replace with the actual path to your GIF
                Image scaledImg = img.getImage().getScaledInstance(500, 410, Image.SCALE_SMOOTH); // Scale the image
                imgLabel.setIcon(new ImageIcon(scaledImg));            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().GUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(505,500);
        frame.setVisible(true);
    }

    public Pet getP() {
        return p;
    }

    public void setP(Pet p) {
        this.p = p;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(int timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
