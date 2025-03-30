import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class PokeInfo {
    private JPanel panel1;
    private JButton Next;
    private JPanel pIMG;
    private JTextArea tPokeName;
    private JTextArea tType1;
    private JTextArea tType2;
    private JTextArea nHP;
    private JTextArea nAttack;
    private JTextArea nDefense;
    private JTextArea nSpeed;
    private JTextArea tDescription;
//    private JTextArea nID;

    private final PokeImages pokeImages;  // Instance of PokeImages to fetch Pokémon data
    private int currentIndex = 1;  // Index for the current Pokémon

    public PokeInfo() {
        pokeImages = new PokeImages();  // Initialize PokeImages
        try {
            pokeImages.loadFile();  // Load Pokémon data
            showPokemon(currentIndex);  // Show first Pokémon
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ActionListener for the "Next" button
        Next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Increment the currentIndex
                currentIndex++;

                // If currentIndex is greater than or equal to the length of the array, reset it to 0
                if (currentIndex >= pokeImages.getLength()) {
                    currentIndex = 1;
                }

                // Show the next Pokémon based on the currentIndex
                showPokemon(currentIndex);
            }
        });
    }

    private void showPokemon(int index) {
        Pokemon pokemon = pokeImages.getPokemon(index);

        // Set text fields with Pokémon data
        tPokeName.setText(pokemon.getName());
        tType1.setText(pokemon.getType1());
        tType2.setText(pokemon.getType2());
        nHP.setText(pokemon.getHp());
        nAttack.setText(pokemon.getAttack());
        nDefense.setText(pokemon.getDefense());
        nSpeed.setText(pokemon.getSpeed());
        tDescription.setText(pokemon.getDescription());
//       nID.setText(pokemon.getsID());

        // Load and display the image from URL
        try {
            String imageUrl = pokemon.getImageUrl();
            System.out.println(imageUrl);  // Debug: Print the URL to check

            // Check if URL is valid
            URL url = new URL(imageUrl);
            ImageIcon imageIcon = new ImageIcon(url);

            // Scale the image if necessary (resize to fit the panel)
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

            JLabel imgLabel = new JLabel(scaledImageIcon);

            // Check if pIMG is null or not set up correctly
            if (pIMG == null) {
                System.out.println("pIMG is null!");
            } else {
                System.out.println("pIMG is not null, adding image...");
            }

            // Ensure pIMG has a layout manager
            pIMG.setLayout(new FlowLayout());  // Optional: set the layout of the panel

            // Remove previous image and add new one
            pIMG.removeAll();
            pIMG.add(imgLabel);  // Add new image

            // Refresh the panel to show the image
            pIMG.revalidate();
            pIMG.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();  // Handle image loading errors
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pokemon Information");
        frame.setContentPane(new PokeInfo().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(505, 500);
        frame.setVisible(true);
    }
}