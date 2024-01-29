package GUI.SearchPanels;

import Databases.Courses;
import Student.Course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CoursesResultsDisplay implements ActionListener {
    private ArrayList<Course> resultsList;
    private Courses coursesDatabase;
    private JFrame frame;
    private JButton backButton;
    private JButton deleteButton;
    private JList<String> coursesList;
    private DefaultListModel<String> listModel;

    public CoursesResultsDisplay(ArrayList<Course> resultsList, Courses coursesDatabase){
        this.resultsList = resultsList;
        this.coursesDatabase = coursesDatabase;

        frame = new JFrame();
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Baza Kursów");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        coursesList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(coursesList);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        deleteButton = new JButton("Usun kurs");
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
        coursesList.setFont(monospacedFont);

        listModel.addElement(String.format("%-4s %-30s %-40s %-15s\n",
                "Lp.", "Nazwa", "Prowadzacy", "Punkty ECTS"));

        for (int i = 0; i < resultsList.size(); i++) {
            Course c = resultsList.get(i);
            listModel.addElement(String.format("%-4s %s \n",
                    (i + 1), c.toString()));

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
                coursesDatabase.delRecord(resultsList, number);

                JOptionPane.showMessageDialog(frame,
                        "Usunieto Kurs: \n" +
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
