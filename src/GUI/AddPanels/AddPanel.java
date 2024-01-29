package GUI.AddPanels;

import Databases.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPanel implements ActionListener {
    private University uniDatabase;
    private Courses coursesDatabase;
    private JFrame frame = new JFrame();;
    private JButton peopleButton;
    private JButton coursesButton;

    public AddPanel(University uniDatabase, Courses coursesDatabase){

        this.uniDatabase = uniDatabase;
        this.coursesDatabase = coursesDatabase;

        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        peopleButton = new JButton("Add to People Database");
        peopleButton.setPreferredSize(new Dimension(350,200));
        peopleButton.setFocusable(false);
        peopleButton.addActionListener(this);

        coursesButton = new JButton("Add to Courses Database");
        coursesButton.setPreferredSize(new Dimension(350,200));
        coursesButton.setFocusable(false);
        coursesButton.addActionListener(this);

        frame.add(peopleButton);
        frame.add(coursesButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == peopleButton){
            frame.dispose();
            new AddPeoplePanel(uniDatabase, coursesDatabase);
        }
        else if(e.getSource() == coursesButton) {
            frame.dispose();
            new AddCoursePanel(coursesDatabase);
        }

    }

}
