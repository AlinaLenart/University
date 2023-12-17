package Main;
import Osoba.*;
import java.util.ArrayList;
public class Student extends Osoba {
    private int indeks;
    private int rok;
    private ArrayList<Kursy> listaKursow = new ArrayList<>();
    private int opis;
    public Student(String imie, String nazwisko, String pesel, int wiek, int plec, int indeks, int rok, int opis){
        super(imie, nazwisko, pesel, wiek, plec);
        this.indeks = indeks;
        this.rok = rok;
        this.opis = opis;
    }
//    public void dodajKurs(Kursy k){
//        listaKursow.add(k);
//        System.out.println("Dodanie kursu: ");
//    }



}
