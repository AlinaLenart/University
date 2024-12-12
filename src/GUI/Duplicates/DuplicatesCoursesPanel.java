package GUI.Duplicates;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import Databases.*;
import Person.*;
import Student.*;

import javax.swing.*;

public class DuplicatesCoursesPanel implements ActionListener {
    private Courses coursesDatabase;
    private JFrame frame;
    private JButton confirmButton;
    private JButton quitButton;
    private JList<String> coursesList;
    private DefaultListModel<String> listModel;

    public DuplicatesCoursesPanel(Courses coursesDatabase){

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

        ArrayList<Course> coursesArrayList = coursesDatabase.getCourseArrayList();
        listModel.clear();

        Font monospacedFont = new Font("Courier New", Font.BOLD, 12);
        coursesList.setFont(monospacedFont);

        listModel.addElement(String.format("%-4s %-30s %-40s %-15s\n",
                "Lp.", "Nazwa", "Prowadzacy", "Punkty ECTS"));

        for (int i = 0; i < coursesArrayList.size(); i++) {
            Course c = coursesArrayList.get(i);
            listModel.addElement(String.format("%-4s %s \n",
                    (i + 1), c.toString()));

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == quitButton){
            frame.dispose();
        }
        else if(e.getSource() == confirmButton){

            HashSet<Course> noDuplicatesDatabase = new HashSet<>(coursesDatabase.getCourseArrayList());
            ArrayList<Course> noDuplicatesArraylist = new ArrayList<>(noDuplicatesDatabase);
            coursesDatabase.setCourseArrayList(noDuplicatesArraylist);

            JOptionPane.showMessageDialog(frame,
                    "Baza zaaktualizowana\n",
                    "Udane",
                    JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
        }
    }
}