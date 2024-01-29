package GUI.DisplayPanels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Databases.*;
import Employees.AdministrationEmployee;
import Employees.ResearchEmployee;
import Employees.UniversityEmployee;
import Person.*;
import Student.*;

import javax.swing.*;

public class DisplayAllPeople implements ActionListener {
    private University uniDatabase;
    private JFrame frame;
    private JButton backButton;
    private JList<String> peopleList;
    private DefaultListModel<String> listModel;

    public DisplayAllPeople(University uniDatabase){

        this.uniDatabase = uniDatabase;

        frame = new JFrame();
        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("People Database");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        peopleList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(peopleList);
        frame.add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        frame.add(backButton, BorderLayout.SOUTH);

        displayStudentList();

        frame.setVisible(true);

    }

    private void displayStudentList() {

        ArrayList<Person> peopleArrayList = uniDatabase.getPersonArrayList();
        listModel.clear();

        Font monospacedFont = new Font("Courier New", Font.BOLD, 12);
        peopleList.setFont(monospacedFont);

        listModel.addElement(String.format("%-4s %-35s %-20s %-20s %-20s %-10s %-10s\n",
                "Lp.", "Identyfikacja", "Imie", "Nazwisko", "PESEL", "Wiek", "Plec"));

        for (int i = 0; i < peopleArrayList.size(); i++) {

            Person p = peopleArrayList.get(i);
            String type = null;
            if (p instanceof Student)
                type = "Student";
            else if (p instanceof AdministrationEmployee)
                type = "Pracownik Administracyjny";
            else if (p instanceof ResearchEmployee)
                type = "Pracownik Badawczo-Dydaktyczny";

            listModel.addElement(String.format("%-4s %-35s %-20s %-20s %-20s %-10s %-10s\n",
                    (i + 1), type, p.getName(), p.getSurname(), p.getPesel(), p.getAge(), p.getSex()));

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == backButton){
            frame.dispose();

        }

    }
}
