package Pracownicy;

public class PracownikBadDyd extends PracownikUczelni {
    private int publikacje;
    public PracownikBadDyd(String imie, String nazwisko, String pesel, int age, int plec, int stanowisko, int staz, double pensja, int publikacje){
        super(imie, nazwisko, pesel, age, plec, stanowisko, staz, pensja);
        this.publikacje = publikacje;
    }

    public String stanowiskoPracy(){
        switch(stanowisko){
            case 1: return "Asystent";
            case 2: return "Adiunkt";
            case 3: return "Profesor Zwyczajny";
            case 4: return "Profesor Nadzwyczajny";
            case 5: return "Wykladowca";
            default: return "Nieznane stanowisko";
        }
    }


}
