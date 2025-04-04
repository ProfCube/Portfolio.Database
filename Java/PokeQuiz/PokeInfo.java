public class PokeInfo {
    private String name;
    private String description;
    private String imageUrl;

    // Constructor
    public PokeInfo(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // Getter methods for each attribute
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}