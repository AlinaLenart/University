package GUI.AddPanels;

import Databases.*;
import Employees.*;

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
    private JComboBox<String> sexComboBox = new JComboBox<>(new String[]{"Mezczyzna", "Kobieta"});
    private JComboBox<String> jobPositionField = new JComboBox<>(new String[]{"Referent", "Specjalista", "Starszy Specjalista", "Nadzorujacy Badania", "Prezes Zarzadu", "Inne stanowisko"});
    private JTextField workExperienceField = new JTextField(20);
    private JTextField salaryField = new JTextField(20);
    private JTextField overtimeField = new JTextField(20);

    private JPanel inputPanel;


    public AddAdmEmployee(University uniDatabase){
        this.uniDatabase = uniDatabase;

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

        inputPanel.add(new JLabel("Stanowisko pracy:"));
        inputPanel.add(jobPositionField);

        inputPanel.add(new JLabel("Doświadczenie zawodowe:"));
        inputPanel.add(workExperienceField);

        inputPanel.add(new JLabel("Pensja:"));
        inputPanel.add(salaryField);

        inputPanel.add(new JLabel("Nadgodziny (w godzinach):"));
        inputPanel.add(overtimeField);


        confirmButton = new JButton("Potwierdź");
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
                    "Pracownik Administracyjny został pomyślnie dodany:\n" +
                            "Imie: " + name +
                            "\nNazwisko: " + surname +
                            "\nPESEL: " + pesel +
                            "\nWiek: " + age +
                            "\nPłeć: " + sex +
                            "\nStanowisko pracy: " + jobPosition +
                            "\nDoświadczenie zawodowe: " + workExperience +
                            "\nPensja: " + salary +
                            "\nNadgodziny (in hours): " + overtime,
                    "Pracownik Administracyjny Dodany",
                    JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
        }


    }
}
