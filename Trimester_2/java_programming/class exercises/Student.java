public class Student {
    private String name;
    public int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public void displayDetails() {
        System.out.println("Student's name: " + name);
    }

   
    public static void main(String[] args) {
        Student student = new Student("John", 90);

        System.out.println("Student's name (accessed directly): " + student.name);

        student.displayDetails();
    }
}