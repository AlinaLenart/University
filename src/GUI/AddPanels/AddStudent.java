package GUI.AddPanels;

import Databases.*;
import Student.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class AddStudent implements ActionListener {
    private Courses coursesDatabase;
    private University uniDatabase;
    ArrayList<Course> scheduleList = new ArrayList<>();

    private JFrame frame = new JFrame();
    private JButton confirmButton;
    private JButton createScheduleButton;
    private JTextField nameField = new JTextField(20);
    private JTextField surnameField = new JTextField(20);
    private JTextField peselField = new JTextField(20);
    private JTextField ageField = new JTextField(20);
    private JComboBox<String> sexComboBox = new JComboBox<>(new String[]{"Mezczyzna", "Kobieta"});
    private JTextField studentIDField = new JTextField(20);
    private JTextField yearField = new JTextField(20);
    private JTextField degreeField = new JTextField(20);
    private JCheckBox erasmusCheckBox = new JCheckBox();
    private JCheckBox remoteCheckBox = new JCheckBox();
    private JPanel inputPanel;


    public AddStudent(University uniDatabase, Courses coursesDatabase){
        this.uniDatabase = uniDatabase;
        this.coursesDatabase = coursesDatabase;


        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        inputPanel = new JPanel(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Imie:"));
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Nazwisko:"));
        inputPanel.add(surnameField);

        inputPanel.add(new JLabel("PESEL:"));
        inputPanel.add(peselField);

        inputPanel.add(new JLabel("Wiek:"));
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Płeć:"));
        inputPanel.add(sexComboBox);

        inputPanel.add(new JLabel("Nr indeksu:"));
        inputPanel.add(studentIDField);

        inputPanel.add(new JLabel("Rok studiów:"));
        inputPanel.add(yearField);

        inputPanel.add(new JLabel("Stopień:"));
        inputPanel.add(degreeField);

        inputPanel.add(new JLabel("Erasmus:"));
        inputPanel.add(erasmusCheckBox);

        inputPanel.add(new JLabel("Zdalnie:"));
        inputPanel.add(remoteCheckBox);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));

        createScheduleButton = new JButton("Utwórz Plan Zajęć");
        createScheduleButton.addActionListener(this);
        buttonsPanel.add(createScheduleButton);

        confirmButton = new JButton("Zakończ wprowadzanie");
        confirmButton.addActionListener(this);
        buttonsPanel.add(confirmButton);


        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        AddCourseForStudentPanel courseForStudentPanel= new AddCourseForStudentPanel(coursesDatabase, scheduleList);

        if(e.getSource() == createScheduleButton){
            courseForStudentPanel.visibility();
        }

        else if(e.getSource() == confirmButton) {

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


            Student student = new Student(name, surname, pesel, age, sex, studentID, year, degree, erasmus, remote, scheduleList);
            uniDatabase.addRecord(student);

            JOptionPane.showMessageDialog(frame,
                    "Student został pomyślnie dodany:\n" +
                            "Imie: " + name +
                            "\nNazwisko: " + surname +
                            "\nPESEL: " + pesel +
                            "\nWiek: " + age +
                            "\nPłeć: " + sex +
                            "\nNr indeksu: " + studentID +
                            "\nRok studiów: " + year +
                            "\nStopień: " + degree +
                            "\nErasmus: " + erasmus +
                            "\nZdalnie: " + remote ,
                    "Student Dodany",
                    JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
        }
    }


}
