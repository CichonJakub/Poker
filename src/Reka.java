import java.util.ArrayList;


public class Reka {


    private ArrayList<Karta> reka;
    private Talia talia;


    public Reka(Talia t) {
        this.talia = t;
        this.reka = new ArrayList<Karta>(5);

        for(int numer_karty = 0; numer_karty < 5; numer_karty++){
            reka.add(talia.wyciagniecieKarty());        // wyciagniecie pieciu karty z talii i ułożenie ich na ręce
        }


    }

    public ArrayList<Karta> getReka() {         // dostęp do ArrayLista reka
        return reka;
    }   // dostęp do ręki

    public void sortowanieReka(){        // metoda sortowania reki przez sortowanie bąbelkowe
        int dlugosc = 5;
        for(int i = 0; i < dlugosc-1; i++){
            for(int j = 0; j <  dlugosc-i-1; j++) {
                if(reka.get(j).get_wartosc() < reka.get(j+1).get_wartosc()) {
                    Karta tmp = reka.get(j);
                    reka.set(j, reka.get(j+1));
                    reka.set(j+1, tmp);
                }
            }
        }
    }

    public Karta dobranieKarty(){         // metoda na wyciagniecie kolejnej karty, potrzebne przy klasie wymiana
       return talia.wyciagniecieKarty();
    }

    public void pokazReka(){        // wyswietlenie reki
        System.out.println("Karty w ręce: ");
        for(int numer_karty = 0; numer_karty < 5; numer_karty++) {
            System.out.println(reka.get(numer_karty));
        }
    }

    public int kolorKartyReka(int numer_karty){
        return reka.get(numer_karty).get_kolor();
    }
                                                            // metody żeby dostać się do info o poszczególnych kartach na rece
    public int wartoscKartyReka(int numer_karty){
        return reka.get(numer_karty).get_wartosc();
    }

  /****  public static void main(String[] args){
        Talia t = new Talia();
        t.tasowanie();
        t.pokazTalie();
        System.out.println(" ");
        Reka r = new Reka(t);
        r.pokazReka();

        System.out.println(" ");
        System.out.println(r.getReka().get(0));
        System.out.println(r.wartoscKartyReka(0));
        System.out.println(r.kolorKartyReka(0));
        r.kolorKartyReka(0);


        System.out.println(" ");
        r.pokazReka();

        System.out.println(" ");
        r.sortowanieReka();
        r.pokazReka();
        Ulozenia u = new Ulozenia(r);
        u.czy_para();
        Wymiana w = new Wymiana(r,t);
        w.pytanieWymiana();
        r.pokazReka();

        // chwilowy test

   ]


*****/
}