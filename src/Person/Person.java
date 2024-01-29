package Person;
import java.io.Serializable;
import java.util.Objects;

public abstract class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private String pesel;
    private int age;
    private String sex;

    public Person(String name, String surname, String pesel, int age, String sex){
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.age = age;
        this.sex = sex;
    }
    public Person(){};
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public abstract String toString();

    public abstract boolean equals(Object o);
    public abstract int hashCode();
}
