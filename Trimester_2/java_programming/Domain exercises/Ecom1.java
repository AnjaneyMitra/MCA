public class Ecom1 {
    public void calculateTotal(int quantity, double price) {
        double total = quantity * price;
        System.out.println("Total cost: $" + total);
    }

    public void calculateTotal(int quantity, double price, double discount) {
        double total = (quantity * price) - discount;
        System.out.println("Total cost after discount: $" + total);
    }

    public void calculateTotal(double price, int quantity) {
        double total = quantity * price;
        System.out.println("Total cost: $" + total);
    }

    public void calculateTotal(double price, int quantity, double tax) {
        double total = (quantity * price) + tax;
        System.out.println("Total cost with tax: $" + total);
    }

    public static void main(String[] args) {
        Ecom1 ecom = new Ecom1();
        ecom.calculateTotal(5, 10.0);
        ecom.calculateTotal(5, 10.0, 2.0);
        ecom.calculateTotal(10.0, 5);
        ecom.calculateTotal(10.0, 5, 1.0);
    }
}