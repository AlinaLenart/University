package SortingCourses;

import Student.*;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByTeacherSurname implements CoursesStrategy, Comparator<Course>{


    public void sort(ArrayList<Course> coursesDatabase){

        coursesDatabase.sort(this);
    }

    @Override
    public int compare(Course p1, Course p2) {

        String t1 = p1.getTeacher();
        String[] s1 = t1.split(" ");
        String t2 = p2.getTeacher();
        String[] s2 = t2.split(" ");

        return s1[1].compareToIgnoreCase(s2[1]);
    }

}
