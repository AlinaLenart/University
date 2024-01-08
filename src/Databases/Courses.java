package Databases;

import Comparators.*;
import Person.Person;
import Student.Course;
import SortingCourses.*;
import Student.*;
import java.io.*;
import java.util.ArrayList;


public class Courses implements Database, DatabaseSubject,Serializable{
    private static final long serialVersionUID = 2L;
    ArrayList<Course> courseArrayList = new ArrayList<>();
    private transient ArrayList<DatabaseObserver> observers = new ArrayList<>();
    private CoursesStrategy sortingStrategy;

    public Courses(){}
    @Override
    public void attach(DatabaseObserver observer){
        if (!observers.contains(observer))
            observers.add(observer);
    }
    @Override
    public void detach(DatabaseObserver observer){
        observers.remove(observer);
    }
    @Override
    public void notifyObservers(DatabaseChangeEvent event){
        for (DatabaseObserver observer : observers){
            observer.update(event);
        }
    }
    public ArrayList<Course> getCourseArrayList() {
        return courseArrayList;
    }

    public void addRecord(Object ob){
        courseArrayList.add((Course) ob);
        DatabaseChangeEvent event = new DatabaseChangeEvent(DatabaseChangeEvent.EventType.ADD, ob);
        notifyObservers(event);
    }


    public void saveDatabaseToFile(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(courseArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadDatabaseFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            courseArrayList = (ArrayList<Course>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void displayDatabase(Class<?> displayType){

        for (int i = 0; i < courseArrayList.size(); i++) {

            if(displayType.isInstance(courseArrayList.get(i)) && (courseArrayList.get(i) != null))
                System.out.println("["+ (i + 1) + "] " + courseArrayList.get(i));
        }
    }
    public ArrayList<Course> createSchedule(int[] indexArray){

        ArrayList<Course> studentSchedule = new ArrayList<>();

        for (int i = 0; i < indexArray.length; i++) {
            int index = indexArray[i];

            if(index <= courseArrayList.size() && index > 0 && !(studentSchedule.contains(courseArrayList.get(index - 1)))) {
                studentSchedule.add(courseArrayList.get(index - 1));
            }

        }

        return studentSchedule;
    }
    public void results(int found){

        if(found <= 0)
            System.out.println("Nie znaleziono");
        else
            System.out.println("Znaleziono "+ found +" wynikow pasujacych do kryteriow");
    }
    public ArrayList<Course>  searchByName(String regex){

        ArrayList<Course> courseNameResults = new ArrayList<Course>();

        for (int i = 0; i < courseArrayList.size(); i++) {

            String element = courseArrayList.get(i).getName();

            if(Regex.stringSearch(regex, element)) {

                courseNameResults.add(courseArrayList.get(i));
            }
        }
        return courseNameResults;
    }
    public ArrayList<Course>  searchByTeacher(String regex){

        ArrayList<Course> courseTeacherResults = new ArrayList<Course>();

        for (int i = 0; i < courseArrayList.size(); i++) {

            String element = courseArrayList.get(i).getTeacher();

            if(Regex.stringSearch(regex, element)) {

                courseTeacherResults.add(courseArrayList.get(i));

            }
        }
        return courseTeacherResults;
    }

    public ArrayList<Course>  searchByEcts(int ects){

        ArrayList<Course> courseEctsResults = new ArrayList<Course>();

        for (int i = 0; i < courseArrayList.size(); i++) {

            if(courseArrayList.get(i).getEcts() == ects) {

                courseEctsResults.add(courseArrayList.get(i));
            }
        }
        return  courseEctsResults;
    }
    public void displaySearchRecord(ArrayList<Course> searchResults){

        if (searchResults.isEmpty()){
            System.out.println("Brak wynikow wyszukiwania");
        }
        else {

            for (int i = 0; i < searchResults.size(); i++) {
                System.out.println((i + 1) + ". " + searchResults.get(i));
            }

        }
    }

    public void delRecord(ArrayList<Course> searchResults, int index){

        //TODO notifications
        if (index < 0 || index > searchResults.size()){
            System.out.println("Podano zly indeks, prosze sprobowac ponownie...");
        }

        else courseArrayList.remove(searchResults.get(index - 1));
        DatabaseChangeEvent event = new DatabaseChangeEvent(DatabaseChangeEvent.EventType.DELETE, searchResults.get(index - 1));
        notifyObservers(event);
    }

    public void setSortingStrategy(CoursesStrategy sortingStrategy) {

        this.sortingStrategy = sortingStrategy;
    }

    public void sortByChosenStrategy() {

        if(sortingStrategy != null)
            sortingStrategy.sort(courseArrayList);

    }



}
    //TODO deleting specified objects from courses like in university
