public class HospitalManagement extends Doctorclass {
    private String name = "John Doe";
    private String department = "Cardiology";

    public void accessDoctorDetails() { 
        // Public member - accessible from any package
        System.out.println("Accessing Doctor's Name (public): " + name);

        // Protected member - accessible in subclass or package
        System.out.println("Accessing Department (protected): " + department);

        // Default (package-private) member - not accessible outside package
        // System.out.println("Accessing Hospital Name (default): " + hospitalName); // This line would cause an error

        // Private member - not accessible outside the class
        // System.out.println("Accessing Doctor ID (private): " + doctorId); // This line would cause an error
    }

    public static void main(String[] args) {
        HospitalManagement management = new HospitalManagement();
        management.accessDoctorDetails();
    }
}