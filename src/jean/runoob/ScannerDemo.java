package jean.runoob;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
//        next();
//        nextLine();
//        demo();
        demoAverage();
    }

    public static void next() {
        Scanner scan = new Scanner(System.in);
        System.out.println("next type input: ");
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("input data is " + str1);
        }
        scan.close();
    }

    public static void nextLine() {
        Scanner scan = new Scanner(System.in);
        System.out.println("nextLine type input: ");
        if (scan.hasNextLine()) {
            String str2 = scan.nextLine();
            System.out.println("input date is " + str2);
        }
        scan.close();
    }

    public static void demo() {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        float f = 0.0f;
        System.out.print("input a int number: ");
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
            System.out.println("int number is " + i);
        } else {
            System.out.println("input data is not a int number");
        }
        System.out.print("input a float number: ");
        if (scanner.hasNextFloat()) {
            f = scanner.nextFloat();
            System.out.println("float number is " + f);
        } else {
            System.out.println("input data is not a float number");
        }
        scanner.close();
    }

    public static void demoAverage() {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int m = 0;

        while (scanner.hasNextDouble()) {
            double x = scanner.nextDouble();
            m = m + 1;
            sum = sum + x;
        }

        System.out.println(m + " count sum is " + sum);
        System.out.println(m + " coutt average is " + (sum / m));
        scanner.close();
    }
}
