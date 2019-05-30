package jean.runoob;

abstract class Employee1 {
    private String name;
    private String address;
    private int number;

    public Employee1(String name, String address, int number) {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public double computePay() {
        System.out.println("Inside Employee computePay");
        return 0.0;
    }

    public void mailCheck() {
        System.out.println("Mailing a check to " + this.name + " " + this.address);
    }

    public String toString() {
        return name + " " + address + " " + number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return this.number;
    }
}

class Salary1 extends Employee1 {
    private double salary;

    public Salary1(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }

    public void mailCheck() {
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName() + " with salary " + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0.0) {
            this.salary = salary;
        }
    }

    public double computePay() {
        System.out.println("Computing salary pay for " + getName());
        return salary / 52;
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        Salary1 s = new Salary1("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee1 e = new Salary1("John Adams", "Bostom, MA", 2, 2400.00);

        System.out.println("Call mailCheck using Salary reference --");
        s.mailCheck();

        System.out.println("\n Call mailCheck using Employee reference --");
        e.mailCheck();
    }
}
