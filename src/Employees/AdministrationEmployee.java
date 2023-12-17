package Employees;
public class AdministrationEmployee extends UniversityEmployee {
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
            default: return "Nieznane stanowisko";
        }
    }

    @Override
    public String toString() {
        return "AdministrationEmployee{" +
                "overtime=" + overtime +
                ", position=" + jobPosition() +
                ", workExperience=" + workExperience +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }
}
