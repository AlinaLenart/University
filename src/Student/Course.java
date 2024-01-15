package Student;

import java.io.Serializable;
import java.util.Objects;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return name.equalsIgnoreCase(course.name) && teacher.equalsIgnoreCase(course.teacher);
    }

    public int hashCode() {
        return Objects.hash(name, teacher);
    }
}
