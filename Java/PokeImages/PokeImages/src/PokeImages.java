import java.io.*;
import java.util.*;

public class PokeImages {
    private final Pokemon[] pokemonArray = new Pokemon[152];  // Array of Pokemon objects

    // This method reads the CSV file and creates Pokemon objects
    public int loadFile() throws IOException {
        String filename = "src/Resources/pokemon.csv";
        File myFile = new File(filename);
        Scanner scan = new Scanner(myFile);
        int i = 0;
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] data = line.split(",");
            // Create a new Pokemon object and add it to the array
            pokemonArray[i] = new Pokemon(
//                    data[0],  // sID
                    data[1],  // Name
                    data[2],  // Type1
                    data[3],  // Type2
                    data[4],  // HP
                    data[5],  // Attack
                    data[6],  // Defense
                    data[7],  // Speed
                    data[9],  // Description
                    data[8]   // Image URL
            );
            i++;
        }
        scan.close();
        return i;  // Return the number of Pokémon read
    }

    // Get the Pokémon at a specific index
    public Pokemon getPokemon(int index) {
        return pokemonArray[index];
    }

    // Get the total number of Pokémon
    public int getLength() {
        return pokemonArray.length;
    }
}