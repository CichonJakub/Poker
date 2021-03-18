import java.util.Scanner;

public class Wymiana {

    private Reka reka;

    private boolean zmiana = false;
    private int czy_zmiana;

    public Wymiana(Reka reka) {
        this.reka = reka;
    }

    public boolean czyChceszWymienic(){                 // interakcja z graczem czy chce wymienic karte, 1 = tak, 2 = nie
        Scanner s = new Scanner(System.in);
        czy_zmiana = s.nextInt();
        if(czy_zmiana == 1){
            zmiana = true;
            System.out.println("zachciało mu się, a przecież ma pokera XD");
        }
        if(czy_zmiana == 2){
            zmiana = false;
            System.out.println("bez zmian zatem :)");
        }
        return  zmiana;
    }

    public void pytanieWymiana(){           // system wymiany w oparciu o odpoweidz z czyChceszWymienic
        for(int i = 0; i < 5; i++){
            System.out.println("Czy chciałbyś wymienić kartę " + (i+1) );
            if(czyChceszWymienic()){
                wymianaKarty(i);
            }
        }
        reka.sortowanieReka();
    }

    public void wymianaKarty(int numer_karty){          // zamienienie wybranej przez gracza karty
        reka.getReka().set(numer_karty, reka.dobranieKarty());
    }
}
