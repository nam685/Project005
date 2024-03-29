//package main.java;

public class Group {
    private static final int MAX_STUDENT = 36;
    private static final int MAX_CLASS = 3;
    private Student[] studentList;
    private int nbStudent;
    private Class[] classList;
    private int nbClass;
    private int groupNumber;

    public Group(int groupNumber) {
        this.groupNumber = groupNumber;
        this.nbClass = 0;
        this.nbStudent = 0;
        this.studentList = new Student[MAX_STUDENT];
        this.classList = new Class[MAX_CLASS];
    }

    public void addClass(Class c) {
        if (nbClass < MAX_CLASS && c != null) this.classList[nbClass++] = c;
    }

    public void addStudent(Student student) throws RuntimeException {
        for (Class p1 : classList) {
            if (p1 != null) {
                for (Period p2 : student.getTimeTable()) {
                    if (p1.getPeriod().coincides(p2)) throw new RuntimeException("Student busy.");
                }
            }
        }
        if (nbStudent >= MAX_STUDENT) throw new RuntimeException("Class full.");
        this.studentList[nbStudent++] = student;
        for (Class p : classList) {
            if (p != null) student.addPeriod(p.getPeriod());
        }
    }

    public Student[] getStudentList() {
        return studentList;
    }

    public Student getStudentByStudentNumber(int studentNumber) {
        for (Student student : studentList) {
            if (student.getStudentNumber() == studentNumber) return student;
        }
        return null;
    }

    public Class[] getClassList() {
        return classList;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    @Override
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Group number ").append(groupNumber).append(". Classes:\n");
        for (int i = 0; i < nbClass; i++) {
            s.append("Class ").append(i + 1).append(": ").append(classList[i].toString()).append("\n");
        }
        return s.toString();
    }
}
