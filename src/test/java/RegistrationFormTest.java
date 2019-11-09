package test.java;

import main.java.RegistrationForm;
import main.java.Departement;

public class RegistrationFormTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Departement dept1 = new Departement("The school");
		RegistrationForm regForm = new RegistrationForm("Vlad", 151513, dept1);
        while (!regForm.isFinished()) {
        	try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		System.out.print(regForm.isFinished());
		System.out.print(regForm.isFinishedWithSubmit());
		System.out.print(regForm.getStudentName());
		System.out.print(regForm.getStudentNumber());
		System.out.print(regForm.getCursusName());
		System.out.print(regForm.getUEReferences());
		System.out.print(regForm.getGroupNumbers());
	}

}
