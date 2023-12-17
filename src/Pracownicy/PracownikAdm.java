package Pracownicy;
public class PracownikAdm extends PracownikUczelni {
    private int nadgodziny;
    public PracownikAdm(String imie, String nazwisko, String pesel, int wiek, int plec, int stanowisko, int staz, double pensja, int nadgodziny){
        super(imie, nazwisko, pesel, wiek, plec, stanowisko, staz, pensja);
        this.nadgodziny = nadgodziny;
    }
    public String stanowiskoPracy(){
        switch(stanowisko){
            case 1: return "Referent";
            case 2: return "Specjalista";
            case 3: return "Starszy Specjalista";
            case 4: return "Nadzorujacy Badania";
            default: return "Nieznane stanowisko";
        }
    }


}
