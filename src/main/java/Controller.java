package main.java;

public class Controller {
    private static UE newUE(String name, String website, String reference) {
        try {
            return new UE(name, website, reference);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString() + " UE instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    private static Class newClass(Period p, Teacher t, String room, String type) {
        try {
            return new Class(p, t, room, type);
        } catch (RuntimeException e) {
            System.out.println(e.toString() + " Class instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    private static Time newTime(int wdc, int h, int m) {
        try {
            return new Time(wdc, h, m);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString() + ". Time instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    private static Period newPeriod(Time start, Time end) {
        try {
            return new Period(start, end);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString() + ". Period instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

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
        UE ue1 = newUE("Math Discrete", "htttps:/mathstuff.com", "LU2IN005");
        UE ue2 = newUE("Object Oriented Programming", "htttps:/javastuff.com", "LU2IN002");
        UE ue3 = newUE("Physics Stuff", "htttps:/physicsstuff.com", "LU2IN666");
        cursus1.addUE(ue1);
        cursus1.addUE(ue2);
        cursus2.addUE(ue3);
        Time time0 = newTime(3, 6, 30);
        Time time1 = newTime(3, 10, 30);
        Time time2 = newTime(4, 6, 30);
        Time time3 = newTime(4, 12, 30);
        Time time4 = newTime(4, 10, 30);
        Time time5 = newTime(4, 14, 0);
        Time time6 = newTime(5, 6, 30);
        Time time7 = newTime(5, 12, 30);
        Time time8 = newTime(5, 10, 30);
        Time time9 = newTime(5, 14, 0);
        Period period1 = newPeriod(time0, time1);
        Period period2 = newPeriod(time2, time3);
        Period period3 = newPeriod(time4, time5);
        Period period4 = newPeriod(time6, time7);
        Period period5 = newPeriod(time8, time9);
        Teacher teacher1 = new Teacher("Mme. Schneider", "pootatoo", "123456");
        Teacher teacher2 = new Teacher("M. Guigue", "potiti", "123456");
        Teacher teacher3 = new Teacher("Micheal Jackson", "payaayaa", "123456");
        Class c1 = newClass(period1, teacher1, "24-25-104", "TD");
        Class c2 = newClass(period2, teacher2, "14-15-401", "TME");
        Class c3 = newClass(period3, teacher3, "14-15-301", "TME");
        Class c4 = newClass(period4, teacher1, "14-15-405", "Cours");
        Class c5 = newClass(period5, teacher2, "14-24-401", "Cours");
        ue1.createGroup(c1, c2, null);
        ue1.createGroup(c3, null, null);
        ue2.createGroup(c4, null, c5);
        ue3.createGroup(c1, c3, c4);
        dept.addUE(ue1);
        dept.addUE(ue2);
        dept.addUE(ue3);
        dept.addCursus(cursus1);
        dept.addCursus(cursus2);
        
    	Student student1 = new Student("nam","magiacni","sgkln",50214987);
    	Student student2 = new Student("ben","avocadoo","trustno1",21149187);
    	student1.requestRegistration(dept);
    	student2.requestRegistration(dept);
    	System.out.println(student1.getForm().getCursusName());
    	System.out.println(student1.getForm().getStudentName());
    	System.out.println(student1.getForm().getCursusName());
    	System.out.println(student1.getForm().getUEReferences());
    	System.out.println(student1.getForm().getGroupNumbers());
    	System.out.println(student2.getForm().getCursusName());
    	System.out.println(student2.getForm().getStudentName());
    	System.out.println(student2.getForm().getCursusName());
    	System.out.println(student2.getForm().getUEReferences());
    	System.out.println(student2.getForm().getGroupNumbers());
    	
    	
    }
}
