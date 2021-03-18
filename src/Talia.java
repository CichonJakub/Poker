import java.util.ArrayList;
import java.util.Collections;


public class Talia {

    private ArrayList<Karta> talia;
    private int nastepna_karta;

    public Talia(){
        this.talia = new ArrayList<Karta>(52);
        nastepna_karta = -1;        // na -1, bo w metodzie wyciagniecieKarty na początku pociągnie 0 i kolejne dzięki nastepna_karta++ tam
        for(int kolor = 1; kolor < 5; kolor++){                 // wypełenienie talii wszystki 52 kartami
            for(int wartosc = 2; wartosc < 15; wartosc++){
                talia.add(new Karta(wartosc,kolor));
            }
        }
    }

    public void pokazTalie() {
        System.out.println("Oto talia: ");  // wyswietla całą talie na ekran
        for(int i = 0; i < 52; i++) {
            System.out.println(talia.get(i));
        }
    }

    public Karta wyciagniecieKarty(){  // metoda na pociągnięcie z talii pierwszej karty
        nastepna_karta++;
        return talia.get(nastepna_karta);        // <- metoda żeby brać karty po kolei z góry z potasowanej talii
    }

    public void tasowanie(){
        for(int i = 0; i < 52; i++){
            Collections.shuffle(talia);
        }
    }
/*
    public static void main(String[] args){
        Talia talia = new Talia();
        talia.pokazTalie();
        System.out.println(" ");
        talia.tasowanie();                      // <- tymczasowy main do testów, żeby sprawdzać działanie metod, oficjalny main całej gry będzie w Rozgrywka
        talia.pokazTalie();
        System.out.println(" ");
        System.out.println(talia.wyciagniecieKarty());
        System.out.println(" ");
    }
*/
}
