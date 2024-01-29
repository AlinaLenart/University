package GUI.AddPanels;

import Databases.*;
import Employees.AdministrationEmployee;
import Employees.UniversityEmployee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAdmEmployee implements ActionListener {

    private University uniDatabase;

    private JFrame frame = new JFrame();
    private JButton confirmButton;
    private JTextField nameField = new JTextField(20);
    private JTextField surnameField = new JTextField(20);
    private JTextField peselField = new JTextField(20);
    private JTextField ageField = new JTextField(20);
    private JComboBox<String> sexComboBox = new JComboBox<>(new String[]{"Male", "Female"});
    private JComboBox<String> jobPositionField = new JComboBox<>(new String[]{"Referent", "Specjalista", "Starszy Specjalista", "Nadzorujacy Badania", "Prezes Zarzadu", "Inne stanowisko"});
    private JTextField workExperienceField = new JTextField(20);
    private JTextField salaryField = new JTextField(20);
    private JTextField overtimeField = new JTextField(20);

    private JPanel inputPanel;


    public AddAdmEmployee(University uniDatabase){
        this.uniDatabase = uniDatabase;

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

        inputPanel.add(new JLabel("Job Position:"));
        inputPanel.add(jobPositionField);

        inputPanel.add(new JLabel("Work Experience:"));
        inputPanel.add(workExperienceField);

        inputPanel.add(new JLabel("Salary:"));
        inputPanel.add(salaryField);

        inputPanel.add(new JLabel("Overtime (in hours):"));
        inputPanel.add(overtimeField);


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
            String jobPosition = (String) jobPositionField.getSelectedItem();
            int workExperience = Integer.parseInt(workExperienceField.getText());
            double salary = Double.parseDouble(salaryField.getText());
            int overtime = Integer.parseInt(overtimeField.getText());

            UniversityEmployee employee = new AdministrationEmployee(name, surname, pesel, age, sex, jobPosition, workExperience, salary, overtime);
            uniDatabase.addRecord(employee);

            JOptionPane.showMessageDialog(frame,
                    "Administration Employee added to database:\n" +
                            "Name: " + name +
                            "\nSurname: " + surname +
                            "\nPESEL: " + pesel +
                            "\nAge: " + age +
                            "\nSex: " + sex +
                            "\nJob Position: " + jobPosition +
                            "\nWrok Experience: " + workExperience +
                            "\nSalary: " + salary +
                            "\nOvertime (in hours): " + overtime,
                    "Administration Employee Added",
                    JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
        }


    }
}
