package test.java;

import main.java.Class;
import main.java.*;

public class DepartementTest {
    public static void main(String[] args) {
        Departement dept = new Departement("Fac of Science");
        System.out.println(dept.getName());

        Cursus cursus1 = new Cursus("Info Mono L2");
        UE ue1 = new UE("Math Discrete", "htttps:/mathstuff.com", "LU2IN005");
        cursus1.addUE(ue1);
        Time time2 = new Time(4, 6, 30);
        Time time3 = new Time(4, 12, 30);
        Time time4 = new Time(4, 10, 30);
        Time time5 = new Time(4, 14, 0);
        Period period3 = new Period(time2, time4);
        Period period5 = new Period(time3, time5);
        Teacher teacher = new Teacher("schneider", "pootatoo", "123456");
        main.java.Class c1 = new main.java.Class(period3, teacher, "24-25-104", "TD");
        main.java.Class c2 = new Class(period5, teacher, "14-15-401", "TME");
        ue1.createGroup(c1, c2, null);
        dept.addCursus(cursus1);
        dept.addUE(ue1);

        for (Cursus cursus : dept.getCursusList()) {
            System.out.println(cursus.toString());
        }

        assert (dept.getCursusByName("Info Mono L2") == cursus1);
        assert (dept.getUEByReference("LU2IN005") == ue1);

        System.out.println(dept.getStudentCount()); // expect 0
        Student stud1 = new Student("Nam", "nomnamnomnam", "secretpasswerd", 90834120);
        stud1.requestRegistration(dept);

        dept.processAllInscriptionDemand();

        System.out.println(dept.getStudentCount()); // expect 1
    }
}
