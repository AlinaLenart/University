package Employees;
import Person.Person;

import java.util.Objects;

public abstract class UniversityEmployee extends Person {
    protected int position;
    protected int workExperience; //in years
    protected double salary;

    public UniversityEmployee(String name, String surname, String pesel, int age, char sex,
                              int position, int workExperience, double salary){
        super(name, surname, pesel, age, sex);
        this.position = position;
        this.workExperience = workExperience;
        this.salary = salary;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract String jobPosition();
    public abstract String toString();

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;

        UniversityEmployee that = (UniversityEmployee) object;
        return getPesel().equals(that.getPesel());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPesel());
    }
}
