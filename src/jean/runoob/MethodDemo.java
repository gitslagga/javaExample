package jean.runoob;

public class MethodDemo {
    public static void main(String[] args) {
        Operator operator1 = new Operator(1);
        Operator operator2 = new Operator(2);

        System.out.println("The num1 value is " + operator1.number + " num2 value is " + operator2.number);
        swap(operator1, operator2);
        System.out.println("After swap num1 value is " + operator1.number + " num2 value is " + operator2.number);

        //command line
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);
        }

        printMax(34, 3, 3, 2, 56.2);
        printMax(new double[]{1, 2, 3});
    }

    public static void swap(Operator num1, Operator num2) {
        int temp = num1.number;
        num1.number = num2.number;
        num2.number = temp;
    }

    public static void printMax(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed");
            return;
        }

        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > result) {
                result = numbers[i];
            }
        }

        System.out.println("The max value is " + result);
    }
}

class Operator {
    int number;

    Operator(int num) {
        number = num;
    }
}
