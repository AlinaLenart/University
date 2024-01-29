package Employees;

import java.io.Serializable;
import java.util.Objects;

public class AdministrationEmployee extends UniversityEmployee implements Serializable {
    private int overtime; //in hours
    public AdministrationEmployee(String name, String surname, String pesel, int age, String sex,
                                  String jobPosition, int workExperience, double salary,
                                  int overtime){
        super(name, surname, pesel, age, sex, jobPosition, workExperience, salary);
        this.overtime = overtime;
    }


    @Override
    public String toString() {
        return String.format("%-35s %-20s %-20s %-20s %-10d %-10s %-25s %-15d %-15.2f %-30d",
                "Pracownik Administracyjny", getName(), getSurname(), getPesel(), getAge(), getSex(), jobPosition, workExperience, salary, overtime);

    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }


}
