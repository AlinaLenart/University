package SortingCourses;

import Student.*;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByEcts implements CoursesStrategy, Comparator<Course> {

    public void sort(ArrayList<Course> coursesDatabase){

        coursesDatabase.sort(this);
    }

    @Override
    public int compare(Course c1, Course c2) {
        //malejaco
        return Integer.compare(c2.getEcts(), c1.getEcts());
    }


}
