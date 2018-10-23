package jean.runoob;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarDemo {

    public static void main(String[] args) {
        String months[] = {
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };

        int year;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        System.out.println("Date: ");
        System.out.println(months[gregorianCalendar.get(Calendar.MONTH)]);
        System.out.println(" " + gregorianCalendar.get(Calendar.DATE) + " ");
        System.out.println(year = gregorianCalendar.get(Calendar.YEAR));
        System.out.println("Time: ");
        System.out.println(gregorianCalendar.get(Calendar.HOUR) + ":");
        System.out.println(gregorianCalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gregorianCalendar.get(Calendar.SECOND));

        if (gregorianCalendar.isLeapYear(year)){
            System.out.println("当年是闰年");
        } else {
            System.out.println("当年不是闰年");
        }
    }
}
