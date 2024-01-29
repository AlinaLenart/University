package GUI.Duplicates;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import Databases.*;
import Employees.AdministrationEmployee;
import Employees.ResearchEmployee;
import Employees.UniversityEmployee;
import Person.*;
import Student.*;

import javax.swing.*;

public class DuplicatesPeoplePanel implements ActionListener {
    private University uniDatabase;
    private JFrame frame;
    private JButton confirmButton;
    private JButton quitButton;
    private JList<String> peopleList;
    private DefaultListModel<String> listModel;

    public DuplicatesPeoplePanel(University uniDatabase){

        this.uniDatabase = uniDatabase;

        frame = new JFrame();
        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Nowa Baza Osób");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        peopleList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(peopleList);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JLabel questionLabel = new JLabel("Czy chcesz ją zachować?");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        buttonPanel.add(questionLabel);

        confirmButton = new JButton("TAK");
        confirmButton.setPreferredSize(new Dimension(150, 100));
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(this);
        buttonPanel.add(confirmButton);

        quitButton = new JButton("NIE");
        quitButton.setPreferredSize(new Dimension(150, 100));
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);
        buttonPanel.add(quitButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

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

        if(e.getSource() == quitButton){
            frame.dispose();
        }
        else if(e.getSource() == confirmButton){

            HashSet<Person> noDuplicatesDatabase = new HashSet<>(uniDatabase.getPersonArrayList());
            ArrayList<Person> noDuplicatesArraylist = new ArrayList<>(noDuplicatesDatabase);
            uniDatabase.setPersonArrayList(noDuplicatesArraylist);

            JOptionPane.showMessageDialog(frame,
                    "Baza zaaktualizowana\n",
                    "Udane",
                    JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
        }
    }
}
