package test.java;

import main.java.Period;
import main.java.Time;

public class PeriodTest {
    private static Period newPeriod(Time start, Time end) {
        try {
            return Period.createPeriod(start, end);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString() + ". Period instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    public static void main(String[] args) {
        Time time1 = Time.createTime(4, 8, 45);
        Time time2 = Time.createTime(4, 6, 30);
        Time time3 = Time.createTime(4, 12, 30);
        Time time4 = Time.createTime(4, 10, 30);
        Time time5 = Time.createTime(4, 14, 0);

        Period period1 = newPeriod(time1, time2);
        Period period2 = newPeriod(time1, null);
        assert (period1 == null);
        assert (period2 == null);
        Period period3 = newPeriod(time2, time4);
        Period period4 = newPeriod(time4, time3);
        assert (period3 != null);
        assert (period4 != null);
        System.out.println(period3.coincides(period4));
        Period period5 = newPeriod(time3, time5);
        System.out.println(period3.coincides(period5));
        System.out.println(period3.getStart().toString());
        System.out.println(period3.getEnd().toString());
    }
}
