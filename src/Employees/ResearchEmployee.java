package Employees;

import Person.Person;

import java.io.Serializable;
import java.util.Objects;

public class ResearchEmployee extends UniversityEmployee implements Serializable {
    private int releases;

    public ResearchEmployee(String name, String surname, String pesel, int age, String sex,
                            String jobPosition, int workExperience, double salary,
                            int releases){
        super(name, surname, pesel, age, sex, jobPosition, workExperience, salary);
        this.releases = releases;
    }

    @Override
    public String toString() {
        return String.format("%-35s %-20s %-20s %-20s %-10d %-10s %-25s %-15d %-15.2f %-30d",
                "Pracownik Badawczo-Dydaktyczny", getName(), getSurname(), getPesel(), getAge(), getSex(), jobPosition, workExperience, salary, releases);

    }



    public int getReleases() {
        return releases;
    }

}
