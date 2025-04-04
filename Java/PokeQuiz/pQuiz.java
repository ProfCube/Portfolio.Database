import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class pQuiz {
    private JPanel GUI;
    private JPanel pIMG;
    private JTextField pName;
    private JTextArea pDescription;

    private PokeImage pokeImage;  // Instance of PokeImage class to load Pokémon data
    private boolean pokemonDisplayed = false;  // Flag to track if the Pokémon has already been displayed
    private String currentPokemonName = "";   // Store the name of the current Pokémon being displayed

    public pQuiz() {
        // Initialize the PokeImage instance and load the CSV file
        pokeImage = new PokeImage();
        try {
            pokeImage.loadFile();  // Load the Pokémon data from the CSV
        } catch (IOException e) {
            e.printStackTrace();  // Handle potential file loading errors
        }

        // Set up the component listener to display a random Pokémon image when pIMG is resized
        pIMG.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                // Only display a random Pokémon if it's not already displayed
                if (!pokemonDisplayed) {
                    displayRandomPokemon();  // Display a random Pokémon only the first time
                }
            }
        });

        // Set the layout for the pIMG panel to use a simple FlowLayout for image display
        pIMG.setLayout(new FlowLayout(FlowLayout.CENTER));

        // ActionListener for the pName text field to check the user's input
        pName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredName = pName.getText().trim();  // Get the user's input
                if (enteredName.equalsIgnoreCase(currentPokemonName)) {
                    // Correct answer
                    pName.setText("");  // Clear the input field
                    pokemonDisplayed = false;  // Allow displaying a new Pokémon
                    displayRandomPokemon();  // Display a new random Pokémon
                } else {
                    // Incorrect answer
                    JOptionPane.showMessageDialog(GUI, "Wrong! Try again.");
                    pName.setText("");  // Clear the input field
                }
            }
        });
    }

    // Method to display a random Pokémon image and its description
    private void displayRandomPokemon() {
        Random random = new Random();
        int randomIndex = random.nextInt(pokeImage.getLength());  // Get a random index from the loaded Pokémon list
        PokeInfo randomPokemon = pokeImage.getPokemon(randomIndex);  // Fetch the Pokémon object

        try {
            // Create the image URL from the Pokémon's imageUrl
            URL url = new URL(randomPokemon.getImageUrl());
            ImageIcon pokemonImage = new ImageIcon(url);  // Convert the URL to an ImageIcon

            // Create a JLabel to display the image
            JLabel imageLabel = new JLabel(pokemonImage);

            // Remove any existing components in the pIMG panel before adding the new image
            pIMG.removeAll();  // Remove all components from the panel
            pIMG.add(imageLabel);  // Add the new image label
            pIMG.revalidate();  // Revalidate the layout
            pIMG.repaint();     // Repaint the panel to show the new image

            // Display the Pokémon's description in the JTextArea
            pDescription.setText(randomPokemon.getDescription());

            // Set the flag to true indicating that a Pokémon has been displayed
            pokemonDisplayed = true;

            // Store the name of the displayed Pokémon for comparison
            currentPokemonName = randomPokemon.getName();

        } catch (Exception e) {
            e.printStackTrace();  // Handle any potential URL/image errors
        }
    }

    public static void main(String[] args) {
        // Initialize the JFrame and display the GUI
        JFrame frame = new JFrame("Pokemon Quiz");
        pQuiz quiz = new pQuiz();
        frame.setContentPane(quiz.GUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(505, 300);
        frame.setVisible(true);
    }
}