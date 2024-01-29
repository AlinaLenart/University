package GUI.DisplayPanels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Databases.*;
import Person.*;
import Student.*;

import javax.swing.*;

public class DisplayCourses implements ActionListener {
    private Courses coursesDatabase;
    private JFrame frame;
    private JButton backButton;
    private JList<String> coursesList;
    private DefaultListModel<String> listModel;

    public DisplayCourses(Courses coursesDatabase){

        this.coursesDatabase = coursesDatabase;

        frame = new JFrame();
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Courses Database");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        coursesList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(coursesList);
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

        if(e.getSource() == backButton){
            frame.dispose();

        }

    }
}
