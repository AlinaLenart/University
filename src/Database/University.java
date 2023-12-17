package Database;
import Employees.AdministrationEmployee;
import Employees.UniversityEmployee;
import Person.Person;
import Student.*;
import java.util.ArrayList;

public class University implements Database{
    private ArrayList<Person> personArrayList = new ArrayList<>();

    public University(){}
    public void addRecord(Object ob){

        personArrayList.add((Person) ob);
    }
    public void displayDatabase(){

        for (int i = 0; i < personArrayList.size(); i++) {
            System.out.println(personArrayList.get(i));
        }
    }
    public void displayRecords(Class<?> displayType){

        for (int i = 0; i < personArrayList.size(); i++) {

            if(displayType.isInstance(personArrayList.get(i)) && (personArrayList.get(i) != null))
                System.out.println(personArrayList.get(i));

        }
    }
    public void searchByName(String regex){
        for (int i = 0; i < personArrayList.size(); i++) {

            String element = personArrayList.get(i).getName();

            if (Search.stringSearch(regex, element))
                System.out.println(personArrayList.get(i));

        }
    }
    public void searchBySurname(String regex){
        for (int i = 0; i < personArrayList.size(); i++) {

            String element = personArrayList.get(i).getSurname();

            if (Search.stringSearch(regex, element))
                System.out.println(personArrayList.get(i));

        }
    }

    public void searchByPositionID(int position){

        for (int i = 0; i < personArrayList.size(); i++) {

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                if(employee.getPosition() == position)
                    System.out.println(personArrayList.get(i));
            }
        }
    }
    public void searchByPositionName(String regex){

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                String element = employee.jobPosition();

                if(Search.stringSearch(regex, element))
                    System.out.println(personArrayList.get(i));
            }
        }
    }
    public void searchByQuantity(double quantity){

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof UniversityEmployee){

                UniversityEmployee employee = (UniversityEmployee) personArrayList.get(i);

                int converted = (int) quantity;

                if(employee.getWorkExperience() == converted || employee.getSalary() == quantity)
                    System.out.println(personArrayList.get(i));

                else if(employee instanceof AdministrationEmployee){

                    AdministrationEmployee employee1 = (AdministrationEmployee) employee;

                    if(employee1.getOvertime() == converted)
                        System.out.println(personArrayList.get(i));
                }
            }
        }
    }
    public void searchByStudentID(int studentID){

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);

                if(st.getStudentID() == studentID)
                    System.out.println(personArrayList.get(i));
            }
        }
    }
    public void searchByYear(int year){

        for (int i = 0; i < personArrayList.size(); i++){

            if(personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);

                if(st.getYear() == year)
                    System.out.println(personArrayList.get(i));
            }
        }
    }
    public void searchByCourseName(String regex){

        for (int i = 0; i < personArrayList.size(); i++) {

            if(personArrayList.get(i) instanceof Student) {

                Student st = (Student) personArrayList.get(i);  //rzutowanie

                for (int j = 0; j < st.getCourseList().size(); j++) {

                    String element = st.getCourseList().get(j).getName();

                    if (Search.stringSearch(regex, element))
                        System.out.println(personArrayList.get(i));

                }
            }
        }
    }


















}
