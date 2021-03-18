public class Karta {

    private int wartosc; // od 0 do 12, J=9, Q=10, K=11, A=12  mamy 13 kart w kolorze
    private int kolor; // 1 karo, 2 kier 3 pik 4 trefl

    public Karta(int wartosc, int kolor) {
        this.wartosc = wartosc;
        this.kolor = kolor;
    }

    public int get_kolor() {
        return kolor;
    }

    public int get_wartosc(){
        return wartosc;
    }

    public String toString(){       // pozwala to na szybkie i ładne wypisywanie na ekran

        String kartaString;

        String[] listaWartosci = { " ", " ","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jopek", "Dama", "Król", "As"};
        String[] listaKolory = {" ", "karo", "kier", "pik", "trefl"};   // <- dodane te puste po to żeby wartości kart się pokrywały w rzeczywostosci i kodzie XD

        kartaString = listaWartosci[wartosc] + " " + listaKolory[kolor];
        return kartaString;
    }
}
