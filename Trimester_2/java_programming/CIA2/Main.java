public class Main {
    public static void main(String[] args) {
        Tractor tractor = new Tractor("Tractor", "Type A", "Diesel");
        tractor.setToolName("John Deere");
        System.out.println("Tool name: " + tractor.getToolName());
        tractor.manageCrop("Wheat");
        tractor.performMaintenance();
    }
}
