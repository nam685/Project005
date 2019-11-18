package test.java;

import main.java.Time;

public class TimeTest {
    public static void main(String[] args) {
        Time time1 = Time.createTime(4, 8, 45);
        Time time2 = Time.createTime(4, 6, 30);
        Time time3 = Time.createTime(0, 5, 3);
        Time time5 = Time.createTime(3, 6, 6);
        Time time6 = Time.createTime(4, 8, 61);
        Time time7 = Time.createTime(4, 8, 45);

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
