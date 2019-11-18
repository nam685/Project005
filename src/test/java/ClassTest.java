package test.java;

import main.java.Class;
import main.java.Period;
import main.java.Teacher;
import main.java.Time;

public class ClassTest {
    private static Class newClass(Period p, Teacher t, String room, String type) {
        try {
            return Class.createClass(p, t, room, type);
        } catch (RuntimeException e) {
            System.out.println(e.toString() + " Class instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    public static void main(String[] args) {
        Time time2 = Time.createTime(4, 6, 30);
        Time time3 = Time.createTime(4, 12, 30);
        Time time4 = Time.createTime(4, 10, 30);
        Time time5 = Time.createTime(4, 14, 0);
        Period period3 = Period.createPeriod(time2, time3);
        Period period5 = Period.createPeriod(time4, time5);
        Teacher teacher = new Teacher("schneider", "pootatoo", "123456");
        System.out.println(period3.coincides(period5));
        System.out.println(teacher.getTimeTable());
        Class c1 = newClass(period3, teacher, "24-25-104", "TD");
        Class c2 = newClass(period5, teacher, "14-15-401", "TME");
        assert (c1 != null);
        System.out.println(c1.toString());
        System.out.println(c2 == null);
        if (c2 != null) System.out.println(c2.toString());
    }
}
