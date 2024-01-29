package GUI.AddPanels;

import Databases.*;
import Student.Course;
import Student.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddStudent implements ActionListener {
    private Courses coursesDatabase;
    private University uniDatabase;

    private JFrame frame = new JFrame();
    private JButton confirmButton;
    private JTextField nameField = new JTextField(20);
    private JTextField surnameField = new JTextField(20);
    private JTextField peselField = new JTextField(20);
    private JTextField ageField = new JTextField(20);
    private JComboBox<String> sexComboBox = new JComboBox<>(new String[]{"Male", "Female"});
    private JTextField studentIDField = new JTextField(20);
    private JTextField yearField = new JTextField(20);
    private JTextField degreeField = new JTextField(20);
    private JCheckBox erasmusCheckBox = new JCheckBox();
    private JCheckBox remoteCheckBox = new JCheckBox();
    private JPanel inputPanel;


    public AddStudent(University uniDatabase, Courses coursesDatabase){
        this.uniDatabase = uniDatabase;
        this.coursesDatabase = coursesDatabase;


        frame.setSize(600, 800);  // Adjust the size as needed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        inputPanel = new JPanel(new GridLayout(5, 2));  // Using GridLayout for better arrangement

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Surname:"));
        inputPanel.add(surnameField);

        inputPanel.add(new JLabel("PESEL:"));
        inputPanel.add(peselField);

        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Sex:"));
        inputPanel.add(sexComboBox);

        inputPanel.add(new JLabel("Student ID:"));
        inputPanel.add(studentIDField);

        inputPanel.add(new JLabel("Year:"));
        inputPanel.add(yearField);

        inputPanel.add(new JLabel("Degree:"));
        inputPanel.add(degreeField);

        inputPanel.add(new JLabel("Erasmus:"));
        inputPanel.add(erasmusCheckBox);

        inputPanel.add(new JLabel("Remote:"));
        inputPanel.add(remoteCheckBox);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);



        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(confirmButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == confirmButton) {

            String name = nameField.getText();
            String surname = surnameField.getText();
            String pesel = peselField.getText();
            int age = Integer.parseInt(ageField.getText());
            String sex = (String) sexComboBox.getSelectedItem();
            int studentID = Integer.parseInt(studentIDField.getText());
            int year = Integer.parseInt(yearField.getText());
            int degree = Integer.parseInt(degreeField.getText());
            boolean erasmus = erasmusCheckBox.isSelected();
            boolean remote = remoteCheckBox.isSelected();

            ArrayList<Course> courses = new ArrayList<>();  //TODO add courses choice

            Student student = new Student(name, surname, pesel, age, sex, studentID, year, degree, erasmus, remote, courses);
            uniDatabase.addRecord(student);

            JOptionPane.showMessageDialog(frame,
                    "Student added to database:\n" +
                            "Name: " + name +
                            "\nSurname: " + surname +
                            "\nPESEL: " + pesel +
                            "\nAge: " + age +
                            "\nSex: " + sex +
                            "\nStudent ID: " + studentID +
                            "\nYear: " + year +
                            "\nDegree: " + degree +
                            "\nErasmus: " + erasmus +
                            "\nRemote: " + remote ,
                    "Student Added",
                    JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
        }


    }
}
