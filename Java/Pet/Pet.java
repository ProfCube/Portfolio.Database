public class Pet {
    private String name;
    private int age;


    // Default information
    public Pet(){
        this.name = "";
        this.age = 0;
    }


    // Constructor with parameters
    public Pet(String name, int age){
        this.name = name;
        this.age = age;
    }

    // Print out the pet information
    public void printPetInfo(){
        System.out.println("Your pet's name: " + name);
        System.out.println("Your pet's age: " + age);
    }


    // Method 1: Feeding your pet
    public void feedPet(){
        System.out.println("You have feed your pet 🍖 " + name);
        System.out.println("num num.. thank you!!!\n");
    }

    // Method 2: Playing with your pet
    public void playWithPet(){
        System.out.println("Your started playing fetch ⚾ with " + name + "!");
        System.out.println("ball ball... ball.\n");
    }

    // Method 3: Taking your pet for a walk
    public void walkPet(){
        System.out.println("You're walking " + name + "!\n");
    }


// THIS WILL GET THE PRIVATE VALUES
    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public void setAge(int age) {
        this.age = age;
    }
// END OF THE GET PRIVATE INFORMATION
}
