package test.java;

import main.java.Class;
import main.java.*;

public class GroupTest {
    public static void main(String[] args) {
        Time time2 = new Time(4, 6, 30);
        Time time3 = new Time(4, 12, 30);
        Period period3 = new Period(time2, time3);
        Teacher teacher = new Teacher("Schneider", "pootatoo", "123456");
        Class c1 = new Class(period3, teacher, "24-25-104", "TD");
        Group group1 = new Group(1);
        group1.addClass(c1);
        for (Class c : group1.getClassList()) {
            if (c != null) System.out.println(c.toString());
        }
        System.out.println(group1.getGroupNumber());
        System.out.println(group1.toString());
        Student stud1 = new Student("Nam", "nomnamnomnam", "secretpasswerd", 90834120);
        group1.addStudent(stud1);
        assert (group1.getStudentByStudentNumber(90834120) == stud1);
        for (Student stud : group1.getStudentList()) {
            if (stud != null) System.out.println(stud.toString());
        }
    }
}
