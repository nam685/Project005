package test.java;


import main.java.Student;
import main.java.Teacher;

public class MemberTest {
    public static void main(String[] args) {
        Student student1 = new Student("Tom");
        Teacher teacher1 = new Teacher("Jerry");
        System.out.println(student1.getName());
        System.out.println(teacher1.getName());
    }

}
