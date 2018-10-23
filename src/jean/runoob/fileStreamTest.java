package jean.runoob;

import java.io.*;

public class fileStreamTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1(){
        byte bWrite[] = {11, 21, 3, 40, 5};
        try {
            OutputStream os = new FileOutputStream("test.txt");
            for (int x = 0; x < bWrite.length; x++){
                os.write(bWrite[x]);
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();
            for (int i = 0; i < size; i++){
                System.out.println((char) is.read() + " ");
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void test2(){
        File f = new File("a.txt");
        try {
            FileOutputStream fop = new FileOutputStream(f);
            OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
            writer.append("中文输入");
            writer.append("\r\n");
            writer.append("English");
            writer.close();
            fop.close();

            FileInputStream fip = new FileInputStream(f);
            InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
            StringBuffer sb = new StringBuffer();
            while (reader.ready()){
                sb.append((char)reader.read());
            }
            System.out.println(sb.toString());
            reader.close();
            fip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
