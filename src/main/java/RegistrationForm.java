package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm {
    private String studentName;
    private int studentNumber;
    private Cursus cursus;
    private UE[] myUEs;
    private Group[] myGroups;

    private JTextField input;
    private JButton clickMeToSubmitButton;
    private JTextArea output;
    private JPanel myPanel;

    public RegistrationForm() {
        clickMeToSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(input.getText());
            }
        });
    }

    public UE[] getMyUEs() {
        return myUEs;
    }

    public Group[] getMyGroups() {
        return myGroups;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RegistrationForm");
        frame.setContentPane(new RegistrationForm().myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
