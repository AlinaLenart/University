package Student;
import java.io.Serializable;
import Person.*;
import java.util.ArrayList;
import java.util.Objects;

public class Student extends Person implements Serializable  {
    private static final long serialVersionUID = 4018073578401891246L;
    private int studentID;
    private int year;
    private boolean erasmus;
    private int degree;
    private boolean remote;
    private ArrayList<Course> courseList = new ArrayList<>();

    public Student(String name, String surname, String pesel, int age, String sex,
                   int studentID, int year, int degree,boolean erasmus, boolean remote,
                   ArrayList<Course> courseList){
        super(name, surname, pesel, age, sex);
        this.studentID = studentID;
        this.year = year;
        this.degree = degree;
        this.erasmus = erasmus;
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
        return String.format("%-35s %-20s %-20s %-20s %-5d %-10s %-15d %-15d %-10d %-10b %-10b %s",
                "Student", getName(), getSurname(), getPesel(), getAge(), getSex(), studentID, year, degree, erasmus, remote, displayCourses());

    }

    public String displayCourses(){
        StringBuilder sb = new StringBuilder();
        for(Course c : courseList){
            sb.append(c.getName()).append(" , ").append(c.getTeacher()).append(" , ").append(c.getEcts()).append(" | ");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Student student = (Student) object;
        return studentID == student.studentID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID);
    }

}
