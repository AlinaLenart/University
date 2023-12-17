package Main;

public class Kursy {
    private String nazwa;
    private String prowadzacy;
    private int ects;
    public Kursy(String nazwa, String prowadzacy, int ects){
        this.nazwa = nazwa;
        this.prowadzacy = prowadzacy;
        this.ects = ects;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(String prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }


}
