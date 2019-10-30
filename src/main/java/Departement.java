package main.java;

import java.util.ArrayList;

public class Departement {

    private String name;
    private ArrayList<UE> ueList;
    private ArrayList<Cursus> cursusList;
    private ArrayList<RegistrationForm> toDoList;
    private int studentCount;
    private ArrayList<Student> unregisteredStudentList;
    private ArrayList<Student> registeredStudentList;
    //toDoList and unregisteredStudentList are coupled

    public Departement(String name) {
        this.name = name;
        this.ueList = new ArrayList<>();
        this.cursusList = new ArrayList<>();
        this.toDoList = new ArrayList<>();
        this.studentCount = 0;
        this.unregisteredStudentList = new ArrayList<>();
        this.registeredStudentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public ArrayList<Student> getRegisteredStudentList() {
        return registeredStudentList;
    }

    public ArrayList<Cursus> getCursusList() {
        return cursusList;
    }

    public void addCursus(Cursus c) {
        if (!this.cursusList.contains(c)) this.cursusList.add(c);
    }

    public void addUE(UE ue) {
        if (!this.ueList.contains(ue)) this.ueList.add(ue);
    }

    public UE getUEByReference(String reference) {
        for (UE ue : ueList) {
            if (ue.getReference().equals(reference)) return ue;
        }
        return null;
    }

    public void addUnregisteredStudent(Student student) {
        if (!this.unregisteredStudentList.contains(student))
            this.unregisteredStudentList.add(student);
    }

    public void addRegistrationDemand(RegistrationForm form) {
        if (!this.toDoList.contains(form))
            this.toDoList.add(form);
    }

    private void processInscriptionDemand(RegistrationForm form) {
        int index = toDoList.indexOf(form);
        unregisteredStudentList.get(index).setRegistered(true);
        unregisteredStudentList.remove(index);
        //TO BE CONTINUED
    }

    public void processAllInscriptionDemand() {
        for (RegistrationForm form : toDoList) {
            this.processInscriptionDemand(form);
        }
    }
}
