package Databases;
import Employees.*;
import Person.*;

import java.util.ArrayList;
import java.io.*;

import Student.*;
import SortingUniversity.*;


public class University implements Database, DatabaseSubject, Serializable {
    private static final long serialVersionUID = 3L;
    private ArrayList<Person> personArrayList = new ArrayList<>();
    private transient ArrayList<DatabaseObserver> observers = new ArrayList<>();
    private UniversityStrategy sortingStrategy;
    public University(){}
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
    public void addRecord(Object ob){

        personArrayList.add((Person) ob);
        DatabaseChangeEvent event = new DatabaseChangeEvent(DatabaseChangeEvent.EventType.ADD, ob);
        notifyObservers(event);
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
                System.out.println(i + " " + personArrayList.get(i));
        }
    }
    public void results(int found){

        if(found <= 0)
            System.out.println("Nie znaleziono");
        else
            System.out.println("Znaleziono "+ found +" wynikow pasujacych do kryteriow");
    }

        public ArrayList<Person> searchByStudentName (String regex){

            ArrayList<Person> studentsNameResult = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++) {

            if (personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);
                String element = st.getName();

                if (Regex.stringSearch(regex, element)) {
                    studentsNameResult.add(personArrayList.get(i));
                }
            }
        }
        return studentsNameResult;
    }

    public ArrayList<Person> searchByEmployeeName(String regex){

        ArrayList<Person> employeeNameResults = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++) {

            if (personArrayList.get(i) instanceof UniversityEmployee) {

                UniversityEmployee emp = (UniversityEmployee) personArrayList.get(i);
                String element = emp.getName();

                if (Regex.stringSearch(regex, element)) {

                    employeeNameResults.add(personArrayList.get(i));
                }
            }
        }
        return employeeNameResults;
    }
    public ArrayList<Person> searchByStudentSurname(String regex){

        ArrayList<Person> studentSurnameResults = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++) {

            if(personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);
                String element = st.getSurname();

                if (Regex.stringSearch(regex, element)) {

                    studentSurnameResults.add(personArrayList.get(i));
                }
            }
        }
        return studentSurnameResults;
    }
    public ArrayList<Person> searchByEmployeeSurname(String regex){

        ArrayList<Person> employeeSurnameResults = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++) {

            if(personArrayList.get(i) instanceof UniversityEmployee) {

                UniversityEmployee emp = (UniversityEmployee) personArrayList.get(i);
                String element = emp.getSurname();

                if (Regex.stringSearch(regex, element)) {

                    employeeSurnameResults.add(personArrayList.get(i));
                }
            }
        }
        return employeeSurnameResults;
    }

    public ArrayList<Person> searchByPositionID(int position){

        ArrayList<Person> employeeIDResults = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++) {

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee emp = (UniversityEmployee) personArrayList.get(i);

                if(emp.getPosition() == position) {

                    employeeIDResults.add(personArrayList.get(i));
                }
            }
        }
        return employeeIDResults;
    }
    public ArrayList<Person> searchByPositionName(String regex){

        ArrayList<Person> employeePositionResults = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                String element = employee.jobPosition();

                if(Regex.stringSearch(regex, element)) {

                    employeePositionResults.add(personArrayList.get(i));

                }
            }
        }
        return employeePositionResults;
    }
    public ArrayList<Person> searchByQuantity(double quantity){

        ArrayList<Person> employeeQuantityResults = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                int converted = (int) quantity;

                if(employee.getWorkExperience() == converted || employee.getSalary() == quantity) {

                    employeeQuantityResults.add(personArrayList.get(i));
                }
                else if(employee instanceof AdministrationEmployee){

                    AdministrationEmployee employee1 = (AdministrationEmployee) employee;

                    if(employee1.getOvertime() == converted) {

                        employeeQuantityResults.add(personArrayList.get(i));
                    }
                }
                else if(employee instanceof ResearchEmployee){

                    ResearchEmployee employee1 = (ResearchEmployee) employee;

                    if(employee1.getReleases() == converted) {

                        employeeQuantityResults.add(personArrayList.get(i));
                    }
                }
            }
        }
       return employeeQuantityResults;
    }
    public ArrayList<Person> searchByWorkExperience(int workExperience){

        ArrayList<Person> employeeWorkExperienceResults = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                if(employee.getWorkExperience() == workExperience) {

                    employeeWorkExperienceResults.add(personArrayList.get(i));
                }
            }
        }
        return employeeWorkExperienceResults;
    }
    public ArrayList<Person> searchBySalary(double salary){

        ArrayList<Person> employeeSalaryResults = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                if(employee.getSalary() == salary) {

                    employeeSalaryResults.add(personArrayList.get(i));
                }
            }
        }
        return employeeSalaryResults;
    }
    public ArrayList<Person> searchByOvertime(int overtime){

        ArrayList<Person> employeeOvertimeResults = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                if(employee instanceof AdministrationEmployee){

                    AdministrationEmployee employee1 = (AdministrationEmployee) employee;

                    if(employee1.getOvertime() == overtime) {

                        employeeOvertimeResults.add(personArrayList.get(i));
                    }
                }
            }
        }
        return employeeOvertimeResults;
    }
    public ArrayList<Person> searchByReleases(int releases){

        ArrayList<Person> employeeByReleaseResults = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                if(employee instanceof ResearchEmployee){

                    ResearchEmployee employee1 = (ResearchEmployee) employee;

                    if(employee1.getReleases() == releases) {

                        employeeByReleaseResults.add(personArrayList.get(i));
                    }
                }
            }
        }
        return employeeByReleaseResults;
    }

    public ArrayList<Person> searchByStudentID(int studentID){

        ArrayList<Person> studentsIDResults = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);

                if(st.getStudentID() == studentID) {

                    studentsIDResults.add(personArrayList.get(i));
                }
            }
        }
        return studentsIDResults;
    }
    public ArrayList<Person> searchByYear(int year){

        ArrayList<Person> studentsYearResults = new ArrayList<Person>();

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);

                if(st.getYear() == year) {

                    studentsYearResults.add(personArrayList.get(i));

                }
            }
        }
        return studentsYearResults;
    }
    public ArrayList<Person> searchByCourseName(String regex){

        ArrayList<Person> studentByCourseResults = new ArrayList<Person>();
        ArrayList<Integer> foundIndexes = new ArrayList<>();

        for (int i = 0; i < personArrayList.size(); i++) {

            if(personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);

                for (int j = 0; j < st.getCourseList().size(); j++) {

                    String element = st.getCourseList().get(j).getName();

                    if (Regex.stringSearch(regex, element)) {

                        studentByCourseResults.add(personArrayList.get(i));
                        foundIndexes.add(i);
                    }
                }
            }
        }
        return studentByCourseResults;
    }
    public void displaySearchRecord(ArrayList<Person> searchResults){

        if (searchResults.isEmpty()){
            System.out.println("Brak wynikow wyszukiwania");
        }
        else {

            for (int i = 0; i < searchResults.size(); i++) {
                System.out.println((i + 1) + ". " + searchResults.get(i));
            }

        }
    }

    public void delRecord(ArrayList<Person> searchResults, int index){

        if (index < 0 || index > searchResults.size()){
            System.out.println("Podano zly indeks, prosze sprobowac ponownie...");
        }
        else personArrayList.remove(searchResults.get(index - 1));
        DatabaseChangeEvent event = new DatabaseChangeEvent(DatabaseChangeEvent.EventType.DELETE, searchResults.get(index - 1));
        notifyObservers(event);
    }


    public void setSortingStrategy(UniversityStrategy sortingStrategy) {

        this.sortingStrategy = sortingStrategy;
    }

    public void sortByChosenStrategy() {

        if(sortingStrategy != null)
           sortingStrategy.sort(personArrayList);

    }


}
