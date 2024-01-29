package Employees;
import Person.Person;

import java.util.Objects;

public abstract class UniversityEmployee extends Person {
    protected String jobPosition;
    protected int workExperience; //in years
    protected double salary;

    public UniversityEmployee(String name, String surname, String pesel, int age, String sex,
                              String jobPosition, int workExperience, double salary){
        super(name, surname, pesel, age, sex);
        this.jobPosition = jobPosition;
        this.workExperience = workExperience;
        this.salary = salary;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
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


    public abstract String toString();

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        UniversityEmployee that = (UniversityEmployee) object;
        return getPesel().equals(that.getPesel());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPesel());
    }

}
