package GUI.SearchPanels;

import Databases.University;
import Person.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PeopleResultsDisplay implements ActionListener {
    private ArrayList<Person> resultsList;
    private University uniDatabase;
    private String chosenType;
    private JFrame frame;
    private JButton backButton;
    private JButton deleteButton;
    private JList<String> peopleList;
    private DefaultListModel<String> listModel;

    public PeopleResultsDisplay(ArrayList<Person> resultsList, University uniDatabase, String chosenType){
        this.resultsList = resultsList;
        this.uniDatabase = uniDatabase;
        this.chosenType =chosenType;

        frame = new JFrame();
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Baza Osób");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        peopleList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(peopleList);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        deleteButton = new JButton("Usuń Osobe");
        deleteButton.setPreferredSize(new Dimension(120, 50));
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);

        backButton = new JButton("Wróć do menu");
        backButton.setPreferredSize(new Dimension(120, 50));
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        buttonPanel.add(backButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        displayList();

        frame.setVisible(true);

    }

    private void displayList() {

        listModel.clear();

        Font monospacedFont = new Font("Courier New", Font.BOLD, 12);
        peopleList.setFont(monospacedFont);

        if(chosenType.equals("Student")){
            listModel.addElement(String.format("%-4s %-35s %-20s %-20s %-20s %-5s %-10s %-15s %-15s %-10s %-10s %-10s %s\n",
                    "Lp.", "Identyfikacja", "Imie", "Nazwisko", "PESEL", "Wiek", "Plec", "Nr indeksu", "Rok studiow", "Stopien", "Erasmus", "Zdalnie", "Lista kursow"));

        }
        else if(chosenType.equals("Employee")){
            listModel.addElement(String.format("%-4s %-35s %-20s %-20s %-20s %-10s %-10s %-25s %-15s %-15s %-30s\n",
                    "Lp.", "Identyfikacja", "Imie", "Nazwisko", "PESEL", "Wiek", "Plec", "Stanowisko", "Doswiadczenie", "Pensja", "Publikacje/Nadgodziny"));

        }

        for (int i = 0; i < resultsList.size(); i++) {
            Person p = resultsList.get(i);
            listModel.addElement(String.format("%-4s %s \n",
                    (i + 1), p.toString()));

        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == backButton){
            frame.dispose();
        }
        else if (e.getSource() == deleteButton) {
            deleteDetails();

        }

    }

    private void deleteDetails(){

        JFrame deleteFrame = new JFrame();
        deleteFrame.setSize(400, 200);
        deleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deleteFrame.setLocationRelativeTo(null);
        deleteFrame.setLayout(new BorderLayout());
        deleteFrame.setVisible(true);

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel inputLabel = new JLabel("Wprowadz numer do usuniecia:");
        inputPanel.add(inputLabel);
        JTextField inputField = new JTextField(5);
        inputPanel.add(inputField);

        deleteFrame.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton confirmButton = new JButton("Potwierdz");
        confirmButton.setPreferredSize(new Dimension(120, 50));
        confirmButton.setFocusable(false);
        buttonPanel.add(confirmButton);

        JButton back2Button = new JButton("Cofnij");
        back2Button.setPreferredSize(new Dimension(120, 50));
        back2Button.setFocusable(false);
        buttonPanel.add(back2Button);

        deleteFrame.add(buttonPanel, BorderLayout.SOUTH);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int number = Integer.parseInt(inputField.getText());
                uniDatabase.delRecord(resultsList, number);

                JOptionPane.showMessageDialog(frame,
                        "Usunieto osobe: \n" +
                                resultsList.get(number - 1),
                        "Udane!",
                        JOptionPane.INFORMATION_MESSAGE);

                deleteFrame.dispose();
                frame.dispose();

            }
        });

        back2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFrame.dispose();
                frame.dispose();
            }
        });

    }

}
