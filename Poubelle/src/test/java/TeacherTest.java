package test.java;

import main.java.Period;
import main.java.Teacher;
import main.java.Time;

public class TeacherTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("schneider", "pootatoo", "123456");
        System.out.println(teacher.getName());
        System.out.println(teacher.getLogin());
        System.out.println(teacher.getPassword());
        teacher.setLogin("blobby");
        teacher.setPassword("pluppy");
        System.out.println(teacher.getLogin());
        System.out.println(teacher.getPassword());
        System.out.println(teacher.getTimeTable());
        Time time2 = Time.createTime(4, 6, 30);
        Time time4 = Time.createTime(4, 10, 30);
        Period period3 = Period.createPeriod(time2, time4);
        teacher.addPeriod(period3);
        teacher.addPeriod(period3);
        System.out.println(teacher.getTimeTable());

    }
}
