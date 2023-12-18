package Employees;

import Person.Person;

public class ResearchEmployee extends UniversityEmployee {
    private int releases;

    public ResearchEmployee(String name, String surname, String pesel, int age, char sex,
                            int position, int workExperience, double pensja,
                            int releases){
        super(name, surname, pesel, age, sex, position, workExperience, pensja);
        this.releases = releases;
    }

    @Override
    public String toString() {
        return "Pracownik Badawczo-Dydaktyczny : " +
                "imie='" + name + '\'' +
                ", nazwisko='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", wiek=" + age +
                ", plec=" + sex +
                ", stanowisko='" + jobPosition() + '\'' +
                ", staz pracy=" + workExperience +
                ", pensja=" + salary +
                ", publikacje=" + releases;

    }

    public String jobPosition(){
        switch(position){
            case 1: return "Asystent";
            case 2: return "Adiunkt";
            case 3: return "Profesor Zwyczajny";
            case 4: return "Profesor Nadzwyczajny";
            case 5: return "Wykladowca";
            default: return "Nieznane stanowisko";
        }
    }

    public int getReleases() {
        return releases;
    }
}
