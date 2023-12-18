package Database;
import Student.Course;

import java.util.ArrayList;

public class Courses implements Database{
    ArrayList<Course> courseArrayList = new ArrayList<>();
    public Courses(){}

    public ArrayList<Course> getCourseArrayList() {
        return courseArrayList;
    }

    public void addRecord(Object ob){
        courseArrayList.add((Course) ob);
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
