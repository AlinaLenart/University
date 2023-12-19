package Main;
import Student.*;
import Database.*;
import Person.Person;


public class Main {

    public static void main(String[] args) {

        University uniDatabase = new University();
        Courses coursesDatabase = new Courses();
        uniDatabase.loadDatabaseFromFile("uniDatabase.ser");
        coursesDatabase.loadDatabaseFromFile("coursesDatabase.ser");
        uniDatabase.displayDatabase(Person.class);
        coursesDatabase.displayDatabase(Course.class);
        Menu menu = new Menu(uniDatabase, coursesDatabase);
        menu.displayMenu();

        uniDatabase.saveDatabaseToFile("uniDatabase.ser");
        coursesDatabase.saveDatabaseToFile("coursesDatabase.ser");


    }

}