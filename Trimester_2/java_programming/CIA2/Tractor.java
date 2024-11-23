public class Tractor extends Machine implements CropManagement {
    private String fuelType;

    public Tractor(String toolName, String machineType, String fuelType) {
        super(toolName, machineType);
        this.fuelType = fuelType;
    }

    @Override
    public void manageCrop(String cropType) {
        System.out.println("Managing crop: " + cropType + " using the tractor");
    }
}
