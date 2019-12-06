package main.java;

public class Controller {
    /**
     * Use newUE(), newClass(), newTime()
     * and newPeriod() as constructors.
     * <p>
     * Write the main here.
     */
    public static void main(String[] args) {
        Departement dept = new Departement("Fac of Science");
        System.out.println(dept.getName());

        Cursus cursus1 = new Cursus("Info Mono L2");
        Cursus cursus2 = new Cursus("Physiques L2");
        UE ue1 = UE.createUE("Math Discrete", "htttps:/mathstuff.com", "LU2IN005");
        UE ue2 = UE.createUE("Object Oriented Programming", "htttps:/javastuff.com", "LU2IN002");
        UE ue3 = UE.createUE("Physics Stuff", "htttps:/physicsstuff.com", "LU2IN666");
        cursus1.addUE(ue1);
        cursus1.addUE(ue2);
        cursus2.addUE(ue3);
        Time time0 = Time.createTime(3, 6, 30);
        Time time1 = Time.createTime(3, 10, 30);
        Time time2 = Time.createTime(4, 6, 30);
        Time time3 = Time.createTime(4, 12, 30);
        Time time4 = Time.createTime(4, 10, 30);
        Time time5 = Time.createTime(4, 14, 0);
        Time time6 = Time.createTime(5, 6, 30);
        Time time7 = Time.createTime(5, 12, 30);
        Time time8 = Time.createTime(5, 10, 30);
        Time time9 = Time.createTime(5, 14, 0);
        Period period1 = Period.createPeriod(time0, time1);
        Period period2 = Period.createPeriod(time2, time3);
        Period period3 = Period.createPeriod(time4, time5);
        Period period4 = Period.createPeriod(time6, time7);
        Period period5 = Period.createPeriod(time8, time9);
        Teacher teacher1 = new Teacher("Mme. Schneider", "pootatoo", "123456");
        Teacher teacher2 = new Teacher("M. Guigue", "potiti", "123456");
        Teacher teacher3 = new Teacher("Micheal Jackson", "payaayaa", "123456");
        Class c1 = Class.createClass(period1, teacher1, "24-25-104", "TD");
        Class c2 = Class.createClass(period2, teacher2, "14-15-401", "TME");
        Class c3 = Class.createClass(period3, teacher3, "14-15-301", "TME");
        Class c4 = Class.createClass(period4, teacher1, "14-15-405", "Cours");
        Class c5 = Class.createClass(period5, teacher2, "14-24-401", "Cours");
        ue1.createGroup(c1, c2, null);
        ue1.createGroup(c3, null, null);
        ue2.createGroup(c4, null, c5);
        ue2.createGroup(c4, null, c5);
        ue3.createGroup(c4, null, c5);
        ue3.createGroup(c3, null, null);
        dept.addUE(ue1);
        dept.addUE(ue2);
        dept.addUE(ue3);
        dept.addCursus(cursus1);
        dept.addCursus(cursus2);

        Student student1 = new Student("Nam", "magiacni", "sgkln", 50214987);
        Student student2 = new Student("Ben", "avocadoo", "trustno1", 21149187);
        student1.requestRegistration(dept);
        student2.requestRegistration(dept);
        System.out.println(student1.getForm().getCursusName());
        System.out.println(student1.getForm().getStudentName());
        System.out.println(student1.getForm().getUEReferences());
        System.out.println(student1.getForm().getGroupNumbers());
        System.out.println(student2.getForm().getCursusName());
        System.out.println(student2.getForm().getStudentName());
        System.out.println(student2.getForm().getUEReferences());
        System.out.println(student2.getForm().getGroupNumbers());
    }
}
