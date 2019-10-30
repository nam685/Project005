package main.java;

public class DeptController {
    public static void main(String[] args) {
        Departement dept1 = new Departement("Informatique, Faculty of Science");
        UE mathDiscrete = new UE("Math Discrete", "https:/mathdiscretewebsite.com", "LU2IN005");
        dept1.addUE(mathDiscrete);
        Cursus infoMonoL2 = new Cursus("Informatique Monodisciplinaire L2");
        dept1.addCursus(infoMonoL2);
        infoMonoL2.addUE(mathDiscrete);
        assert (dept1.getUEByReference("LU2IN005").equals(mathDiscrete));

        Teacher schneider = new Teacher("Madame Schneider", "yadayada", "trustno1");
        Teacher jaume = new Teacher("Monsieur Jaume", "kappa123", "password");

        Period mathPeriod1 = new Period(new Time(5, 8, 45),
                new Time(5, 10, 30));
        Period mathPeriod2 = new Period(new Time(5, 10, 45),
                new Time(5, 12, 30));
        Period mathPeriod3 = new Period(new Time(5, 14, 0),
                new Time(5, 15, 45));

        Class class1 = new Class(mathPeriod1, schneider, "Amphi B1", "Cours");
        Class class2 = new Class(mathPeriod2, jaume, "24-24-104", "TD");
        Class class3 = new Class(mathPeriod3, jaume, "14-15-106", "TD");

        mathDiscrete.createGroup(class1, class2, class3);
        System.out.println(mathDiscrete.getGroupByGroupNumber(1).toString());

        Student nam = new Student("Nam Le", "nomnamnomnam", "supersecret", 39724408);
    }
}
