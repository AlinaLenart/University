package GUI.SearchPanels;

import Databases.*;
import SortingCourses.SortByEcts;
import SortingCourses.SortByTeacherSurname;
import SortingUniversity.SortBySurname;
import SortingUniversity.SortBySurnameThenAge;
import SortingUniversity.SortBySurnameThenName;
import SortingUniversity.UniversityStrategy;
import Student.Course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchCoursesPanel extends JFrame implements ActionListener {

    private Courses coursesDatabase;
    private JFrame frame;
    private JButton nextButton;
    private JComboBox<String> typeComboBox;
    private JTextField inputField;

    public SearchCoursesPanel(Courses coursesDatabase) {
        this.coursesDatabase = coursesDatabase;

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
        gbc.insets = new Insets(5, 5, 5, 5);  // Add some padding

        JLabel label = new JLabel("Chce wyszukać Kurs po:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(label, gbc);

        typeComboBox = new JComboBox<>(new String[]{"Nazwie kursu","Nazwisku prowadzacego", "Punktach ECTS"});
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

        switch (selectedType) {
            case "Nazwie kursu":
                String name = inputField.getText();
                ArrayList<Course> resultsList = coursesDatabase.searchByName(name);
                new CoursesResultsDisplay(resultsList, coursesDatabase);
                break;

            case "Nazwisku prowadzacego":
                String teacherSurname = inputField.getText();
                ArrayList<Course> resultsList2 = coursesDatabase.searchByTeacher(teacherSurname);
                new CoursesResultsDisplay(resultsList2, coursesDatabase);
                break;

            case "Punktach ECTS":
                int ects = Integer.parseInt(inputField.getText());
                ArrayList<Course> resultsList3 = coursesDatabase.searchByEcts(ects);
                new CoursesResultsDisplay(resultsList3, coursesDatabase);
                break;

        }

        frame.dispose();
    }



}

