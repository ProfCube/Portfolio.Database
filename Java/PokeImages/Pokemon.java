public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private String hp;
    private String attack;
    private String defense;
    private String speed;
    private String description;
    private String imageUrl;
//    private String sID;

    // Constructor to initialize a Pokemon object
    public Pokemon(String name, String type1, String type2, String hp, String attack, String defense, String speed, String description, String imageUrl) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.description = description;
        this.imageUrl = imageUrl;
//        this.sID = sID;
    }

    // Getters for all the attributes
    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getHp() {
        return hp;
    }

    public String getAttack() {
        return attack;
    }

    public String getDefense() {
        return defense;
    }

    public String getSpeed() {
        return speed;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

//    public String getsID() {
//        return sID;
//    }
}