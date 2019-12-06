import java.util.Scanner;
import java.util.ArrayList;


public class MainController {
    public static void main(String[] args) throws Exception {
        //Ici on a cree le departement informatique
        Departement dept = new Departement("Licence Informatique");
        System.out.println("################ BIENVENU #################");
        System.out.println("######### dans le departement de ##########");
        System.out.println("########>> " +dept.getName()+" <<############\n");

        //Creer les cursus
        Cursus cursus1 = new Cursus("L2 MONO-DISCIPLINAIRE");
        Cursus cursus2 = new Cursus("L2 BI-DISP MAJEURE INFORMATIQUE");
        Cursus cursus3 = new Cursus("L2 BI-DISP INTENSIF INFO-MATHEMATIQUES");
        Cursus cursus4 = new Cursus("L2 BI-DISP INTENSIF INFO-ELECTRONIQUE");
        Cursus cursus5 = new Cursus("L2 BI-DISP INTENSIF INFO-BIOLOGIE");
        Cursus cursus6 = new Cursus("L2 DANT - LICENCE EN ALTERNANCE");
        //Creer les UEs
        UE ue1 = UE.createUE("Programmation objet", "http://www-licence.ufr/licence/LU2IN002", "LU2IN002",6);
        UE ue2 = UE.createUE("Mathematiques discretes","http://www-licence.ufr/licence/LU2IN005", "LU2IN005",6);
        UE ue3 = UE.createUE("C avance        ", "http://www-licence.ufr/licence/LU2IN018", "LU2IN018",3);
        UE ue4 = UE.createUE("Ocaml           ", "http://www-licence.ufr/licence/LU2IN019","LU2IN019",3);
        UE ue5 = UE.createUE("Programmation Shell", "http://www-licence.ufr/licence/LU2IN020","LU2IN020",6);
        UE ue6 = UE.createUE("Optimisation    ", "http://www-licence.ufr/licence/LU2IN021","LU2IN021",3);
        UE ue7 = UE.createUE("Methodes numeriques", "http://www-licence.ufr/licence/LU2IN011","LU2IN011",3);
        //creer les cursus, chacun avec ses propres UEs
        cursus1.addUE(ue1); cursus1.addUE(ue2);	//cursus1
        cursus1.addUE(ue3);

        cursus2.addUE(ue1); cursus2.addUE(ue2);//cursus2
        cursus2.addUE(ue3); cursus2.addUE(ue4);
        cursus2.addUE(ue5);

        cursus3.addUE(ue1); cursus3.addUE(ue2);//cursus3
        cursus3.addUE(ue3); cursus3.addUE(ue4);
        cursus3.addUE(ue5); cursus3.addUE(ue6);

        cursus4.addUE(ue1); cursus4.addUE(ue2);//cursus4
        cursus4.addUE(ue3); cursus4.addUE(ue4);
        cursus4.addUE(ue5); cursus4.addUE(ue7);

        cursus5.addUE(ue3); cursus5.addUE(ue4);//cursus5
        cursus5.addUE(ue5); cursus5.addUE(ue6);

        cursus6.addUE(ue3); cursus6.addUE(ue4);//cursus6
        cursus6.addUE(ue5);

        //Les horaires de chacune des seances
        Time s1start = Time.createTime(0,8,45);
        Time s1end   = Time.createTime(0,10,30);
        Time s2start = Time.createTime(0,10,45);
        Time s2end   = Time.createTime(0,12,30);
        Time s3start = Time.createTime(0,14,00);
        Time s3end   = Time.createTime(0,15,45);
        Time s4start = Time.createTime(0,16,00);
        Time s4end   = Time.createTime(0,17,45);
        Time s5start = Time.createTime(0,18,00);
        Time s5end   = Time.createTime(0,19,45);
        //Creer les seances
        Period seance1 = Period.createPeriod(s1start, s1end);
        Period seance2 = Period.createPeriod(s2start, s2end);
        Period seance3 = Period.createPeriod(s3start, s3end);
        Period seance4 = Period.createPeriod(s4start, s4end);
        Period seance5 = Period.createPeriod(s5start, s5end);
        //Creer quelques Profs
        Teacher teacher1 = new Teacher("Malcom Auffray", "MalcomLogin", "Malcompassword");
        Teacher teacher2 = new Teacher("Armel Jacques", "ArmelLogin", "Armelpassword");
        Teacher teacher3 = new Teacher("Gauvain Bourgne", "GauvainLogin", "Gauvainpassword");
        //Creer les classes
        Class c1 = Class.createClass(seance1, teacher1, "24-25-104", "TD");
        Class c2 = Class.createClass(seance2, teacher2, "14-15-401", "TME");
        Class c3 = Class.createClass(seance3, teacher3, "14-15-301", "TME");
        Class c4 = Class.createClass(seance4, teacher1, "14-15-405", "Cours");
        Class c5 = Class.createClass(seance5, teacher2, "14-24-401", "Cours");

        ue1.createGroup(c1, c2, null);
        ue1.createGroup(c3, null, null);
        ue2.createGroup(c4, null, c5);
        ue2.createGroup(c4, null, c5);
        ue3.createGroup(c4, null, c5);
        ue3.createGroup(c3, null, null);
        ue4.createGroup(c4, c1, c5);
        ue4.createGroup(c3, null, null);
        ue5.createGroup(c4, null, c5);
        ue5.createGroup(c3, c2, null);
        ue6.createGroup(c4, null, c5);
        ue6.createGroup(c3, null, c2);
        ue7.createGroup(c4, null, c5);
        ue7.createGroup(c3, c2, null);

        dept.addUE(ue1);
		dept.addUE(ue2);
		dept.addUE(ue3);
		dept.addUE(ue4);
		dept.addUE(ue5);
		dept.addUE(ue6);
		dept.addUE(ue7);

		dept.addCursus(cursus1);
		dept.addCursus(cursus2);
		dept.addCursus(cursus3);
		dept.addCursus(cursus4);
		dept.addCursus(cursus5);
		dept.addCursus(cursus6);

		//on effectue la demonstration pour 2 etudiants (membre de ce projet)
        Student student1 = new Student("Anes BOUZOUAOUI", "anesboz", "MotdepasseAnes", 28616582);
        dept.addUnregisteredStudent(student1);
        Student student2 = new Student("Nam Hai", "namhai20", "Mypassword", 28616589);
        dept.addUnregisteredStudent(student2);

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        Scanner sc = new Scanner(System.in);
        System.out.println("## Vous vouler ? :");

		    System.out.println("(0) Proceder directement a l'inscription ?");
        System.out.println("(1) Consulter la liste des cursus proposés ?");

		int rep = sc.nextInt();

		if (rep==1) {
			do{
			System.out.println("\033[H\033[2J\0");//clear terminal
			System.out.println("## Voici la liste des cursus disponibles:");
			int i=0;
			for (Cursus c : dept.getCursusList() ) {
				++i;
				System.out.print("("+i+") ");
				System.out.println(c.getName());
			}
			System.out.println("\n## Entrer le numero du cursus concerne pour avoir plus d'informations ?");
			System.out.println("## Sinon taper '0' pour Proceder a l'inscription ?");
			rep = sc.nextInt();
			System.out.println("#\033[H\033[2J");//clear terminal
			if (rep!=0) {
				System.out.println( dept.getCursusList().get(rep-1).toString() +"\n");
  			System.out.println("## taper '0' pour Proceder a l'inscription");
  			System.out.println("## taper 9 pour revenir au menu des curus");
  			rep = sc.nextInt();
			}
			}while(rep !=0);
		}
        int i=8;
        StringBuilder s = new StringBuilder();

  			System.out.println("\033[H\033[2J\0");//clear terminal
        System.out.println("chargement de l'Inscription en cours: ");

        do{
        //System.out.println("#\033[H\033[2J")
        s.append("\u001B[32m#"); // \u001B[32m for the green color
        System.out.print(s);
        --i;
        Thread.sleep(i*100);
      }while(i>0);

      System.out.println("\n\u001B[0m## Chargement réussi");//clear terminal
      System.out.println("## Veillez faire votre inscription sur la fenetre affichee ");


        //System.out.println("#\033[H\033[2J")

        for( Student std : dept.getUnRegisteredStudentList()){
            System.out.println("\n## Bonjour, inscription de ");
            System.out.println(std.toString());
            std.requestRegistration(dept);
            System.out.println(std.toString());
            System.out.println("\n## Recaputalif:");


        System.out.println("Curus\t"+std.getForm().getCursusName());
        System.out.println(std.getForm().getUEReferences());
        System.out.println(std.getForm().getGroupNumbers());
        }
    }
}
