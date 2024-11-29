class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " with priority " +
                           Thread.currentThread().getPriority() + " is starting.");
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running: " + i);
            try {
                Thread.sleep(500); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is ending.");
    }
}

public class ThreadPriority5 {
    public static void main(String[] args) {
        // Create threads
        PriorityThread t1 = new PriorityThread("LowPriorityThread");
        PriorityThread t2 = new PriorityThread("HighPriorityThread");
        PriorityThread t3 = new PriorityThread("NormalPriorityThread");

        // Set priorities
        t1.setPriority(Thread.MIN_PRIORITY); // Priority 1
        t2.setPriority(Thread.MAX_PRIORITY); // Priority 10
        t3.setPriority(Thread.NORM_PRIORITY); // Priority 5

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}