package SortingUniversity;
import Person.*;
import java.util.ArrayList;
import java.util.Comparator;

public class SortBySurname implements UniversityStrategy, Comparator<Person> {

    public void sort(ArrayList<Person> uniDatabase){
        uniDatabase.sort(this);
    }

    @Override
    public int compare(Person p1, Person p2) {

        return p1.getName().compareToIgnoreCase(p2.getName());
    }


}
