package main.java;

public class DeptController {
    private static UE newUE(String name, String website, String reference) {
        try {
            return new UE(name, website, reference);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString() + " UE instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    private static Class newClass(Period p, Teacher t, String room, String type) {
        try {
            return new Class(p, t, room, type);
        } catch (RuntimeException e) {
            System.out.println(e.toString() + " Class instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    private static Time newTime(int wdc, int h, int m) {
        try {
            return new Time(wdc, h, m);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString() + ". Time instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    private static Period newPeriod(Time start, Time end) {
        try {
            return new Period(start, end);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString() + ". Period instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    /**
     * Use newUE(), newClass(), newTime()
     * and newPeriod() as constructors.
     * <p>
     * Write the main here.
     */
    public static void main(String[] args) {

    }
}
