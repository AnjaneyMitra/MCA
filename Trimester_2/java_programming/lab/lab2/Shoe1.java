class Shoe {
    int ShoeID;
    String name;

    void show() {
        System.out.println("Shoe ID & name: " + ShoeID + " " + name);
    }

    void sum() {
        System.out.println("Base price calculation (no price or quantity available in Shoe class).");
    }
}

class Nike extends Shoe {
    int price;
    int quantity;

    @Override
    void show() {
        super.show();
        System.out.println("Nike shoe price: " + price);
    }

    @Override
    void sum() {
        System.out.println("Order Total for Nike: " + (price * quantity));
    }
}

class Jordan extends Nike {
    int specialPrice;

    @Override
    void show() {
        super.show();
        System.out.println("Jordan special price: " + specialPrice);
    }

    @Override
    void sum() {
        System.out.println("Order Total for Jordan: " + (specialPrice * quantity));
    }
}

class Shipping extends Jordan {
    String locality;
    double shippingCost;

    public Shipping(String locality) {
        this.locality = locality;
    }

    public double calculateShippingCost() {
        if (locality.equals("Local")) {
            shippingCost = 50.0;
        } else if (locality.equals("National")) {
            shippingCost = 100.0;
        } else if (locality.equals("International")) {
            shippingCost = 200.0;
        } else {
            shippingCost = 0.0;
        }
        return shippingCost;
    }

    @Override
    void sum() {
        double totalShippingCost = calculateShippingCost();
        System.out.println("Order Total for Jordan with shipping: " + (specialPrice * quantity + totalShippingCost));
    }
}

public class Shoe1 {
    public static void main(String args[]) {
        Shoe SuperObj = new Shoe();
        Nike SubObj1 = new Nike();
        Jordan SubObj2 = new Jordan();
        Shipping SubObj3 = new Shipping("Local");

        SuperObj.ShoeID = 1;
        SuperObj.name = "Airmax";
        System.out.println("Contents of SuperObj:");
        SuperObj.show();
        SuperObj.sum();
        System.out.println();

        SubObj1.ShoeID = 2;
        SubObj1.name = "Nike Runner";
        SubObj1.price = 10000;
        SubObj1.quantity = 2;
        System.out.println("Contents of SubObj1:");
        SubObj1.show();
        SubObj1.sum();
        System.out.println();

        SubObj2.ShoeID = 3;
        SubObj2.name = "Jordan Retro";
        SubObj2.specialPrice = 15000;
        SubObj2.quantity = 2;
        System.out.println("Contents of SubObj2:");
        SubObj2.show();
        SubObj2.sum();
        System.out.println();

        SubObj3.ShoeID = 4;
        SubObj3.name = "Jordan High";
        SubObj3.specialPrice = 20000;
        SubObj3.quantity = 1;
        System.out.println("Contents of SubObj3:");
        SubObj3.show();
        SubObj3.sum();
    }
}
