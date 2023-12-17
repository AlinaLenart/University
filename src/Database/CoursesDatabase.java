package Database;
import Student.Course;

import java.util.ArrayList;

public class CoursesDatabase implements Database{
    ArrayList<Course> courseArrayList = new ArrayList<>();
    public CoursesDatabase(){
        courseArrayList.add(new Course("Administrowanie serwerami", "Maciej Wilk", 7));
        courseArrayList.add(new Course("Programowanie strukturalne", "Maciej Wilk", 7));
        courseArrayList.add(new Course("Bazy danych", "Henryk Mickiwicz", 7));
        courseArrayList.add(new Course("Algebra liniowa", "Piotr Wysocki", 6));
        courseArrayList.add(new Course("Tworzenie aplikacji", "Ewelina Dzik", 6));
        courseArrayList.add(new Course("Analiza matematyczna", "Adam Niski", 6));
        courseArrayList.add(new Course("Rozpoznawanie zagrozen", "Henryk Mickiwicz", 5));
        courseArrayList.add(new Course("Aplikacje webowe", "Mariusz Kopytko", 5));
        courseArrayList.add(new Course("Matematyka dyskretna", "Kacper Silny", 5));
        courseArrayList.add(new Course("Logika", "Mariusz Slaby", 5));
        courseArrayList.add(new Course("Cyberbezpieczenstwo", "Adam Slowacki", 5));
        courseArrayList.add(new Course("Architektura komputerow", "Ewelina Cytryna", 4));
        courseArrayList.add(new Course("Automatyka", "Pawel Melon", 4));
        courseArrayList.add(new Course("Automatyka przemyslowa", "Tomasz Jodla", 4));
        courseArrayList.add(new Course("Technika mikroprocesorowa", "Pawel Mydlo", 4));
        courseArrayList.add(new Course("Zastosowania inzynierii", "Piotr Mydlo", 4));
        courseArrayList.add(new Course("Struktury danych", "Pawel Kosciuch", 4));
        courseArrayList.add(new Course("Techniki skutecznego programowania", "Robert Sienkiewicz", 4));
        courseArrayList.add(new Course("Jezyk angielski", "Adrianna Dzik", 3));
        courseArrayList.add(new Course("Jezyk niemiecki", "Justyna Wysoka", 3));
        courseArrayList.add(new Course("Jezyk francuski", "Justyna Wysoka", 3));
        courseArrayList.add(new Course("Jezyk hiszpanski", "Joanna Fiolek", 3));
        courseArrayList.add(new Course("Przedsiebiorczosc", "Izabela Nowak", 2));
        courseArrayList.add(new Course("Filozofia", "Mariusz Nowak", 2));}

    public void addRecord(Object ob){
        courseArrayList.add((Course) ob);
    }

    public void displayDatabase(){

        for (int i = 0; i < courseArrayList.size(); i++) {

            System.out.println(courseArrayList.get(i));
        }
    }
    public ArrayList<Course> createSchedule(int[] indexArray){

        ArrayList<Course> studentSchedule = new ArrayList<>();

        for (int i = 0; i < indexArray.length; i++) {

            if(indexArray[i] < 0 || indexArray[i] > (courseArrayList.size() - 1))
                System.out.println("Podano zly indeks");

            else
                studentSchedule.add(courseArrayList.get(indexArray[i]));
        }

        return studentSchedule;
    }

    public void searchByName(String regex){

        for (int i = 0; i < courseArrayList.size(); i++) {

            String element = courseArrayList.get(i).getName();

            if(Search.stringSearch(regex, element))
                System.out.println(courseArrayList.get(i));
        }

    }
    public void searchByTeacher(String regex){

        for (int i = 0; i < courseArrayList.size(); i++) {

            String element = courseArrayList.get(i).getTeacher();

            if(Search.stringSearch(regex, element))
                System.out.println(courseArrayList.get(i));
        }
    }

    public void searchByEcts(int ects){

        for (int i = 0; i < courseArrayList.size(); i++) {

            if(courseArrayList.get(i).getEcts() == ects)
                System.out.println(courseArrayList.get(i));
        }
    }


}
