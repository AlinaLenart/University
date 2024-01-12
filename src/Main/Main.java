package Main;

import DatabaseObserver.*;
import Databases.*;


public class Main {

    public static void main(String[] args) {

        University uniDatabase = new University();
        Courses coursesDatabase = new Courses();
        
        DatabaseLogger logger = new DatabaseLogger();
        uniDatabase.attach(logger);
        coursesDatabase.attach(logger);

        uniDatabase.loadDatabaseFromFile("uniDatabase.ser");
        coursesDatabase.loadDatabaseFromFile("coursesDatabase.ser");

        Menu menu = new Menu(uniDatabase, coursesDatabase);
        menu.displayMenu();

        uniDatabase.saveDatabaseToFile("uniDatabase.ser");
        coursesDatabase.saveDatabaseToFile("coursesDatabase.ser");


    }

}





