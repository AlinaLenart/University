package GUI.SortPanels;

import Databases.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortPanel implements ActionListener {
    private University uniDatabase;
    private Courses coursesDatabase;
    private JFrame frame = new JFrame();;
    private JButton peopleButton;
    private JButton coursesButton;

    public SortPanel(University uniDatabase, Courses coursesDatabase){

        this.uniDatabase = uniDatabase;
        this.coursesDatabase = coursesDatabase;

        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        peopleButton = new JButton("Sort People Database");
        peopleButton.setPreferredSize(new Dimension(350,200));
        peopleButton.setFocusable(false);
        peopleButton.addActionListener(this);

        coursesButton = new JButton("Sort Courses Database");
        coursesButton.setPreferredSize(new Dimension(350,200));
        coursesButton.setFocusable(false);
        coursesButton.addActionListener(this);

        frame.add(peopleButton);
        frame.add(coursesButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == peopleButton)
            new SortPeoplePanel(uniDatabase);

        else if(e.getSource() == coursesButton)
            new SortCoursesPanel(coursesDatabase);


        frame.dispose();
    }

}
