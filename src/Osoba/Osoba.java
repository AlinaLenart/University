package Osoba;

public abstract class Osoba {
    private String imie;
    private String nazwisko;
    private String pesel;
    private int wiek;
    private int plec;

    public Osoba(String imie, String nazwisko, String pesel, int wiek, int plec){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.wiek = wiek;
        this.plec = plec;
    }


}
