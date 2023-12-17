package Pracownicy;
import Osoba.*;
public abstract class PracownikUczelni extends Osoba {
    protected int stanowisko;
    protected int staz;
    protected double pensja;

    public PracownikUczelni(String imie, String nazwisko, String pesel, int wiek, int plec, int stanowisko, int staz, double pensja){
        super(imie, nazwisko, pesel, wiek, plec);
        this.stanowisko = stanowisko;
        this.staz = staz;
        this.pensja = pensja;
    }

    public abstract String stanowiskoPracy();



}
