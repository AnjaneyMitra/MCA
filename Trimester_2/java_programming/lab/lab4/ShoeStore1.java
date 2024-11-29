// Main package
package lab.lab4;

// Utility class
class PriceCalculator {
    // Static method to calculate final price with tax
    public static double calculateFinalPrice(double basePrice, double taxPercentage) {
        return basePrice + (basePrice * taxPercentage / 100);
    }

    // Static method to calculate price after discount
    public static double calculateDiscountedPrice(double price, double discountPercentage) {
        return price - (price * discountPercentage / 100);
    }
}

// Base class
class Shoe {
    // Package-private fields
    String brand;
    String size;

    // Constructor
    public Shoe(String brand, String size) {
        this.brand = brand;
        this.size = size;
    }

    // Public method to display details
    public String getDetails() {
        return "Brand: " + brand + ", Size: " + size;
    }

    // Protected method for subclasses
    protected void displayShoeInfo() {
        System.out.println("Shoe Info: " + getDetails());
    }
}

// Interface for shoe operations
interface ShoeOperations {
    double calculatePrice(double taxPercentage);
    double calculateDiscount(double price, double discountPercentage);
}

// Interface for inventory management
interface InventoryManagement {
    double calculateInventoryValue();
    String getInventoryStatus();
}

// Subclass 1: CasualShoe
class CasualShoe extends Shoe {
    private String style;

    // Constructor
    public CasualShoe(String brand, String size, String style) {
        super(brand, size);
        this.style = style;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Style: " + style;
    }
}

// Subclass 2: SportsShoe implements multiple interfaces
class SportsShoe extends Shoe implements ShoeOperations, InventoryManagement {
    private double basePrice;
    private int inventory;

    // Constructor
    public SportsShoe(String brand, String size, double basePrice, int inventory) {
        super(brand, size);
        this.basePrice = basePrice;
        this.inventory = inventory;
    }

    // Implementation of ShoeOperations
    @Override
    public double calculatePrice(double taxPercentage) {
        return PriceCalculator.calculateFinalPrice(basePrice, taxPercentage);
    }

    @Override
    public double calculateDiscount(double price, double discountPercentage) {
        return PriceCalculator.calculateDiscountedPrice(price, discountPercentage);
    }

    // Implementation of InventoryManagement
    @Override
    public double calculateInventoryValue() {
        return inventory * basePrice;
    }

    @Override
    public String getInventoryStatus() {
        return inventory > 0 ? "In Stock" : "Out of Stock";
    }

    // Override method
    @Override
    public String getDetails() {
        return super.getDetails() + ", Price: $" + basePrice + ", Inventory: " + inventory;
    }
}

// Subclass 3: PremiumShoe with additional functionality
class PremiumShoe extends Shoe {
    private double costPrice;

    // Constructor
    public PremiumShoe(String brand, String size, double costPrice) {
        super(brand, size);
        this.costPrice = costPrice;
    }

    // Protected method to display premium shoe info
    @Override
    protected void displayShoeInfo() {
        super.displayShoeInfo();
        System.out.println("Cost Price: $" + costPrice);
    }
}

// Main class to demonstrate functionality
public class ShoeStore1 {
    public static void main(String[] args) {
        // Casual Shoe Example
        CasualShoe casualShoe = new CasualShoe("Nike", "42", "Sneakers");
        System.out.println("Casual Shoe Details: " + casualShoe.getDetails());

        // Sports Shoe Example
        SportsShoe sportsShoe = new SportsShoe("Adidas", "44", 120, 50);
        double sportsPrice = sportsShoe.calculatePrice(10);
        double sportsDiscount = sportsShoe.calculateDiscount(sportsPrice, 15);
        System.out.println("\nSports Shoe Details: " + sportsShoe.getDetails());
        System.out.println("Price after Tax: $" + sportsPrice);
        System.out.println("Price after Discount: $" + sportsDiscount);
        System.out.println("Inventory Value: $" + sportsShoe.calculateInventoryValue());
        System.out.println("Inventory Status: " + sportsShoe.getInventoryStatus());

        // Premium Shoe Example
        PremiumShoe premiumShoe = new PremiumShoe("Gucci", "41", 500);
        System.out.println("\nPremium Shoe Details:");
        premiumShoe.displayShoeInfo();
    }
}
