package GUI.SearchPanels;

import Databases.*;
import Person.Person;
import Student.Course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchStudentPanel extends JFrame implements ActionListener {

    private University uniDatabase;
    private JFrame frame;
    private JButton nextButton;
    private JComboBox<String> typeComboBox;
    private JTextField inputField;

    public SearchStudentPanel(University uniDatabase) {
        this.uniDatabase = uniDatabase;

        frame = new JFrame();
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        nextButton = new JButton("Dalej");
        nextButton.setPreferredSize(new Dimension(100, 50));
        nextButton.setFocusable(false);
        nextButton.addActionListener(this);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Wprowadź frazę do wyszukania"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel label = new JLabel("Chcę wyszukać Studentow po:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(label, gbc);

        typeComboBox = new JComboBox<>(new String[]{"Imieniu","Nazwisku", "Numerze indeksu", "Roku studiów", "Nazwie kursu"});
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(typeComboBox, gbc);

        inputField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        inputPanel.add(inputField, gbc);

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(nextButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == nextButton){
            String selectedType = (String) typeComboBox.getSelectedItem();
            handleSelectedType(selectedType);

        }

    }

    private void handleSelectedType(String selectedType) {

        ArrayList<Person> resultsList = new ArrayList<>();

        switch (selectedType) {
            case "Imieniu":
                String name = inputField.getText();
                resultsList = uniDatabase.searchByStudentName(name);
                break;

            case "Nazwisku":
                String surname = inputField.getText();
                resultsList = uniDatabase.searchByStudentSurname(surname);
                break;

            case "Numerze indeksu":
                int studentID = Integer.parseInt(inputField.getText());
                resultsList= uniDatabase.searchByStudentID(studentID);
                break;

            case "Roku studiów":
                int year = Integer.parseInt(inputField.getText());
                resultsList = uniDatabase.searchByYear(year);
                break;

            case "Nazwie kursu":
                String courseName = inputField.getText();
                resultsList = uniDatabase.searchByCourseName(courseName);
                break;
        }
        new PeopleResultsDisplay(resultsList, uniDatabase,"Student");
        frame.dispose();
    }



}

