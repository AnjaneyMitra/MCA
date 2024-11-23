public class Machine extends Tool implements Maintenance {
    private String machineType;

    public Machine(String toolName, String machineType) {
        setToolName(toolName);
        this.machineType = machineType;
    }

    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance for the machine");
    }
}