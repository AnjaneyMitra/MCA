class Worker {
    String name;
    String birthDate;
    String date;


    Worker(String name, String birthDate, String date) {
        this.name = name;
        this.birthDate = birthDate;
        this.date = date;
    }


    public int getAge() {
        int age = 30; 
        System.out.println("Age is: " + age);
        return age;
    }


    public double collectPay() {
        double pay = 5000.0; 
        System.out.println("Pay is: " + pay);
        return pay;
    }


    public String terminate(String endDate) {
        System.out.println("Terminated on: " + endDate);
        return endDate;
    }
}

class Employee extends Worker {
    long employeeId;
    String hireDate;


    Employee(String name, String birthDate, String date, long employeeId, String hireDate) {
        super(name, birthDate, date);
        this.employeeId = employeeId;
        this.hireDate = hireDate;
    }
}

class SalariedEmployee extends Employee {
    double annualSalary;
    boolean isRetired;


    SalariedEmployee(String name, String birthDate, String date, long employeeId, String hireDate, double annualSalary) {
        super(name, birthDate, date, employeeId, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = false;
    }


    public void retire() {
        this.isRetired = true;
        System.out.println("Employee is retired");
    }
}

class HourlyEmployee extends Employee {
    double hourlyPayRate;


    HourlyEmployee(String name, String birthDate, String date, long employeeId, String hireDate, double hourlyPayRate) {
        super(name, birthDate, date, employeeId, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }


    public double getDoublePay() {
        double doublePay = hourlyPayRate * 2;
        System.out.println("Double pay is: " + doublePay);
        return doublePay;
    }
}

public class inh{
    public static void main(String[] args) {

        SalariedEmployee joe = new SalariedEmployee("Joe", "1980-01-01", "2020-01-01", 1, "2020-01-01", 60000);
        HourlyEmployee mary = new HourlyEmployee("Mary", "1990-01-01", "2022-01-01", 2, "2022-01-01", 25);


        joe.getAge();
        mary.getDoublePay();
        joe.retire();
    }
}
