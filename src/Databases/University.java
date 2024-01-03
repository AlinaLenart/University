package Databases;
import Employees.*;
import Person.Person;

import java.util.ArrayList;
import java.io.*;
import Student.Student;

public class University implements Database, Serializable {
    private static final long serialVersionUID = 3L;
    private ArrayList<Person> personArrayList = new ArrayList<>();

    public University(){}
    public void addRecord(Object ob){

        personArrayList.add((Person) ob);
    }
    public void saveDatabaseToFile(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(personArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadDatabaseFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            personArrayList = (ArrayList<Person>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void displayDatabase(Class<?> displayType){

        for (int i = 0; i < personArrayList.size(); i++) {

            if(displayType.isInstance(personArrayList.get(i)) && (personArrayList.get(i) != null))
                System.out.println(personArrayList.get(i));
        }
    }
    public void results(int found){

        if(found <= 0)
            System.out.println("Nie znaleziono");
        else
            System.out.println("Znaleziono "+ found +" wynikow pasujacych do kryteriow");
    }

        public void searchByStudentName (String regex){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++) {

            if (personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);
                String element = st.getName();

                if (Regex.stringSearch(regex, element)) {
                    System.out.println(personArrayList.get(i));
                    found++;
                }
            }
        }
        results(found);
    }

    public void searchByEmployeeName(String regex){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++) {

            if (personArrayList.get(i) instanceof UniversityEmployee) {

                UniversityEmployee emp = (UniversityEmployee) personArrayList.get(i);
                String element = emp.getName();

                if (Regex.stringSearch(regex, element)) {

                    System.out.println(personArrayList.get(i));
                    found++;
                }
            }
        }
        results(found);
    }
    public void searchByStudentSurname(String regex){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++) {

            if(personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);
                String element = st.getSurname();

                if (Regex.stringSearch(regex, element)) {

                    System.out.println(personArrayList.get(i));
                    found++;
                }
            }
        }
        results(found);
    }
    public void searchByEmployeeSurname(String regex){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++) {

            if(personArrayList.get(i) instanceof UniversityEmployee) {

                UniversityEmployee emp = (UniversityEmployee) personArrayList.get(i);
                String element = emp.getSurname();

                if (Regex.stringSearch(regex, element)) {

                    System.out.println(personArrayList.get(i));
                    found++;
                }
            }
        }
        results(found);
    }

    public void searchByPositionID(int position){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++) {

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee emp = (UniversityEmployee) personArrayList.get(i);

                if(emp.getPosition() == position) {

                    System.out.println(personArrayList.get(i));
                    found++;
                }
            }
        }
        results(found);
    }
    public void searchByPositionName(String regex){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                String element = employee.jobPosition();

                if(Regex.stringSearch(regex, element)) {

                    System.out.println(personArrayList.get(i));
                    found++;
                }
            }
        }
        results(found);
    }
    public void searchByQuantity(double quantity){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                int converted = (int) quantity;

                if(employee.getWorkExperience() == converted || employee.getSalary() == quantity) {

                    System.out.println(personArrayList.get(i));
                    found++;
                }
                else if(employee instanceof AdministrationEmployee){

                    AdministrationEmployee employee1 = (AdministrationEmployee) employee;

                    if(employee1.getOvertime() == converted) {

                        System.out.println(personArrayList.get(i));
                        found++;
                    }
                }
                else if(employee instanceof ResearchEmployee){

                    ResearchEmployee employee1 = (ResearchEmployee) employee;

                    if(employee1.getReleases() == converted) {

                        System.out.println(personArrayList.get(i));
                        found++;
                    }
                }
            }
        }
       results(found);
    }
    public void searchByWorkExperience(int workExperience){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                if(employee.getWorkExperience() == workExperience) {

                    System.out.println(personArrayList.get(i));
                    found++;
                }
            }
        }
        results(found);
    }
    public void searchBySalary(double salary){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                if(employee.getSalary() == salary) {

                    System.out.println(personArrayList.get(i));
                    found++;
                }
            }
        }
        results(found);
    }
    public void searchByOvertime(int overtime){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                if(employee instanceof AdministrationEmployee){

                    AdministrationEmployee employee1 = (AdministrationEmployee) employee;

                    if(employee1.getOvertime() == overtime) {

                        System.out.println(personArrayList.get(i));
                        found++;
                    }
                }
            }
        }
        results(found);
    }
    public void searchByReleases(int releases){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                if(employee instanceof ResearchEmployee){

                    ResearchEmployee employee1 = (ResearchEmployee) employee;

                    if(employee1.getReleases() == releases) {

                        System.out.println(personArrayList.get(i));
                        found++;
                    }
                }
            }
        }
        results(found);
    }

    public void searchByStudentID(int studentID){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);

                if(st.getStudentID() == studentID) {

                    System.out.println(personArrayList.get(i));
                    found++;
                }
            }
        }
        results(found);
    }
    public void searchByYear(int year){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);

                if(st.getYear() == year) {

                    System.out.println(personArrayList.get(i));
                    found++;
                }
            }
        }
        results(found);
    }
    public void searchByCourseName(String regex){

        int found = 0;

        for (int i = 0; i < personArrayList.size(); i++) {

            if(personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);

                for (int j = 0; j < st.getCourseList().size(); j++) {

                    String element = st.getCourseList().get(j).getName();

                    if (Regex.stringSearch(regex, element)) {

                        System.out.println(personArrayList.get(i));
                        found++;
                    }
                }
            }
        }
        results(found);

    }


















}