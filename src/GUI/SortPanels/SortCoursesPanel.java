package GUI.SortPanels;

import Databases.*;
import SortingCourses.SortByEcts;
import SortingCourses.SortByTeacherSurname;
import SortingUniversity.SortBySurname;
import SortingUniversity.SortBySurnameThenAge;
import SortingUniversity.SortBySurnameThenName;
import SortingUniversity.UniversityStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortCoursesPanel extends JFrame implements ActionListener {

    private Courses coursesDatabase;
    private JFrame frame;
    private JButton nextButton;
    private JComboBox<String> typeComboBox;

    public SortCoursesPanel(Courses coursesDatabase){

        this.coursesDatabase = coursesDatabase;

        frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        JPanel titlePanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Wybierz metode sortowania: ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        titlePanel.add(titleLabel, BorderLayout.CENTER);

        frame.add(titlePanel, BorderLayout.NORTH);

        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(100, 50));
        nextButton.setFocusable(false);
        nextButton.addActionListener(this);

        JPanel comboBoxPanel = new JPanel(new FlowLayout());

        JLabel label = new JLabel("Baza zostanie posortowana wedlug:");
        comboBoxPanel.add(label);

        typeComboBox = new JComboBox<>(new String[]{"Nazwiska prowadzacego", "Punktow ECTS"});
        comboBoxPanel.add(typeComboBox);

        frame.add(comboBoxPanel, BorderLayout.CENTER);

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
            case "Nazwiska prowadzacego":
                coursesDatabase.setSortingStrategy(new SortByTeacherSurname());  //TODO sprawdz czy dziala
                coursesDatabase.sortByChosenStrategy();
                break;

            case "Punktow ECTS":
                coursesDatabase.setSortingStrategy(new SortByEcts());
                coursesDatabase.sortByChosenStrategy();
                break;

        }
        JOptionPane.showMessageDialog(frame,
                "Baza kursów posortowana wedlug: " +
                        selectedType,
                "Udane!",
                JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }


}

