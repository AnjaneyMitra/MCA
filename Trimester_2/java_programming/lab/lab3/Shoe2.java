abstract class Shoe {
    protected String brand;


    public Shoe(String brand) {
        this.brand = brand;
    }


    public abstract void display();


    public Shoe setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}


class Sneaker extends Shoe {
    private String color;


    public Sneaker(String brand, String color) {
        super(brand);
        this.color = color;
    }


    @Override
    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
    }
}


public class Shoe2 {
    public static void main(String[] args) {

        Sneaker sneaker = new Sneaker("Nike", "Red");

        sneaker.setBrand("Adidas").display();
    }
}
