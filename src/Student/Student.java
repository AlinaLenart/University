package Student;
import java.io.Serializable;
import Person.*;
import java.util.ArrayList;
public class Student extends Person implements Serializable  {
    private static final long serialVersionUID = 4018073578401891246L;
    private int studentID;
    private int year;
    private boolean erasmus;
    private int degree;
    private boolean remote;
    private ArrayList<Course> courseList = new ArrayList<>();
    public Student(String name, String surname, String pesel, int age, char sex,
                   int studentID, int year, boolean erasmus, int degree, boolean remote,
                   ArrayList<Course> courseList){
        super(name, surname, pesel, age, sex);
        this.studentID = studentID;
        this.year = year;
        this.erasmus = erasmus;
        this.degree = degree;
        this.remote = remote;
        this.courseList = courseList;
    }
    public Student(){};

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isErasmus() {
        return erasmus;
    }

    public void setErasmus(boolean erasmus) {
        this.erasmus = erasmus;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student: " +
                "imie='" + getName() + '\'' +
                ", nazwisko='" + getSurname() + '\'' +
                ", pesel='" + getPesel() + '\'' +
                ", wiek=" + getAge() +
                ", plec=" + getSex() +
                ", nr indeksu=" + studentID +
                ", rok=" + year +
                ", erasmus=" + erasmus +
                ", stopien=" + degree +
                ", zdalnie=" + remote +
                ", lista kursow=" + courseList.toString();
    }
}
