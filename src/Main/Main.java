package Main;
import Databases.*;
import java.util.Arrays;
import java.lang.reflect.Array;


public class Main {

    public static void main(String[] args) {

        University uniDatabase = new University();
        Courses coursesDatabase = new Courses();
        uniDatabase.loadDatabaseFromFile("uniDatabase.ser");
        coursesDatabase.loadDatabaseFromFile("coursesDatabase.ser");

        Menu menu = new Menu(uniDatabase, coursesDatabase);
        menu.displayMenu();

        uniDatabase.saveDatabaseToFile("uniDatabase.ser");
        coursesDatabase.saveDatabaseToFile("coursesDatabase.ser");


    }

}