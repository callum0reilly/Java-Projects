/**
 * OOSD2 SEMESTER 1 ASSIGNMENT 1
 * Author: Callum O'Reilly
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddStudentGUI {
    private JFrame frame;
    private JTextArea txtrShowStudents;
    private JTextField nameTextField;
    private JTextField addressTextField;

    // Declare an ArrayList to store student information
   ArrayList<String> students = new ArrayList<>();

    public AddStudentGUI() {
        frame = new JFrame("Student Information System");
        frame.setLayout(new BorderLayout());

        JPanel panelNewStudent = new JPanel();
        // create a raised bevel border around the panelNewStudent
        panelNewStudent.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1), "New Student"));
        panelNewStudent.setLayout(new BorderLayout());

        // Create a panel at the top (north) to show where the student is added
        JPanel panelAddStudent = new JPanel();
        panelAddStudent.setLayout(new GridLayout(2, 2));

        // Name originally shown in the text field but will be changed by the user
        nameTextField = new JTextField("Peter Smith");
        addressTextField = new JTextField("35 Liffey Street, Dublin 2");

        // Creates the labels for the text fields
        panelAddStudent.add(new JLabel("Name:"));
        panelAddStudent.add(nameTextField);
        panelAddStudent.add(new JLabel("Address:"));
        panelAddStudent.add(addressTextField);

        // Panel in the center shows where student details
        JPanel panelShowStudent = new JPanel();
        panelShowStudent.setLayout(new BorderLayout());
        panelShowStudent.add(new JLabel("Student List"), BorderLayout.NORTH); // label to show what it is, i.e., a student list
        txtrShowStudents = new JTextArea(10, 40); // determines the size of the text area (how many rows and columns)
        panelShowStudent.add(new JScrollPane(txtrShowStudents), BorderLayout.CENTER); // allows users to scroll if many students are added to the list

        // Create a panel which shows both the modules and checkboxes
        JPanel panelModules = new JPanel();
        panelModules.setLayout(new GridLayout(2, 1));

        // Allows the user to select in a checkbox
        JPanel panelCheckBoxes = new JPanel();
        panelCheckBoxes.setLayout(new GridLayout(0, 1));
        JCheckBox box4Databases = new JCheckBox("DataBases");
        JCheckBox box4Java = new JCheckBox("Java");
        JCheckBox box4Accountancy = new JCheckBox("Accountancy");

        // Adds the buttons to the panel
        panelCheckBoxes.add(box4Databases);
        panelCheckBoxes.add(box4Java);
        panelCheckBoxes.add(box4Accountancy);

        // Create this panel to show the info of the selected module (bottom right)
        JPanel moduleTextPanel = new JPanel();
        moduleTextPanel.setLayout(new BorderLayout());
        JTextArea moduleTextArea = new JTextArea(5, 15);
        moduleTextPanel.add(new JScrollPane(moduleTextArea), BorderLayout.CENTER);

        // Add the checkboxes and the module text panel to the panelModules
        panelModules.add(panelCheckBoxes);
        panelModules.add(moduleTextPanel); // this is the box that displays the modules selected in the checkboxes

        // Create the buttons
        JButton btnSubmit = new JButton("Submit");
        JButton btnClear = new JButton("Clear");
        JButton btnFinish = new JButton("Finish");
        JButton btnClearAll = new JButton("Clear All");

        // Reads the name and address you put in and displays it in the text box ShowStudents
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Take in student name/address in the textfield at the top and store it in the following variables and display it in the center panel

                String name = nameTextField.getText();
                String address = addressTextField.getText();

                String modules = "";
                if (box4Databases.isSelected()) {
                    modules += "Databases, ";
                }
                if (box4Java.isSelected()) {
                    modules += "Java, ";
                }
                if (box4Accountancy.isSelected()) {
                    modules += "Accountancy, ";
                }
               

                // Add student information to the ArrayList
                students.add("Name: " + name + " , Address: " + address + " , Modules: " + modules);

                // Adds the text to the box              
                txtrShowStudents.append("Name: " + name + " , Address: " + address + " , Modules: " + modules + "\n");
            }
        });

        // Clears the text field and resets it to the default value
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameTextField.setText("Peter Smith");
                addressTextField.setText("35 Liffey Street, Dublin 2");
            }
        });

        // Closes the window
        btnFinish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // method that is there to shut down the application
            }
        });

        // This listener makes the clear button work 
        btnClearAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameTextField.setText("Peter Smith");
                addressTextField.setText("35 Liffey Street, Dublin 2");
                txtrShowStudents.setText(""); // ensures the Show Students textfield is empty
                // Set these to false so boxes arent checked already
                box4Databases.setSelected(false);
                box4Java.setSelected(false);
                box4Accountancy.setSelected(false);
            }
        });

        // This adds everything to the panelNewStudent (the main panel) and lays them out where needed
        panelNewStudent.add(panelAddStudent, BorderLayout.NORTH);
        panelNewStudent.add(panelShowStudent, BorderLayout.CENTER);
        panelNewStudent.add(panelModules, BorderLayout.EAST);

        // Add all the buttons to panelButton and create it
        JPanel panelButton = new JPanel();
        panelButton.add(btnSubmit);
        panelButton.add(btnClear);
        panelButton.add(btnFinish);
        panelButton.add(btnClearAll);

        frame.add(panelNewStudent, BorderLayout.CENTER);
        frame.add(panelButton, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // method to assign the everything within it so it fits
        frame.setVisible(true); // allows the window to be seen when the application is run
    }

    // Main method and call the constructor
    public static void main(String[] args) {
        new AddStudentGUI();
    }
}
