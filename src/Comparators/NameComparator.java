package Comparators;
import Person.Person;
import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {

        return p1.getName().compareToIgnoreCase(p2.getName());
    }

}
