package Person;

public abstract class Person {
    protected String name;
    protected String surname;
    protected String pesel;
    protected int age;
    protected char sex;

    public Person(String name, String surname, String pesel, int age, char sex){
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.age = age;
        this.sex = Character.toUpperCase(sex);
    }

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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public abstract String toString();


}
