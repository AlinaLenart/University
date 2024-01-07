package Comparators;
import Student.*;
import java.util.Comparator;

public class EctsComparator implements Comparator<Course> {
    public int compare(Course c1, Course c2) {
        //malejaco
        return Integer.compare(c2.getEcts(), c1.getEcts());
    }

}
