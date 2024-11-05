// Abstract class representing a shoe
abstract class Shoe {
    protected String brand;

    // Constructor
    public Shoe(String brand) {
        this.brand = brand;
    }

    // Abstract method
    public abstract void display();

    // Method chaining example
    public Shoe setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}

// Child class inheriting from Shoe
class Sneaker extends Shoe {
    private String color;

    // Constructor chaining example
    public Sneaker(String brand, String color) {
        super(brand);
        this.color = color;
    }

    // Method overriding example
    @Override
    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
    }
}

// Test case
public class Shoe2 {
    public static void main(String[] args) {
        // Creating an instance of Sneaker
        Sneaker sneaker = new Sneaker("Nike", "Red");

        // Method chaining example
        sneaker.setBrand("Adidas").display();
    }
}