package Main;

import Database.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        University uniDatabase = new University();
        Courses coursesDatabase = new Courses();

        Menu menu = new Menu(uniDatabase, coursesDatabase);
        menu.displayMenu();


    }

}