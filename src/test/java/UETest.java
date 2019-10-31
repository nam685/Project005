package test.java;

import main.java.Class;
import main.java.*;

public class UETest {
    private static UE newUE(String name, String website, String reference) {
        try {
            return new UE(name, website, reference);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString() + " UE instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    public static void main(String[] args) {
        UE ue1 = newUE("Math Discrete", "htttps:/mathstuff.com", "LU2NI005");
        UE ue2 = newUE("Java", "htttps:/javastuff.com", "LU2NI005");
        assert (ue1 != null);
        System.out.println(ue1.getName());
        System.out.println(ue1.getWebsite());
        System.out.println(ue1.getReference());

        Time time2 = new Time(4, 6, 30);
        Time time3 = new Time(4, 12, 30);
        Time time4 = new Time(4, 10, 30);
        Time time5 = new Time(4, 14, 0);
        Period period3 = new Period(time2, time4);
        Period period5 = new Period(time3, time5);
        Teacher teacher = new Teacher("schneider", "pootatoo", "123456");
        Class c1 = new Class(period3, teacher, "24-25-104", "TD");
        Class c2 = new Class(period5, teacher, "14-15-401", "TME");
        ue1.createGroup(c1, c2, null);
        System.out.println(ue1.getGroupList().length);
        System.out.println(ue1.getGroupByGroupNumber(1).toString());
        System.out.println(ue1.getGroupByGroupNumber(2) == null);
        System.out.println(ue1.toString());
    }
}
