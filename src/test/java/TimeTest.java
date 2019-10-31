package test.java;

import main.java.Time;

public class TimeTest {
    private static Time newTime(int wdc, int h, int m) {
        try {
            return new Time(wdc, h, m);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString() + ". Time instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    public static void main(String[] args) {
        Time time1 = newTime(4, 8, 45);
        Time time2 = newTime(4, 6, 30);
        Time time3 = newTime(0, 5, 3);
        Time time5 = newTime(3, 6, 6);
        Time time6 = newTime(4, 8, 61);
        Time time7 = newTime(4, 8, 45);

        assert (time1 != null);
        assert (time2 != null);
        assert (time5 != null);
        assert (time7 != null);
        System.out.println(time1.toString());
        System.out.println(time1.getHour());
        System.out.println(time1.getWeekDay());
        System.out.println(time1.getMinute());

        System.out.println(time1.compare(time7));
        System.out.println(time1.compare(time5));
        System.out.println(time1.compare(time2));
    }
}
