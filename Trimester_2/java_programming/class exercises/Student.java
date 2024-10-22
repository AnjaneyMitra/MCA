public class Student{
    String name;
    int grade;

    public Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    public void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println();
    }

    public void displayGrade(){
        System.out.println("Grade: " + grade);
        System.out.println();   
    }

    public static void main(String[] args){
        Student student1 = new Student("John", 12);
        student1.displayDetails();
        student1.displayGrade();

        Student student2 = new Student("Jane", 11);
        student2.displayDetails();
        student2.displayGrade();

    }
    Student student3 = new Student("Mike", 10);
    System.out.println("Name: " + student3.name);
    System.out.println("Grade: " + student3.grade);
    student3.displayDetails();
}