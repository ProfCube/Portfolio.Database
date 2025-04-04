import java.io.*;
import java.nio.file.*;
import java.util.*;

public class PokeImage {
    private final ArrayList<PokeInfo> pokemonList = new ArrayList<>();  // ArrayList of Pokemon objects
    private final HashMap<String, PokeInfo> pokemonMap = new HashMap<>(); // HashMap to store Pokemon by name

    // This method reads the CSV file using java.nio.* and creates Pokemon objects
    public int loadFile() throws IOException {
        String filename = ".idea/pokemon.csv";
        Path path = Paths.get(filename);  // Get the Path object for the file

        // Read all lines of the CSV file into an ArrayList of Strings
        List<String> lines = Files.readAllLines(path);

        int i = 0;
        for (String line : lines) {
            String[] data = line.split(",");  // Split the line by commas

            // Create a new Pokemon object
            PokeInfo poke = new PokeInfo(
                    data[1],  // Name
                    data[9],  // Description
                    data[8]   // Image URL
            );

            // Add the Pokemon to the ArrayList
            pokemonList.add(poke);

            // Add the Pokemon to the HashMap with the name as the key
            pokemonMap.put(poke.getName(), poke);
            i++;
        }

        return i;  // Return the number of Pokémon read
    }

    // Get the Pokémon at a specific index
    public PokeInfo getPokemon(int index) {
        return pokemonList.get(index);  // Use get() to retrieve from ArrayList
    }

    // Get the total number of Pokémon
    public int getLength() {
        return pokemonList.size();  // Use size() to get the size of the ArrayList
    }

    // Method to lookup a Pokemon by name and print the details
    public void lookupPokemonByName(String name) {
        PokeInfo poke = pokemonMap.get(name);  // Use the HashMap to find the Pokemon by name
        if (poke != null) {
            System.out.println("Pokemon Name: " + poke.getName());
            System.out.println("Description: " + poke.getDescription());
            System.out.println("Image URL: " + poke.getImageUrl());
        } else {
            System.out.println("Pokemon with name " + name + " not found.");
        }
    }

    public PokeInfo getPokemonByName(String name) {
        return pokemonMap.get(name);  // This returns the PokeInfo object for the given name
    }
}