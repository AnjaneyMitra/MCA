class ShoeStore {
    private int stock = 10; 


    public synchronized void buyShoe(String customerName) {
        if (stock == 0) {
            System.out.println(customerName + " is waiting for restock...");
            try {
                wait(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stock--;
        System.out.println(customerName + " bought a pair of shoes. Remaining stock: " + stock);
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void buyWithoutSync(String customerName) {
        if (stock > 0) {
            stock--;
            System.out.println(customerName + " (non-synchronized) bought a pair of shoes. Remaining stock: " + stock);
        } else {
            System.out.println(customerName + " (non-synchronized) found no stock available.");
        }
    }


    public synchronized void restock(int quantity) {
        stock += quantity;
        System.out.println("Stock replenished. Current stock: " + stock);
        notifyAll(); // Notify all waiting threads
    }
}

class Customer extends Thread {
    private final ShoeStore store;
    private final String customerName;

    public Customer(ShoeStore store, String customerName) {
        this.store = store;
        this.customerName = customerName;
    }

    @Override
    public void run() {

        store.buyShoe(customerName);

        store.buyWithoutSync(customerName);
    }
}

class ShoeStockManager extends Thread {
    private final ShoeStore store;

    public ShoeStockManager(ShoeStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        store.restock(5);
    }
}

public class ShoeStoreDemo {
    public static void main(String[] args) {
        ShoeStore store = new ShoeStore();


        Thread customer1 = new Customer(store, "Customer 1");
        Thread customer2 = new Customer(store, "Customer 2");
        Thread customer3 = new Customer(store, "Customer 3");
        Thread customer4 = new Customer(store, "Customer 4");
        Thread customer5 = new Customer(store, "Customer 5");


        Thread stockManager = new ShoeStockManager(store);


        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();


        stockManager.start();
    }
}
