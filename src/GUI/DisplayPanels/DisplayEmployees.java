package GUI.DisplayPanels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Databases.*;
import Employees.UniversityEmployee;
import Person.*;
import Student.*;

import javax.swing.*;

public class DisplayEmployees implements ActionListener {
    private University uniDatabase;
    private JFrame frame;
    private JButton backButton;
    private JList<String> employeesList;
    private DefaultListModel<String> listModel;

    public DisplayEmployees(University uniDatabase){

        this.uniDatabase = uniDatabase;

        frame = new JFrame();
        frame.setSize(1500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Employees Database");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        employeesList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(employeesList);
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

        ArrayList<Person> employeesArrayList = uniDatabase.getEmployeesList();
        listModel.clear();


        Font monospacedFont = new Font("Courier New", Font.BOLD, 12);
        employeesList.setFont(monospacedFont);

        listModel.addElement(String.format("%-4s %-35s %-20s %-20s %-20s %-10s %-10s %-25s %-15s %-15s %-30s\n",
                "Lp.", "Identyfikacja", "Imie", "Nazwisko", "PESEL", "Wiek", "Plec", "Stanowisko", "Doswiadczenie", "Pensja", "Publikacje/Nadgodziny"));

        for (int i = 0; i < uniDatabase.getEmployeesList().size(); i++) {
            Person p = uniDatabase.getEmployeesList().get(i);
            UniversityEmployee emp = (UniversityEmployee) p;
            listModel.addElement(String.format("%-4s %s \n",
                                (i + 1), emp.toString()));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == backButton){
            frame.dispose();

        }

    }
}
