package lab.lab4;

// Define interfaces
interface ShoeOperations {
    // Method to calculate the price of the shoe
    double calculatePrice(double basePrice, double taxPercentage);

    // Method to calculate discount on a shoe
    double calculateDiscount(double price, double discountPercentage);

    // General description of the shoe
    String getShoeDescription();
}

interface InventoryManagement {
    // Method to calculate inventory value
    double calculateInventoryValue(int quantity, double pricePerShoe);

    // Method to check inventory status
    String checkInventoryStatus(int quantity);

    // Method to update inventory
    void updateInventory(int quantitySold);
}

interface ExtendedOperations extends ShoeOperations {
    // Additional method to calculate profit margin
    double calculateProfit(double price, double cost);

    // Reuse the base methods from ShoeOperations
    @Override
    double calculatePrice(double basePrice, double taxPercentage);
}

// Define classes
class CasualShoes implements ShoeOperations {
    private String description;

    public CasualShoes(String description) {
        this.description = description;
    }

    @Override
    public double calculatePrice(double basePrice, double taxPercentage) {
        return basePrice + (basePrice * taxPercentage / 100);
    }

    @Override
    public double calculateDiscount(double price, double discountPercentage) {
        return price - (price * discountPercentage / 100);
    }

    @Override
    public String getShoeDescription() {
        return "Casual Shoe: " + description;
    }
}

class SportsShoes implements ShoeOperations, InventoryManagement {
    private int inventory;

    public SportsShoes(int initialInventory) {
        this.inventory = initialInventory;
    }

    @Override
    public double calculatePrice(double basePrice, double taxPercentage) {
        return basePrice + (basePrice * taxPercentage / 100);
    }

    @Override
    public double calculateDiscount(double price, double discountPercentage) {
        return price - (price * discountPercentage / 100);
    }

    @Override
    public String getShoeDescription() {
        return "Sports Shoe";
    }

    @Override
    public double calculateInventoryValue(int quantity, double pricePerShoe) {
        return quantity * pricePerShoe;
    }

    @Override
    public String checkInventoryStatus(int quantity) {
        return (quantity > 0) ? "In Stock" : "Out of Stock";
    }

    @Override
    public void updateInventory(int quantitySold) {
        inventory -= quantitySold;
    }

    public int getInventory() {
        return inventory;
    }
}

class PremiumShoes implements ExtendedOperations {
    @Override
    public double calculatePrice(double basePrice, double taxPercentage) {
        return basePrice + (basePrice * taxPercentage / 100);
    }

    @Override
    public double calculateDiscount(double price, double discountPercentage) {
        return price - (price * discountPercentage / 100);
    }

    @Override
    public double calculateProfit(double price, double cost) {
        return price - cost;
    }

    @Override
    public String getShoeDescription() {
        return "Premium Shoe";
    }
}

// Main class for demonstration
public class ShoeStore {
    public static void main(String[] args) {
        // Single interface example
        CasualShoes casualShoe = new CasualShoes("Comfortable everyday wear");
        double casualPrice = casualShoe.calculatePrice(100, 10);
        double casualDiscount = casualShoe.calculateDiscount(casualPrice, 15);
        System.out.println(casualShoe.getShoeDescription());
        System.out.println("Price after tax: $" + casualPrice);
        System.out.println("Price after discount: $" + casualDiscount);

        // Multiple interfaces example
        SportsShoes sportsShoe = new SportsShoes(50);
        double sportsPrice = sportsShoe.calculatePrice(120, 12);
        System.out.println("\nSports Shoe Inventory Value: $" + sportsShoe.calculateInventoryValue(50, sportsPrice));
        System.out.println("Inventory Status: " + sportsShoe.checkInventoryStatus(sportsShoe.getInventory()));

        // Update inventory
        sportsShoe.updateInventory(5);
        System.out.println("Updated Inventory: " + sportsShoe.getInventory());

        // Extended interface example
        PremiumShoes premiumShoe = new PremiumShoes();
        double premiumPrice = premiumShoe.calculatePrice(200, 15);
        double premiumProfit = premiumShoe.calculateProfit(premiumPrice, 150);
        System.out.println("\n" + premiumShoe.getShoeDescription());
        System.out.println("Price after tax: $" + premiumPrice);
        System.out.println("Profit per shoe: $" + premiumProfit);
    }
}
