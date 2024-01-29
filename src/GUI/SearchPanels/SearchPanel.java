package GUI.SearchPanels;


import Databases.*;
import GUI.SortPanels.SortCoursesPanel;
import GUI.SortPanels.SortPeoplePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel implements ActionListener {
    private University uniDatabase;
    private Courses coursesDatabase;
    private JFrame frame = new JFrame();;
    private JButton peopleButton;
    private JButton coursesButton;

    public SearchPanel(University uniDatabase, Courses coursesDatabase){

        this.uniDatabase = uniDatabase;
        this.coursesDatabase = coursesDatabase;

        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        peopleButton = new JButton("Szukaj w bazie Osób");
        peopleButton.setPreferredSize(new Dimension(350,200));
        peopleButton.setFocusable(false);
        peopleButton.addActionListener(this);

        coursesButton = new JButton("Szukaj w bazie Kursów");
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
             new SearchPeoplePanel(uniDatabase);

        else if(e.getSource() == coursesButton)
            new SearchCoursesPanel(coursesDatabase);


        frame.dispose();
    }

}
