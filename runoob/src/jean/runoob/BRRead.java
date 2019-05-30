package jean.runoob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRRead {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input char, enter q to quit.");

        do {
            c = (char) bufferedReader.read();
            System.out.println(c);
        } while (c != 'q');

        String str;
        System.out.println("input string, enter end to quit.");
        do {
            str = bufferedReader.readLine();
            System.out.println(str);
        } while (!str.equals("end"));

        int b = 'A';
        System.out.write(123);
    }
}
