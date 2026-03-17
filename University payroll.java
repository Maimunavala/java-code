1️⃣ University Payroll Management (Multilevel Inheritance)
Concept Used

Multilevel Inheritance

Method Overriding

Polymorphism (Array of parent class)

Hierarchy:

Person
   ↓
Employee
   ↓
TeachingStaff
Step 1: Person Class

Base class containing common information.

class Person {

    int id;
    String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
Explanation

id → employee ID

name → employee name

Constructor initializes values.

Step 2: Employee Class

Employee extends Person.

class Employee extends Person {

    double basicSalary;

    Employee(int id, String name, double basicSalary) {
        super(id, name);
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;

        return basicSalary + hra + da;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}
Explanation

super() calls Person constructor

Salary formula

salary = basic + HRA + DA
Step 3: TeachingStaff Class
class TeachingStaff extends Employee {

    String subject;
    double researchAllowance;

    TeachingStaff(int id, String name, double basicSalary,
                  String subject, double researchAllowance) {

        super(id, name, basicSalary);
        this.subject = subject;
        this.researchAllowance = researchAllowance;
    }

    @Override
    double calculateSalary() {

        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;

        return basicSalary + hra + da + researchAllowance;
    }

    void display() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Subject: " + subject);
        System.out.println("Salary: " + calculateSalary());
    }
}
TeachingStaff Salary
salary = basic + HRA + DA + researchAllowance
Step 4: Main Class
public class PayrollSystem {

    public static void main(String[] args) {

        Employee[] emp = new Employee[5];

        emp[0] = new Employee(1, "Amit", 30000);
        emp[1] = new TeachingStaff(2, "Neha", 40000, "Java", 5000);
        emp[2] = new Employee(3, "Ravi", 28000);
        emp[3] = new TeachingStaff(4, "Meena", 45000, "Python", 6000);
        emp[4] = new Employee(5, "Rahul", 35000);

        System.out.println("------ Payroll Report ------");

        for (Employee e : emp) {
            e.display();
            System.out.println();
        }
    }
}
Output Example
------ Payroll Report ------

ID: 1
Name: Amit
Salary: 39000

ID: 2
Name: Neha
Subject: Java
Salary: 59000