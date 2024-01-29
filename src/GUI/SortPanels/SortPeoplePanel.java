package GUI.SortPanels;

import Databases.Courses;
import Databases.University;
import SortingUniversity.SortBySurname;
import SortingUniversity.SortBySurnameThenAge;
import SortingUniversity.SortBySurnameThenName;
import SortingUniversity.UniversityStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortPeoplePanel extends JFrame implements ActionListener {

    private University uniDatabase;
    private JFrame frame;
    private JButton nextButton;
    private JComboBox<String> typeComboBox;

    public SortPeoplePanel(University uniDatabase){

        this.uniDatabase = uniDatabase;

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

        typeComboBox = new JComboBox<>(new String[]{"Nazwiska", "Nazwiska i imienia", "Nazwiska i wieku"});
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
            case "Nazwiska":
                uniDatabase.setSortingStrategy(new SortBySurname());
                uniDatabase.sortByChosenStrategy();
                break;

            case "Nazwiska i imienia":
                uniDatabase.setSortingStrategy(new SortBySurnameThenName());
                uniDatabase.sortByChosenStrategy();
                break;

            case "Nazwiska i wieku":
                uniDatabase.setSortingStrategy(new SortBySurnameThenAge());
                uniDatabase.sortByChosenStrategy();
                break;
        }

        JOptionPane.showMessageDialog(frame,
                "Baza osób posortowana według: " +
                        selectedType,
                "Udane!",
                JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();
    }


}

