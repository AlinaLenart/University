package Comparators;
import Person.*;
import java.util.Comparator;

public class SurnameComparator implements Comparator<Person>{

    public int compare(Person p1, Person p2) {

        return p1.getSurname().compareToIgnoreCase(p2.getSurname());
    }

}


