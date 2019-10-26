package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm {
    private JTextField input;
    private JButton clickMeToSubmitButton;
    private JTextArea output;
    private JPanel myPanel;
    private JTextPane registrationFormTextPane;

    public RegistrationForm() {
        clickMeToSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(input.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RegistrationForm");
        frame.setContentPane(new RegistrationForm().myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
