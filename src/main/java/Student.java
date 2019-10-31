package main.java;

public class Student extends Member {
    private int studentNumber;
    private boolean isRegistered;
    private RegistrationForm form;

    public Student(String name, String login, String password, int studentNumber) {
        super(name, login, password);
        this.studentNumber = studentNumber;
        this.isRegistered = false;
        this.form = new RegistrationForm();
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public RegistrationForm getForm() {
        return form;
    }

    public void requestRegistration(Departement dept) {
        if (form.getStudentName() == null || form.getStudentNumber() == 0 || form.getCursusName() == null) {
            System.out.println("Did you forget to fill the form before submitting it?");
            return;
        }
        dept.addUnregisteredStudent(this);
        dept.addRegistrationDemand(this.form);
    }

    public String toString() {
        return "Student " + studentNumber + ". Name: " + getName() + ". Registered: " + isRegistered();
    }
}
