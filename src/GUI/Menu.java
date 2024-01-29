package GUI;

import Databases.*;
import GUI.AddPanels.AddPanel;
import GUI.DisplayPanels.DisplayPanel;
import GUI.Duplicates.DuplicatesPanel;
import GUI.SearchPanels.SearchPanel;
import GUI.SortPanels.SortPanel;

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
    private JButton sortButton;
    private JButton searchButton;


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

        addButton = new JButton("Dodaj");
        addButton.setPreferredSize(new Dimension(350,200));
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        addButton.setActionCommand("add");
        frame.add(addButton);

        displayButton = new JButton("Wyświetl");
        displayButton.setPreferredSize(new Dimension(350,200));
        displayButton.setFocusable(false);
        displayButton.addActionListener(this);
        displayButton.setActionCommand("display");
        frame.add(displayButton);

        sortButton = new JButton("Sortowanie");
        sortButton.setPreferredSize(new Dimension(350,200));
        sortButton.setFocusable(false);
        sortButton.addActionListener(this);
        sortButton.setActionCommand("sort");
        frame.add(sortButton);

        searchButton = new JButton("Szukaj/Usuń");
        searchButton.setPreferredSize(new Dimension(350,200));
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);
        searchButton.setActionCommand("search");
        frame.add(searchButton);

        searchButton = new JButton("Usuń duplikaty");
        searchButton.setPreferredSize(new Dimension(350,200));
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);
        searchButton.setActionCommand("duplicates");
        frame.add(searchButton);


        frame.setVisible(true);


    }

    public void saveAndExit() {

        uniDatabase.saveDatabaseToFile("uniDatabase.ser");
        coursesDatabase.saveDatabaseToFile("coursesDatabase.ser");
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "add":
                new AddPanel(uniDatabase, coursesDatabase);
                break;
            case "display":
                new DisplayPanel(uniDatabase, coursesDatabase);
                break;
            case "sort":
                new SortPanel(uniDatabase, coursesDatabase);
                break;
            case "search":
                new SearchPanel(uniDatabase, coursesDatabase);
                break;
            case "duplicates":
                new DuplicatesPanel(uniDatabase, coursesDatabase);


        }



    }



}
