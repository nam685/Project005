package main.java;

import javax.swing.*;
import java.util.ArrayList;

public class RegistrationForm {
    private String studentName;
    private int studentNumber;
    private String cursusName;
    private ArrayList<String> UEReferences;
    private ArrayList<Integer> groupNumbers;

    private JPanel myPanel;

    public RegistrationForm() {

        UEReferences = new ArrayList<>();
        groupNumbers = new ArrayList<>();
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RegistrationForm");
        frame.setContentPane(new RegistrationForm().myPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public String getCursusName() {
        return cursusName;
    }

    public ArrayList<String> getUEReferences() {
        return UEReferences;
    }

    public ArrayList<Integer> getGroupNumbers() {
        return groupNumbers;
    }
}
