package Comparators;

import Person.*;
import java.util.Comparator;

public class AgeComparator implements Comparator<Person>  {
    public int compare(Person p1, Person p2) {

        return Integer.compare(p2.getAge(), p1.getAge());
    }
}
