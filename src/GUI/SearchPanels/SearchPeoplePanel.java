package GUI.SearchPanels;

import Databases.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPeoplePanel implements ActionListener {

    private University uniDatabase;
    private JFrame frame = new JFrame();
    private JButton studentsButton;
    private JButton employeesButton;

    public SearchPeoplePanel(University uniDatabase){

        this.uniDatabase = uniDatabase;

        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));


        studentsButton = new JButton("Szukaj w Studentach");
        studentsButton.setPreferredSize(new Dimension(350,200));
        studentsButton.setFocusable(false);
        studentsButton.addActionListener(this);

        employeesButton = new JButton("Szukaj w Pracownikach");
        employeesButton.setPreferredSize(new Dimension(350,200));
        employeesButton.setFocusable(false);
        employeesButton.addActionListener(this);

        frame.add(studentsButton);
        frame.add(employeesButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == studentsButton) {
            frame.dispose();
            new SearchStudentPanel(uniDatabase);
        }
        else if(e.getSource() == employeesButton) {
            frame.dispose();
            new SearchEmployeePanel(uniDatabase);
        }
    }

}

