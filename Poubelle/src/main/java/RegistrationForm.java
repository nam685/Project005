package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class RegistrationForm extends JFrame {
    private JTextField tfName;
    private JTextField tfNumber;
    private JComboBox<String> listCursus;
    private JButton btnSubmit;
    private JButton btnAdd;

    private Cursus tempCursus;
    private int compCount;
    private boolean finished;
    private boolean finishedWithSubmit;
    private String studentName;
    private int studentNumber;
    private String cursusName;
    private ArrayList<String> UEReferences;
    private ArrayList<Integer> groupNumbers;

    public RegistrationForm(String name, int number, Departement dept) {
        this.finished = false;
        this.finishedWithSubmit = false;
        this.studentName = name;
        this.studentNumber = number;
        this.cursusName = "";
        UEReferences = new ArrayList<>();
        groupNumbers = new ArrayList<>();

        // Containers and Components
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(0, 1));
        JPanel fixedGridPanel = new JPanel(new GridLayout(3, 2, 10, 0));      // this contains name, number and cursus
        JPanel dynamicGridPanel = new JPanel(new GridLayout(0, 2, 10, 0));    // this contains the UEs and their choice of groups
        JScrollPane scrollPane = new JScrollPane(dynamicGridPanel);           // because dynamicGridPanel may take up much space
        fixedGridPanel.add(new JLabel("Name", Label.LEFT));                   // name. Already known.
        tfName = new JTextField(name);
        tfName.setEditable(false);
        fixedGridPanel.add(tfName);
        fixedGridPanel.add(new JLabel("Number", Label.LEFT));                 // number. Already known
        tfNumber = new JTextField(Integer.toString(number));
        tfNumber.setEditable(false);
        fixedGridPanel.add(tfNumber);
        fixedGridPanel.add(new JLabel("Cursus", Label.LEFT));                 // Cursus. A drop down list to choose from
        listCursus = new JComboBox<>();
        for (Cursus c : dept.getCursusList())
            listCursus.addItem(c.getName());
        fixedGridPanel.add(listCursus);
        tempCursus = dept.getCursusByName((String) listCursus.getSelectedItem());
        showCursusInComboBox(tempCursus, dept, dynamicGridPanel);             // Shows corresponding UEs for the default cursus

        cp.add(fixedGridPanel);
        cp.add(scrollPane);

        btnAdd = new JButton("Add group choices for UEs");
        cp.add(btnAdd);

        btnSubmit = new JButton("Submit");
        cp.add(btnSubmit);

        // The Submit button
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                studentName = tfName.getText();
                studentNumber = Integer.parseInt(tfNumber.getText());
                cursusName = (String) listCursus.getSelectedItem();
                finishedWithSubmit = true;
                dispose();
            }
        });

        listCursus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                dynamicGridPanel.removeAll();
                if (itemEvent.getStateChange() == ItemEvent.DESELECTED) return;
                tempCursus = dept.getCursusByName((String) listCursus.getSelectedItem());
                showCursusInComboBox(tempCursus, dept, dynamicGridPanel);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                compCount = 0;
                for (Component comp : dynamicGridPanel.getComponents()) {
                    if (comp instanceof JComboBox) {
                        Object o = ((JComboBox) comp).getSelectedItem();
                        if (o == null) continue;
                        int groupNumber = (int) o;
                        String ueRef = ((JLabel) dynamicGridPanel.getComponent(compCount - 1)).getText();
                        UEReferences.add(ueRef);
                        groupNumbers.add(groupNumber);
                    }
                    compCount++;
                }
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Exit program if close-window button clicked
        setTitle("Registration Form"); // "super" JFrame sets title
        setSize(300, 300);         // "super" JFrame sets initial size

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        setVisible(true);          // "super" JFrame shows

    }

    private void showCursusInComboBox(Cursus cursus, Departement dept, JPanel dynamicGridPanel) {
        if (cursus == null) return;
        ArrayList<UE> ueList = cursus.getUEs();
        for (UE ue : ueList) {
            if (ue == null) continue;
            dynamicGridPanel.add(new JLabel(ue.getReference(), Label.LEFT));
            JComboBox<Integer> groups = new JComboBox<>();
            for (Group g : ue.getGroupList()) {
                if (g == null) continue;
                groups.addItem(g.getGroupNumber());
            }
            dynamicGridPanel.add(groups);
        }
        dynamicGridPanel.revalidate();
        dynamicGridPanel.repaint();
    }

    @Override
    public void dispose() {
        finished = true;
        System.out.println("Finished " + studentName + "'s form.");
        super.dispose();
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean isFinishedWithSubmit() {
        return finishedWithSubmit;
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
