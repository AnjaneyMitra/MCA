interface Shoe {
    void displayDetails();
}


class SportsShoe implements Shoe {
    private String brand;
    private double price;

    public SportsShoe(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Sports Shoe Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
    }
}

class FormalShoe implements Shoe {
    private String brand;
    private double price;

    public FormalShoe(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Formal Shoe Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
    }
}


public class inter {
    public static void main(String[] args) {

        Shoe sportsShoe = new SportsShoe("Nike", 11.000);
        Shoe formalShoe = new FormalShoe("Zara", 5.000);


        sportsShoe.displayDetails();
        System.out.println();
        formalShoe.displayDetails();
    }
}