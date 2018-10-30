package jean.runoob;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT = "cat cat cat cattie cat";


    public static void main(String[] args) {
        String content = "I am noob " + "from runoob.com";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("content contain this string " + isMatch);

        String line = "This order was placed for QT3000! OK?";
        pattern = "(\\D*)(\\d+)(.*)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }

        p = Pattern.compile(REGEX);
        m = p.matcher(INPUT);
        int count = 0;
        while (m.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
            System.out.println("the count is " + count);
        }

        String regex = "foo";
        String input1 = "fooooooooooooo";
        String input2 = "ooooooooofoooooooooooooo";
        p = Pattern.compile(regex);
        Matcher m1 = p.matcher(input1);
        Matcher m2 = p.matcher(input2);
        System.out.println("Current REGEX is: " + regex);
        System.out.println("Current INPUT is: " + input1);
        System.out.println("Current INPUT2 is: " + input2);
        System.out.println("lookingAt(): " + m1.lookingAt());
        System.out.println("matches(): " + m1.matches());
        System.out.println("lookingAt(): " + m2.lookingAt());

        regex = "dog";
        input1 = "The dog says meow. " + "All dogs say meow.";
        input2 = "cat";
        p = Pattern.compile(regex);
        m = p.matcher(input1);
        input1 = m.replaceAll(input2);
        System.out.println(input1);

        regex = "a*b";
        input1 = "aabfooaabfooabfoobkkk";
        input2 = "-";
        p = Pattern.compile(regex);
        m = p.matcher(input1);
        StringBuffer stringBuffer = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(stringBuffer, input2);
        }
        m.appendTail(stringBuffer);
        System.out.println(stringBuffer.toString());
    }
}
