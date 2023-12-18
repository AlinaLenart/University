package Main;

import Employees.*;
import Student.*;
import Database.*;
import Person.Person;

public class Main {
    public static void main(String[] args) {
        University uniDatabase = new University();
        Courses coursesList = new Courses();

        UniversityEmployee adm1 = new AdministrationEmployee("Dariusz", "Miodek", "11135543124", 32, 'M', 1, 4, 4300, 4);
        UniversityEmployee adm2 = new AdministrationEmployee("Kamil", "Mlotek", "47332343123", 40, 'M', 2, 7, 4, 6);
        UniversityEmployee adm3 = new AdministrationEmployee("Katarzyna", "Kamien", "13732343133", 46, 'F', 3, 15, 4800, 0);
        UniversityEmployee adm4 = new AdministrationEmployee("Janusz", "Piorko", "98732343123", 53, 'M', 4, 25, 5300, 3);

        UniversityEmployee dyd1 = new ResearchEmployee("Iwoma", "Kopytko", "97153467188", 33, 'F', 1, 5, 4200, 1);
        UniversityEmployee dyd2 = new ResearchEmployee("Mateusz", "Korytko", "94323467238", 34, 'M', 2, 7, 4450, 4);
        UniversityEmployee dyd3 = new ResearchEmployee("Michal", "Mysliciel", "23163467168", 40, 'M', 3, 6, 4670, 5);
        UniversityEmployee dyd4 = new ResearchEmployee("Mariola", "Hibiskus", "17153367922", 53, 'F', 4, 15, 4900, 12);
        UniversityEmployee dyd5 = new ResearchEmployee("Piotr", "Wysoki", "87658884123", 55, 'M', 5, 20, 5300, 22);

        coursesList.displayDatabase();

        int[] sa1 = {0, 1, 3, 4, 5, 6, 7};
        Person st1 = new Student("Alina","Lenart", "04040404040", 19, 'K',
                280588, 1, false, 1, false,
                coursesList.createSchedule(sa1));

        int[] sa2 = {2, 5, 6, 3, 0};
        Person st2 = new Student("Aniela","Lampart", "90121323128", 23, 'K',
                280588, 1, false, 1, false,
                coursesList.createSchedule(sa2));

        uniDatabase.addRecord(adm1);
        uniDatabase.addRecord(adm2);
        uniDatabase.addRecord(adm3);
        uniDatabase.addRecord(adm4);
        uniDatabase.addRecord(dyd1);
        uniDatabase.addRecord(dyd2);
        uniDatabase.addRecord(dyd3);
        uniDatabase.addRecord(dyd4);
        uniDatabase.addRecord(dyd5);
        uniDatabase.addRecord(st1);
        uniDatabase.addRecord(st2);

        uniDatabase.displayRecords(AdministrationEmployee.class);

        System.out.println("\n -------Wyszukiwanie-------- \n");

        //do wyszukiwanie stosuje regex
        //^xyz - wyrazenie zaczynajace sie od xyz
        //xyz.*? - posiadajace dana kombinacje liter chociaz raz w sobie np. ta*.? pokaze Katarzyne i Mateusza

        uniDatabase.searchByEmployeeName("Ka.*?");
        uniDatabase.searchByEmployeeSurname("Miodek");
        uniDatabase.searchByPositionID(3);
        uniDatabase.searchByPositionName("Wykladowca");
        uniDatabase.searchByQuantity(4);

        uniDatabase.searchByStudentName("^A");
        uniDatabase.searchByStudentSurname("Lenart");
        uniDatabase.searchByStudentID(280588);
        uniDatabase.searchByYear(1);
        uniDatabase.searchByCourseName("Algebra");

        coursesList.searchByName("^A");
        coursesList.searchByEcts(7);
        coursesList.searchByTeacher("Wysocki");


    }
}