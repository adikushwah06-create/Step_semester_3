package main.java.session_6.assigment_problems;

class Employee {
   
    String empName;
    double salary;

  
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

   
    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

   
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees created: " + employeeCount);
    }
}

public class Employee2Main {
    public static void main(String[] args) {
       
        new Employee("Aarav", 55000);
         new Employee("Diya", 62000);
         new Employee("Kabir", 48000);

        
        Employee.printCompanyInfo();
    }
}