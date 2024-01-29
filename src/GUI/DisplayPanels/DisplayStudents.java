package GUI.DisplayPanels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Databases.*;
import Person.*;
import Student.*;

import javax.swing.*;

public class DisplayStudents implements ActionListener {
    private University uniDatabase;
    private JFrame frame;
    private JButton backButton;
    private JList<String> studentList;
    private DefaultListModel<String> listModel;

    public DisplayStudents(University uniDatabase){

        this.uniDatabase = uniDatabase;

        frame = new JFrame();
        frame.setSize(1500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Baza Studentów");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        studentList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(studentList);
        frame.add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Wróć");
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        frame.add(backButton, BorderLayout.SOUTH);

        displayStudentList();

        frame.setVisible(true);

    }

    private void displayStudentList() {

        ArrayList<Person> studentArrayList = uniDatabase.getStudentsList();
        listModel.clear();


        Font monospacedFont = new Font("Courier New", Font.BOLD, 12);
        studentList.setFont(monospacedFont);

        listModel.addElement(String.format("%-4s %-35s %-20s %-20s %-20s %-5s %-10s %-15s %-15s %-10s %-10s %-10s %s\n",
                "Lp.", "Identyfikacja", "Imie", "Nazwisko", "PESEL", "Wiek", "Plec", "Nr indeksu", "Rok studiow", "Stopien", "Erasmus", "Zdalnie", "Lista kursow"));

        for (int i = 0; i < uniDatabase.getStudentsList().size(); i++) {
            Person p = uniDatabase.getStudentsList().get(i);
            Student st = (Student) p;
            listModel.addElement(String.format("%-4s %s \n",
                    (i + 1), st.toString()));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == backButton){
            frame.dispose();

        }

    }
}
