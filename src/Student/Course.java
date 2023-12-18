package Student;

public class Course {
    private String name;
    private String teacher;
    private int ects;
    public Course(String name, String teacher, int ects){
        this.name = name;
        this.teacher = teacher;
        this.ects = ects;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    @Override
    public String toString() {
        return "Kurs {" +
                "nazwa='" + name + '\'' +
                ", prowadzacy='" + teacher + '\'' +
                ", ects=" + ects +
                '}';

    }
}
