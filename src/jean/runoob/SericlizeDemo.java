package jean.runoob;

import java.io.*;

class Employee2 implements java.io.Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;
    public int age;

    public void mainCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }
}

public class SericlizeDemo {
    public static void main(String[] args) {
        Employee2 e = new Employee2();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehat Peer";
        e.SSN = 11122333;
        e.number = 101;
        try {
            FileOutputStream fileOut = new FileOutputStream("D:/employee.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in D:/employee.txt");
        } catch (IOException io) {
            io.printStackTrace();
            return;
        }

        e = null;
        try {
            FileInputStream fileIn = new FileInputStream("D:/employee.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee2) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException io) {
            io.printStackTrace();
            return;
        } catch (ClassNotFoundException e1) {
            System.out.println("Employee class not found");
            e1.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee ...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }
}
