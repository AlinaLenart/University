package GUI;

import Databases.*;
import GUI.AddPanels.AddPanel;
import GUI.DisplayPanels.DisplayPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Menu implements ActionListener {

    private University uniDatabase;
    private Courses coursesDatabase;
    private JFrame frame = new JFrame();
    private JButton addButton;
    private JButton displayButton;


    public Menu(University uniDatabase, Courses coursesDatabase){

        this.uniDatabase = uniDatabase;
        this.coursesDatabase = coursesDatabase;

        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveAndExit();
            }
        });

        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(350,200));
        addButton.setFocusable(false);
        addButton.addActionListener(this);

        displayButton = new JButton("Display");
        displayButton.setPreferredSize(new Dimension(350,200));
        displayButton.setFocusable(false);
        displayButton.addActionListener(this);

        frame.add(addButton);
        frame.add(displayButton);
        frame.setVisible(true);



    }

    private void saveAndExit() {
        uniDatabase.saveDatabaseToFile("uniDatabase.ser");
        coursesDatabase.saveDatabaseToFile("coursesDatabase.ser");
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    //TODO zmien na switch
        if(e.getSource() == addButton){

            AddPanel addPanel = new AddPanel(uniDatabase, coursesDatabase);

        }

        else if(e.getSource() == displayButton){

            DisplayPanel displayPanel = new DisplayPanel(uniDatabase, coursesDatabase);

        }

    }




}
