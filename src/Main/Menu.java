package Main;
import Databases.*;
import Person.*;
import Employees.*;
import Student.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
    private University uniDatabase;
    private Courses coursesDatabase;
    private ArrayList<Person> delPersonRecords;
    private boolean exit = false;
    private Scanner scanner = new Scanner(System.in);
    public Menu(University uniDatabase, Courses coursesDatabase){
        this.uniDatabase = uniDatabase;
        this.coursesDatabase = coursesDatabase;
    }
    public University getUniDatabase() {
        return uniDatabase;
    }

    public Courses getCoursesDatabase() {
        return coursesDatabase;
    }

    public boolean isExit() {
        return exit;
    }

    public void displayMenu(){

        while(!exit) {

            clearConsole();
            System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n",

                    "1: Wyswietl baze",
                    "2: Wyszukaj informacje w bazie",
                    "3: Dodaj Osobe",
                    "4: Dodaj Kurs",
                    "5: Usun dane",
                    "6: Sortuj baze",

                    "[-1]: Zakoncz");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    displayChoice();
                    break;
                case 2:
                    searchChoice();
                    break;
                case 3:
                    addPerson();
                    break;
                case 4:
                    addCourse();
                    break;

                case 5:
                    delOptions();
                     break;
                case 6:
                    sortChoice();
                    break;
                case -1:
                    exit = true;
                    scanner.close();
                default:
                    break;
            }
        }
    }
    public void displayChoice(){
        clearConsole();
        System.out.printf("%s\n%s\n",
                "1: Wyswietl baze Osob",
                "2: Wyswietl baze Kursow");

        int choice = scanner.nextInt();

        switch(choice){
            case 1: //wyswietl osoby
                displayPeople();
                break;
            case 2: //wyswietl kursy
                coursesDatabase.displayDatabase(Course.class);
                break;
            default:
                displayMenu();
                break;
        }

    }
    public void displayPeople(){
        clearConsole();
        System.out.printf("%s\n%s\n%s\n",
                "1: Wyswietl cala baze",
                "2: Wyswietl tylko Studentow",
                "3: Wyswietl tylko Pracownikow");

        int choice = scanner.nextInt();

        switch(choice){
            case 1: //wyswietl wszystkich
                uniDatabase.displayDatabase(Person.class);
                break;
            case 2: //wyswietl studentow
                uniDatabase.displayDatabase(Student.class);
                break;
            case 3: //wyswietl pracownikow
                displayEmployees();
                break;
            default:
                displayChoice();
                break;
        }
    }
    public void displayEmployees(){
        clearConsole();
        System.out.printf("%s\n%s\n%s\n",
                "1: Wyswietl wszystkich Pracownikow",
                "2: Wyswietl Pracownikow Administracyjnych",
                "3: Wyswietl Pracownikow Badawczo-Dydaktycznych");

        int choice = scanner.nextInt();

        switch(choice){
            case 1: //wyswietl wszystkich
                uniDatabase.displayDatabase(UniversityEmployee.class);
                break;
            case 2: //wyswietl pracownikow adm
                uniDatabase.displayDatabase(AdministrationEmployee.class);
                break;
            case 3: //wyswietl pracownikow dyd
                uniDatabase.displayDatabase(ResearchEmployee.class);
            default:
                displayPeople();
                break;
        }
    }

    public void searchChoice(){
        clearConsole();

        System.out.printf("%s\n%s\n",
                "1: Szukaj w Osobach",
                "2: Szukaj w Kursach");

        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                searchPeople();
                break;
            case 2:
                searchCourse();
                break;
            default:
                displayMenu();
                break;
        }
    }

    public void searchPeople(){
        clearConsole();

        System.out.printf("%s\n%s\n",
                "1: Szukaj w Uczniach",
                "2: Szukaj w Pracownikach");

        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                searchStudent();
                break;
            case 2:
                searchEmployee();
                break;
            default: //cofnij
                searchChoice();
                break;
        }
    }
    public void searchStudent(){
        clearConsole();
        System.out.printf("%s\n%s\n%s\n%s\n%s\n",
                "1: Szukaj po imieniu",
                "2: Szukaj po nazwisku",
                "3: Szukaj po nr indeksu",
                "4: Szukaj po roku studiow",
                "5: Szukaj po nazwie kursu");

        int choice = scanner.nextInt();

        System.out.println("---- Wprowadź fraze do wyszukania: ----");
        String s = scanner.nextLine();

        switch (choice){
            case 1:
                String ans = scanner.nextLine();
                ArrayList<Person> studentName = uniDatabase.searchByStudentName(ans);
                uniDatabase.displaySearchRecord(studentName);
                delPersonRecords = studentName;
                break;
            case 2:
                String ans2 = scanner.nextLine();
                ArrayList<Person> studentsSurname = uniDatabase.searchByStudentSurname(ans2);
                uniDatabase.displaySearchRecord(studentsSurname);
                delPersonRecords = studentsSurname;
                break;
            case 3:
                int ans3 = scanner.nextInt();
                ArrayList<Person> studentsID = uniDatabase.searchByStudentID(ans3);
                uniDatabase.displaySearchRecord(studentsID);
                delPersonRecords = studentsID;
                break;
            case 4:
                int ans4 = scanner.nextInt();
                ArrayList<Person> studentsYear = uniDatabase.searchByYear(ans4);
                uniDatabase.displaySearchRecord(studentsYear);
                delPersonRecords = studentsYear;
                break;
            case 5:
                String ans5 = scanner.nextLine();
                ArrayList<Person> studentsCourseName = uniDatabase.searchByCourseName(ans5);
                uniDatabase.displaySearchRecord(studentsCourseName);
                delPersonRecords = studentsCourseName;
                break;
        }
    }

    public void searchEmployee(){
        clearConsole();
        System.out.printf("%s\n%s\n%s\n%s\n%s\n",
                "1: Szukaj po imieniu",
                "2: Szukaj po nazwisku",
                "3: Szukaj po numerze stanowiska",
                "4: Szukaj po nazwie stanowiska",
                "5: Szukaj po stażu pracy",
                "6: Szukaj po pensji",
                "7: Szukaj po liczbie nadgodzin (tylko dla Pracowników Administracyjnych",
                "8: Szukaj po ilosci publikacji (tylko dla Pracowników Badawczo-Dydaktycznych",
                "9: Szukaj po ilosci dowolnej");

        int choice = scanner.nextInt();
        System.out.println("---- Wprowadz fraze do wyszukania: ----");
        String s = scanner.nextLine();

        switch (choice){
            case 1:
                String ans = scanner.nextLine();
                ArrayList<Person> employeeName = uniDatabase.searchByEmployeeName(ans);
                uniDatabase.displaySearchRecord(employeeName);
                break;
            case 2:
                String ans2 = scanner.nextLine();
                ArrayList<Person> employeeSurname = uniDatabase.searchByEmployeeSurname(ans2);
                uniDatabase.displaySearchRecord(employeeSurname);
                break;
            case 3:
                int ans3 = scanner.nextInt();
                ArrayList<Person> employeeID = uniDatabase.searchByPositionID(ans3);
                uniDatabase.displaySearchRecord(employeeID);
                break;
            case 4:
                String ans4 = scanner.nextLine();
                ArrayList<Person> employeePosition = uniDatabase.searchByPositionName(ans4);
                uniDatabase.displaySearchRecord(employeePosition);
                break;
            case 5:
                int ans5 = scanner.nextInt();
                ArrayList<Person> employeeExperience = uniDatabase.searchByWorkExperience(ans5);
                uniDatabase.displaySearchRecord(employeeExperience);
                break;
            case 6:
                double ans6 = scanner.nextInt();
                ArrayList<Person> employeeSalary = uniDatabase.searchBySalary(ans6);
                uniDatabase.displaySearchRecord(employeeSalary);
                break;
            case 7:
                int ans7 = scanner.nextInt();
                ArrayList<Person> employeeOvertime = uniDatabase.searchByOvertime(ans7);
                uniDatabase.displaySearchRecord(employeeOvertime);
                break;
            case 8:
                int ans8 = scanner.nextInt();
                ArrayList<Person> employeeRelease = uniDatabase.searchByReleases(ans8);
                uniDatabase.displaySearchRecord(employeeRelease);
                break;
            case 9:
                double ans9 = scanner.nextInt();
                ArrayList<Person> emplyeeQuantity = uniDatabase.searchByQuantity(ans9);
                uniDatabase.displaySearchRecord(emplyeeQuantity);
                break;

        }
    }
    public void searchCourse(){
        clearConsole();

        System.out.printf("%s\n%s\n",
                "1: Szukaj po nazwie Kursu",
                "2: Szukaj po prowadzacym Kurs",
                "3: Szukaj po punktach ECTS");

        int choice = scanner.nextInt();
        System.out.println("---- Wprowadz fraze do wyszukania: ----");
        String s = scanner.nextLine();

        switch (choice){
            case 1:
                String ans = scanner.nextLine();
                coursesDatabase.searchByName(ans);
                break;
            case 2:
                String ans2 = scanner.nextLine();
                coursesDatabase.searchByTeacher(ans2);
                break;
            case 3:
                int ans3 = scanner.nextInt();
                coursesDatabase.searchByEcts(ans3);
                break;
        }
    }
    public void addPerson(){
        clearConsole();

        System.out.printf("%s\n%s\n",
                "1: Dodaj Studenta",
                "2: Dodaj Pracownika");

        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                addStudent();
                break;
            case 2:
                addEmployee();
                break;
            default:
                displayMenu();
                break;
        }
    }
    public void addStudent(){
        System.out.println("--- Wprowadz dane aby dodac Osobe do bazy ---");
        String s = scanner.nextLine();

        System.out.println("Podaj imie: ");
        String name = scanner.nextLine();

        System.out.println("Podaj nazwisko: ");
        String surname = scanner.nextLine();

        System.out.println("Podaj PESEL: ");
        String pesel = scanner.nextLine();

        System.out.println("Podaj wiek: ");
        int age = scanner.nextInt();

        System.out.println("Podaj plec (F/M): ");
        char sex = scanner.next().charAt(0);

        System.out.println("Podaj nr indeksu: ");
        int studentID = scanner.nextInt();

        System.out.println("Podaj rok studiow: ");
        int year = scanner.nextInt();

        System.out.println("Czy uczen jest w programie erasmus (true/false):");
        boolean erasmus = scanner.nextBoolean();

        System.out.println("Podaj stopien studiow: ");
        int degree = scanner.nextInt();

        System.out.println("Czy uczen studiuje zdalnie (true/false): ");
        boolean remote = scanner.nextBoolean();

        System.out.println("** Wybierz kursy dla studenta podajac liczby sposrod: **");
        coursesDatabase.displayDatabase(Course.class);


        int[] answers = new int[coursesDatabase.getCourseArrayList().size()];
        int choice = 0;
        System.out.println("*Aby przerwac dodawanie kursow wpisz -1*");

        int i = 0;

        do{

            choice = scanner.nextInt();

            answers[i] = choice;
            i++;

        } while(choice != -1);

        Student st = new Student(name, surname, pesel, age, sex, studentID, year, erasmus, degree, remote,
                coursesDatabase.createSchedule(answers));
        uniDatabase.addRecord(st);

        System.out.println("\n--- Dodales studenta o nastepujacych danych: ---");
        System.out.println(st + "\n");

    }
    public void addEmployee(){
        clearConsole();

        System.out.printf("%s\n%s\n",
                "1: Dodaj Pracownika Administracyjnego",
                "2: Dodaj Pracownika Badawczo-Dydaktycznego");

        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                addAdministrationEmployee();
                break;
            case 2:
                addResearchEmployee();
                break;
            default: //cofnij
                addPerson();
                break;

        }
        
    }
    public void addAdministrationEmployee(){
        System.out.println("--- Wprowadz dane aby dodac Osobe do bazy ---");
        String s = scanner.nextLine();

        System.out.println("Podaj imie: ");
        String name = scanner.nextLine();

        System.out.println("Podaj nazwisko: ");
        String surname = scanner.nextLine();

        System.out.println("Podaj PESEL: ");
        String pesel = scanner.nextLine();

        System.out.println("Podaj wiek: ");
        int age = scanner.nextInt();

        System.out.println("Podaj plec (F/M): ");
        char sex = scanner.next().charAt(0);

        System.out.println("Podaj nr stanowiska sposrod: ");
        System.out.println("[1]: Referent \n" +
                "[2]: Specjalista \n" +
                "[3]: Starszy Specjalista \n" +
                "[4]: Nadzorujacy Badania \n" +
                "[5]: Prezes Zarzadu");
        int position = scanner.nextInt();

        System.out.println("Podaj staz pracy (w latach): ");
        int workExperience = scanner.nextInt();

        System.out.println("Podaj pensje: ");
        double salary = scanner.nextDouble();

        System.out.println("Podaj ilosc nadgodzin (zaokraglonych do calosci): ");
        int overtime = scanner.nextInt();

        UniversityEmployee adm = new AdministrationEmployee(name, surname, pesel, age, sex, position, workExperience, salary, overtime);
        uniDatabase.addRecord(adm);

        System.out.println("\n--- Dodales Pracownika o nastepujacych danych: ---");
        System.out.println(adm + "\n");

    }
    public void addResearchEmployee() {
        System.out.println("--- Wprowadz dane aby dodac Osobe do bazy ---");
        String s = scanner.nextLine();

        System.out.println("Podaj imie: ");
        String name = scanner.nextLine();

        System.out.println("Podaj nazwisko: ");
        String surname = scanner.nextLine();

        System.out.println("Podaj PESEL: ");
        String pesel = scanner.nextLine();

        System.out.println("Podaj wiek: ");
        int age = scanner.nextInt();

        System.out.println("Podaj plec (F/M): ");
        char sex = scanner.next().charAt(0);

        System.out.println("Podaj nr stanowiska sposrod: ");
        System.out.println("[1]: Asystent \n" +
                "[2]: Adiunkt \n" +
                "[3]: Profesor Zwyczajny \n" +
                "[4]: Profesor Nadzwyczajny \n" +
                "[5]: Wykladowca");
        int position = scanner.nextInt();

        System.out.println("Podaj staz pracy (w latach): ");
        int workExperience = scanner.nextInt();

        System.out.println("Podaj pensje: ");
        double salary = scanner.nextDouble();

        System.out.println("Podaj ilosc publikacji: ");
        int releases = scanner.nextInt();

        UniversityEmployee dyd = new ResearchEmployee(name, surname, pesel, age, sex, position, workExperience, salary, releases);
        uniDatabase.addRecord(dyd);

        System.out.println("\n--- Dodales Pracownika o nastepujacych danych: ---");
        System.out.println(dyd + "\n");
    }
    public void addCourse(){
        System.out.println("--- Wprowadz dane aby dodac Kurs do bazy ---");
        String s = scanner.nextLine();

        System.out.println("Podaj nazwe: ");
        String name = scanner.nextLine();

        System.out.println("Podaj imie i nazwisko prowadzacego: ");
        String teacher = scanner.nextLine();

        System.out.println("Podaj ilosc punktow ECTS: ");
        int ects = scanner.nextInt();

        Course c = new Course(name, teacher, ects);
        coursesDatabase.addRecord(c);

        System.out.println("\n--- Dodales Kurs o nastepujacych danych: ---");
        System.out.println(c + "\n");
    }
    public void delOptions(){

        searchChoice();
        System.out.print("Podaj indeks, ktory chcesz usunac: ");
        int index = scanner.nextInt();
        uniDatabase.delRecord(delPersonRecords, index);

    }

    public void sortChoice(){
        clearConsole();

        System.out.printf("%s\n%s\n",
                "1: Sortuj baze Osob",
                "2: Sortuj baze Kursow");

        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                sortPersonDatabase();
                break;
            case 2:
                sortCoursesDatabase();
                break;
            default:
                displayMenu();
                break;
        }
    }
    public void sortPersonDatabase(){
        clearConsole();

        System.out.printf("%s\n%s\n%s\n",
                "1: Sortuj po nazwisku",
                "2: Sortuj po nazwisku i imieniu",
                "3: Sortuj po nazwisku i wieku");

        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                uniDatabase.sortBySurname();
                break;
            case 2:
                uniDatabase.sortBySurnameThenName();
                break;
            case 3:
                uniDatabase.sortBySurnameThenAge();
                break;
            default:
                sortChoice();
                break;
        }
    }
    public void sortCoursesDatabase(){
        clearConsole();

        System.out.printf("%s\n%s\n",
                "1: Sortuj po nazwisku prowadzacego",
                "2: Sortuj po punktach ECTS");

        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                coursesDatabase.sortByTeacherSurname();
                break;
            case 2:
                coursesDatabase.sortByEcts();
                break;
            default:
                sortChoice();
                break;
        }
    }







    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("---- Wybierz numer: -----");
    }


}
