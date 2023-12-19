package Employees;

import java.io.Serializable;

public class AdministrationEmployee extends UniversityEmployee implements Serializable {
    private int overtime; //in hours
    public AdministrationEmployee(String name, String surname, String pesel, int age, char sex,
                                  int position, int workExperience, double salary,
                                  int overtime){
        super(name, surname, pesel, age, sex, position, workExperience, salary);
        this.overtime = overtime;
    }
    public String jobPosition(){
        switch(position){
            case 1: return "Referent";
            case 2: return "Specjalista";
            case 3: return "Starszy Specjalista";
            case 4: return "Nadzorujacy Badania";
            case 5: return "Prezes Zarzadu";
            default: return "Nieznane stanowisko";
        }
    }

    @Override
    public String toString() {
        return "Pracownik Administracyjny : " +
                "imie='" + getName() + '\'' +
                ", nazwisko='" + getSurname() + '\'' +
                ", pesel='" + getPesel() + '\'' +
                ", wiek=" + getAge() +
                ", plec=" + getSex() +
                ", stanowisko='" + jobPosition() + '\'' +
                ", staz pracy=" + workExperience +
                ", pensja=" + salary +
                ", nadgodziny=" + overtime;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }
}
