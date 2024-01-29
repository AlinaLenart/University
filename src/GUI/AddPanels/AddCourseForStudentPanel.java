package GUI.AddPanels;

import Databases.*;
import Person.*;
import Student.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCourseForStudentPanel implements ActionListener {
    private ArrayList<Course> scheduleList = new ArrayList<>();
    private Courses coursesDatabase;
    private JFrame frame;
    private JButton endButton;
    private JButton addToListButton;
    private JList<String> coursesList;
    private DefaultListModel<String> listModel;


    public AddCourseForStudentPanel(Courses coursesDatabase, ArrayList<Course> scheduleList){

        this.coursesDatabase = coursesDatabase;
        this.scheduleList = scheduleList;

        frame = new JFrame();
        frame.setSize(1000, 600);
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

        JPanel buttonPanel = new JPanel(new FlowLayout());

        addToListButton = new JButton("Dodaj do Planu Zajęć");
        addToListButton.setPreferredSize(new Dimension(200, 100));
        addToListButton.setFocusable(false);
        addToListButton.addActionListener(this);
        buttonPanel.add(addToListButton);

        endButton = new JButton("Zakończ układanie Planu");
        endButton.setPreferredSize(new Dimension(200, 100));
        endButton.setFocusable(false);
        endButton.addActionListener(this);
        buttonPanel.add(endButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        displayList();

        frame.setVisible(true);
        frame.dispose();

    }

    public void visibility(){
        frame.setVisible(true);
    }

    private void displayList() {

        listModel.clear();

        Font monospacedFont = new Font("Courier New", Font.BOLD, 12);
        coursesList.setFont(monospacedFont);

        listModel.addElement(String.format("%-4s %-30s %-40s %-15s\n",
                "Lp.", "Nazwa", "Prowadzacy", "Punkty ECTS"));

        for (int i = 0; i < coursesDatabase.getCourseArrayList().size(); i++) {
            Course c = coursesDatabase.getCourseArrayList().get(i);
            listModel.addElement(String.format("%-4s %s \n",
                    (i + 1), c.toString()));

        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == endButton){
            frame.dispose();
        }
        else if (e.getSource() == addToListButton) {
            addDetails();

        }

    }

    private void addDetails(){

        JFrame addFrame = new JFrame();
        addFrame.setSize(400, 200);
        addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrame.setLocationRelativeTo(null);
        addFrame.setLayout(new BorderLayout());
        addFrame.setVisible(true);

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel inputLabel = new JLabel("Wprowadz numer Kursu do dodania:");
        inputPanel.add(inputLabel);

        JTextField inputField = new JTextField(5);
        inputPanel.add(inputField);

        addFrame.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton confirmButton = new JButton("Potwierdź");
        confirmButton.setPreferredSize(new Dimension(120, 50));
        confirmButton.setFocusable(false);
        buttonPanel.add(confirmButton);

        JButton back2Button = new JButton("Cofnij");
        back2Button.setPreferredSize(new Dimension(120, 50));
        back2Button.setFocusable(false);
        buttonPanel.add(back2Button);

        addFrame.add(buttonPanel, BorderLayout.SOUTH);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int number = Integer.parseInt(inputField.getText());
                addFrame.dispose();
                boolean duplicate = false;

                for (Course c : scheduleList) {
                    if(c.equals(coursesDatabase.getCourseArrayList().get(number - 1))){
                        duplicate = true;
                    }
                }

                 if(duplicate){

                     JOptionPane.showMessageDialog(frame,
                             "ERROR!!!\nPodany Kurs jest juz w planie zajęć tego Studenta:\n" +
                                     coursesDatabase.getCourseArrayList().get(number - 1),
                             "Błąd",
                             JOptionPane.INFORMATION_MESSAGE);
                 }

                 else {

                     scheduleList.add(coursesDatabase.getCourseArrayList().get(number - 1));

                     JOptionPane.showMessageDialog(frame,
                             "Dodano do Planu Zajęć Kurs: \n" +
                                     coursesDatabase.getCourseArrayList().get(number - 1),
                             "Udane!",
                             JOptionPane.INFORMATION_MESSAGE);

                 }


            }
        });

        back2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();

            }
        });

    }

    public ArrayList<Course> getScheduleList() {
        return scheduleList;
    }
}
