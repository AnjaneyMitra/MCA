class Shoe {
    private String name;
    private int quantity;
    private double price;


    public Shoe() {
        this.name = "";
        this.quantity = 0;
        this.price = 0.0;
        }


    public Shoe(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        }

    public Shoe(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
            this.price = 0.0;
        }

    public Shoe(int quantity, double price) {
            this.name = "";
            this.quantity = quantity;
            this.price = price;
        }

    public Shoe(Shoe other) {
        this.name = other.name;
        this.quantity = other.quantity;
        this.price = other.price;
        }


    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
        }


    public void display(String message) {
        System.out.println(message);
        display();
        }
    }


public class Ecom2{

    public static void main(String[] args) {
        Shoe product1 = new Shoe("Product 1", 5, 10.99);
        Shoe product2 = new Shoe("Product 2", 3);
        Shoe product3 = new Shoe(2, 15.99);

        product1.display("Product 1 Details:");
        product2.display("Product 2 Details:");
        product3.display("Product 3 Details:");
    }
}