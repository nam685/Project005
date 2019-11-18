package test.java;

import main.java.Class;
import main.java.*;

public class UETest {
    public static void main(String[] args) {
        UE ue1 = UE.createUE("Math Discrete", "htttps:/mathstuff.com", "LU2NI005");
        UE ue2 = UE.createUE("Java", "htttps:/javastuff.com", "LU2NI005");
        assert (ue1 != null);
        System.out.println(ue1.getName());
        System.out.println(ue1.getWebsite());
        System.out.println(ue1.getReference());

        Time time2 = Time.createTime(4, 6, 30);
        Time time3 = Time.createTime(4, 12, 30);
        Time time4 = Time.createTime(4, 10, 30);
        Time time5 = Time.createTime(4, 14, 0);
        Period period3 = Period.createPeriod(time2, time4);
        Period period5 = Period.createPeriod(time3, time5);
        Teacher teacher = new Teacher("schneider", "pootatoo", "123456");
        Class c1 = Class.createClass(period3, teacher, "24-25-104", "TD");
        Class c2 = Class.createClass(period5, teacher, "14-15-401", "TME");
        ue1.createGroup(c1, c2, null);
        System.out.println(ue1.getGroupList().length);
        System.out.println(ue1.getGroupByGroupNumber(1).toString());
        System.out.println(ue1.getGroupByGroupNumber(2) == null);
        System.out.println(ue1.toString());
    }
}
