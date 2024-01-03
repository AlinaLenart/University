package Databases;
import Student.Course;

import java.io.*;
import java.util.ArrayList;

public class Courses implements Database, Serializable{
    private static final long serialVersionUID = 2L;
    ArrayList<Course> courseArrayList = new ArrayList<>();
    public Courses(){}

    public ArrayList<Course> getCourseArrayList() {
        return courseArrayList;
    }

    public void addRecord(Object ob){
        courseArrayList.add((Course) ob);
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
                System.out.println("["+ i + "] " + courseArrayList.get(i));
        }
    }
    public ArrayList<Course> createSchedule(int[] indexArray){

        ArrayList<Course> studentSchedule = new ArrayList<>();

        for (int i = 0; i < indexArray.length; i++) {

            if(indexArray[i] < 0 || indexArray[i] > (courseArrayList.size() - 1))
                System.out.println("Podano bledny numer indeksu");

            else
                studentSchedule.add(courseArrayList.get(indexArray[i]));
        }

        return studentSchedule;
    }
    public void results(int found){

        if(found <= 0)
            System.out.println("Nie znaleziono");
        else
            System.out.println("Znaleziono "+ found +" wynikow pasujacych do kryteriow");
    }
    public void searchByName(String regex){

        int found = 0;

        for (int i = 0; i < courseArrayList.size(); i++) {

            String element = courseArrayList.get(i).getName();

            if(Regex.stringSearch(regex, element)) {

                System.out.println(courseArrayList.get(i));
                found++;
            }
        }
        results(found);
    }
    public void searchByTeacher(String regex){

        int found = 0;

        for (int i = 0; i < courseArrayList.size(); i++) {

            String element = courseArrayList.get(i).getTeacher();

            if(Regex.stringSearch(regex, element)) {

                System.out.println(courseArrayList.get(i));
                found++;
            }
        }
        results(found);
    }

    public void searchByEcts(int ects){

        int found = 0;

        for (int i = 0; i < courseArrayList.size(); i++) {

            if(courseArrayList.get(i).getEcts() == ects) {

                System.out.println(courseArrayList.get(i));
                found++;
            }
        }
        results(found);
    }


}