package test.java;

import main.java.Class;
import main.java.*;

public class CursusTest {
    public static void main(String[] args) {
        Cursus cursus1 = new Cursus("Info Mono L2");
        System.out.println(cursus1.getName());
        System.out.println(cursus1.getUEs());
        UE ue1 = UE.createUE("Math Discrete", "htttps:/mathstuff.com", "LU2NI005");
        cursus1.addUE(ue1);
        Time time2 = Time.createTime(4, 6, 30);
        Time time3 = Time.createTime(4, 12, 30);
        Time time4 = Time.createTime(4, 10, 30);
        Time time5 = Time.createTime(4, 14, 0);
        Period period3 = Period.createPeriod(time2, time4);
        Period period5 = Period.createPeriod(time3, time5);
        Teacher teacher = new Teacher("schneider", "pootatoo", "123456");
        main.java.Class c1 = Class.createClass(period3, teacher, "24-25-104", "TD");
        main.java.Class c2 = Class.createClass(period5, teacher, "14-15-401", "TME");
        ue1.createGroup(c1, c2, null);
        for (UE ue : cursus1.getUEs()) {
            System.out.println(ue.toString());
        }
        System.out.println(cursus1.toString());

    }
}
