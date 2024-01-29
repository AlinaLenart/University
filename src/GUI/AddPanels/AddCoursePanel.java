package GUI.AddPanels;

import Databases.Courses;
import Student.Course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCoursePanel implements ActionListener {
    private Courses coursesDatabase;
    private JFrame frame = new JFrame();
    private JButton confirmButton;
    private JTextField nameField = new JTextField(20);
    private JTextField teacherField = new JTextField(30);
    private JTextField ectsField = new JTextField(20);


    public AddCoursePanel(Courses coursesDatabase){

        this.coursesDatabase = coursesDatabase;

        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 5));

        inputPanel.add(new JLabel("Nazwa Kursu:"));
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Prowadzący:"));
        inputPanel.add(teacherField);

        inputPanel.add(new JLabel("Punkty ECTS:"));
        inputPanel.add(ectsField);

        confirmButton = new JButton("Potwierdź");
        confirmButton.addActionListener(this);

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(confirmButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirmButton){

            String name = nameField.getText();
            String teacher = teacherField.getText();
            int ects = Integer.parseInt(ectsField.getText());

            Course course = new Course(name, teacher, ects);
            coursesDatabase.addRecord(course);

            JOptionPane.showMessageDialog(frame,
                    "Kurs został pomyślnie dodany:\n" +
                            "Nazwa: " + name +
                            "\nProwadzacy: " + teacher +
                            "\nPunkty ECTS: " + ects,
                        "Kurs Dodany",
                            JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();


        }
    }


}
