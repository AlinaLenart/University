package GUI.SearchPanels;

import Databases.*;
import Person.Person;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchEmployeePanel extends JFrame implements ActionListener {

    private University uniDatabase;
    private JFrame frame;
    private JButton nextButton;
    private JComboBox<String> typeComboBox;
    private JTextField inputField;

    public SearchEmployeePanel(University uniDatabase) {
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

        JLabel label = new JLabel("Chcę wyszukac Pracownikow po:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(label, gbc);

        typeComboBox = new JComboBox<>(new String[]{"Imieniu","Nazwisku", "Stanowisku", "Stażu pracy", "Pensji", "Publikacjach", "Nadgodzinach", "Ilosci"});
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
                resultsList = uniDatabase.searchByEmployeeName(name);
                break;

            case "Nazwisku":
                String surname = inputField.getText();
                resultsList =  uniDatabase.searchByEmployeeSurname(surname);
                break;

            case "Stanowisku":
                String jobPosition = inputField.getText();
                resultsList = uniDatabase.searchByPositionName(jobPosition);
                break;

            case "Stażu pracy":
                int workExperience = Integer.parseInt(inputField.getText());
                resultsList = uniDatabase.searchByWorkExperience(workExperience);
                break;

            case "Pensji":
                double salary = Double.parseDouble(inputField.getText());
                resultsList = uniDatabase.searchBySalary(salary);
                break;

            case "Publikacjach":
                int releases = Integer.parseInt(inputField.getText());
                resultsList = uniDatabase.searchByReleases(releases);
                break;

            case "Nadgodzinach":
                int overtime = Integer.parseInt(inputField.getText());
                resultsList = uniDatabase.searchByOvertime(overtime);
                break;
            case "Ilosci":
                double quantity = Double.parseDouble(inputField.getText());
                resultsList = uniDatabase.searchByQuantity(quantity);
                break;

        }

        new PeopleResultsDisplay(resultsList, uniDatabase,"Employee");
        frame.dispose();
    }



}

