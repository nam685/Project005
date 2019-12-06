package test.java;

import main.java.Departement;
import main.java.RegistrationForm;
import main.java.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student stud1 = new Student("Nam", "nomnamnomnam", "secretpasswerd", 90834120);
        System.out.println(stud1.getStudentNumber());
        System.out.println(stud1.getLogin());
        System.out.println(stud1.getName());
        System.out.println(stud1.getPassword());
        System.out.println(stud1.getTimeTable());
        System.out.println(stud1.isRegistered());
        
        RegistrationForm form = stud1.getForm();
        Departement dept = new Departement("fac science");
        stud1.requestRegistration(dept);
        System.out.println(stud1.toString());
        
        stud1.setRegistered(true);
        System.out.println(stud1.isRegistered());
    }
}
