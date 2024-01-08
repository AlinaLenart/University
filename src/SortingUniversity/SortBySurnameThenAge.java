package SortingUniversity;
import Person.*;
import java.util.ArrayList;
import java.util.Comparator;

public class SortBySurnameThenAge implements UniversityStrategy, Comparator<Person> {

    public void sort(ArrayList<Person> uniDatabase){

        uniDatabase.sort(this);
    }

    @Override
    public int compare(Person p1, Person p2) {

        int surnameComparison = p1.getSurname().compareToIgnoreCase(p2.getSurname());

        if (surnameComparison == 0) {

            return Integer.compare(p2.getAge(), p1.getAge());
        }
        else {

            return surnameComparison;
        }
    }

}
