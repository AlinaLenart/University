package GUI.DisplayPanels;

import Databases.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPanel implements ActionListener {
    private University uniDatabase;
    private Courses coursesDatabase;
    private JFrame frame = new JFrame();
    private JButton coursesButton;
    private JButton studentsButton;
    private JButton employeesButton;
    private JButton peopleButton;


    public DisplayPanel(University uniDatabase, Courses coursesDatabase){

        this.uniDatabase = uniDatabase;
        this.coursesDatabase = coursesDatabase;

        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));


        peopleButton = new JButton("Display People Database");
        peopleButton.setPreferredSize(new Dimension(350,200));
        peopleButton.setFocusable(false);
        peopleButton.addActionListener(this);

        coursesButton = new JButton("Display Courses Database");
        coursesButton.setPreferredSize(new Dimension(350,200));
        coursesButton.setFocusable(false);
        coursesButton.addActionListener(this);

        studentsButton = new JButton("Display Students");
        studentsButton.setPreferredSize(new Dimension(350,200));
        studentsButton.setFocusable(false);
        studentsButton.addActionListener(this);

        employeesButton = new JButton("Display Employees");
        employeesButton.setPreferredSize(new Dimension(350,200));
        employeesButton.setFocusable(false);
        employeesButton.addActionListener(this);

        frame.add(peopleButton);
        frame.add(coursesButton);
        frame.add(studentsButton);
        frame.add(employeesButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == peopleButton){
            frame.dispose();
            new DisplayAllPeople(uniDatabase);
        }
        else if(e.getSource() == coursesButton) {
            frame.dispose();
            new DisplayCourses(coursesDatabase);
        }
        else if(e.getSource() == studentsButton) {
            frame.dispose();
            new DisplayStudents(uniDatabase);
        }
        else if(e.getSource() == employeesButton) {
            frame.dispose();
            new DisplayEmployees(uniDatabase);
        }
    }

}

