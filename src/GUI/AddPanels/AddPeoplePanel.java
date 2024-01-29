package GUI.AddPanels;

import Databases.Courses;
import Databases.University;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPeoplePanel extends JFrame implements ActionListener {

    private University uniDatabase;
    private Courses coursesDatabase;
    private JFrame frame;
    private JButton nextButton;
    private JComboBox<String> typeComboBox;

    public AddPeoplePanel(University uniDatabase, Courses coursesDatabase){

        this.uniDatabase = uniDatabase;
        this.coursesDatabase = coursesDatabase;

        frame = new JFrame();
        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setVisible(true);

        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(100,50));
        nextButton.setFocusable(false);
        nextButton.addActionListener(this);

        frame.add(new JLabel("Select Type:"));
        typeComboBox = new JComboBox<>(new String[]{"Student", "Research Employee", "Administration Employee"});


        frame.add(typeComboBox);
        frame.add(nextButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == nextButton){
            String selectedType = (String) typeComboBox.getSelectedItem();
            handleSelectedType(selectedType);

        }

    }

    private void handleSelectedType(String selectedType) {

        switch (selectedType) {
            case "Student":
                new AddStudent(uniDatabase, coursesDatabase);
                frame.dispose();
                break;
            case "Research Employee":
                new AddResEmployee(uniDatabase);
                frame.dispose();
                break;
            case "Administration Employee":
                new AddAdmEmployee(uniDatabase);
                frame.dispose();
                break;
        }
    }


}
