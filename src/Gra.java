import java.io.IOException;
import java.util.Scanner;

public class Gra {
    public static void main (String[]args) throws IOException {
        /// sprawdzanie i rozstrzygniecie ewentualne

       /* Talia t = new Talia();
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


        Wymiana w = new Wymiana(r,t);
        w.pytanieWymiana();
        r.pokazReka();

        Rozgrywka roz = new Rozgrywka();

        System.out.println("Oto wartość twojej ręki wariacie: ");
        System.out.println(roz.getWartosc_reki(r));
    */                                                                 // poprzednie sluzyly do testow

        int dalsza_gra = 0;
        System.out.println("Chcesz grać z komputerem (1) czy z innym graczem (2)???  ");
        Scanner scanner1 = new Scanner( System.in);
        int rodzaj_rozgrywki=scanner1.nextInt();

        int kaska_gracza = 1000;
        int kaska_gracza_2 = kaska_gracza;
        int kaska_przeciwnik = kaska_gracza + 500;

        if(rodzaj_rozgrywki == 2) {
            System.out.println("Wszyscy garzce zaczynają grę z " + kaska_gracza + " $");
        }
        else{
            System.out.println("Zaczynasz grę z " + kaska_gracza + " $");
            System.out.println("Twój przeciwnik ma " + kaska_przeciwnik + " $");
        }

        while(true) {
            if(dalsza_gra == 4){
                System.out.println("Dzięki za wspólną rozgrywkę :)");
                System.exit(0);
            }

            Talia talia = new Talia();
            talia.tasowanie();

            System.out.println("Pobieramy od obu graczy 100 $");

            Reka gracz = new Reka(talia);
            Reka przeciwnik = new Reka(talia);

            Rozgrywka rozgrywka = new Rozgrywka(gracz, przeciwnik);
            Wymiana wymiana = new Wymiana(gracz);
            // Wymiana wymiana1 = new Wymiana(przeciwnik, talia);

            System.out.println("Kolej na pierwszego gracza");
            System.out.println("Kliknij enter aby kontynuować rozgrywkę");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            gracz.sortowanieReka();
            gracz.pokazReka();
            wymiana.pytanieWymiana();

            for (int i = 0; i < 100; i++) {
                System.out.println(" ");
            }

            System.out.println("Kolej na drugiego gracza");
            System.out.println("Kliknij enter aby kontynuować rozgrywkę");
            Scanner scanner_1 = new Scanner(System.in);
            scanner_1.nextLine();

            przeciwnik.sortowanieReka();
            if (rodzaj_rozgrywki == 1) {   /// sztuczna inteligencja
                kaska_gracza = kaska_gracza - 100;
                kaska_przeciwnik = kaska_przeciwnik - 100;
                System.out.println("Karty przeciwnika przed wymianą: ");
                przeciwnik.pokazReka();
                System.out.println("Karty przeciwnika po wmianie: ");
                rozgrywka.wymiana_przeciwnika();

                przeciwnik.pokazReka();

                System.out.println("Reka gracza: ");
                gracz.pokazReka();

                System.out.println("Ręka przeciwnika: ");
                przeciwnik.pokazReka();


                System.out.println("Oto wartość twojej ręki wariacie: ");
                System.out.println(rozgrywka.getWartosc_reki(gracz));

                System.out.println("Oto wartość twojej ręki bossie: ");
                System.out.println(rozgrywka.getWartosc_reki(przeciwnik));

                rozgrywka.roztrzygniecie();
            }

            if (rodzaj_rozgrywki == 2) { // granie gracz vs gracz
                kaska_gracza = kaska_gracza - 100;
                kaska_gracza_2 = kaska_gracza_2 - 100;
                Wymiana wymiana1 = new Wymiana(przeciwnik);
                przeciwnik.sortowanieReka();
                System.out.println("Karty gracza2: ");
                przeciwnik.pokazReka();
                wymiana1.pytanieWymiana();
                przeciwnik.sortowanieReka();

                System.out.println("Reka gracza: ");
                gracz.pokazReka();

                System.out.println("Ręka przeciwnika: ");
                przeciwnik.pokazReka();


                System.out.println("Oto wartość twojej ręki wariacie: ");
                System.out.println(rozgrywka.getWartosc_reki(gracz));

                System.out.println("Oto wartość twojej ręki bossie: ");
                System.out.println(rozgrywka.getWartosc_reki(przeciwnik));

                rozgrywka.roztrzygniecie();

            }

            if(rozgrywka.isCzy_wygral_przeciwnik_GUI() && rodzaj_rozgrywki == 1){
                kaska_przeciwnik = kaska_przeciwnik + 200;
                System.out.println("Stan konta przeciwnika wynosi " + kaska_przeciwnik + " $");
                System.out.println("Stan konta gracza wynosi " + kaska_gracza + " $");
            }
            if(rozgrywka.isCzy_wygral_gracz_GUI()){
                kaska_gracza = kaska_gracza + 200;
                System.out.println("Stan konta przeciwnika wynosi " + kaska_przeciwnik + " $");
                System.out.println("Stan konta gracza wynosi " + kaska_gracza + " $");
            }
            if(rozgrywka.isCzy_wygral_przeciwnik_GUI() && rodzaj_rozgrywki == 2){
                kaska_gracza_2 = kaska_gracza_2 + 200;
                System.out.println("Stan konta drugiego gracza wynosi " + kaska_gracza_2 + " $");
                System.out.println("Stan konta gracza wynosi " + kaska_gracza + " $");
            }
            System.out.println("Czy chcesz grać dalej(3), czy jedank nie (4) ???  ");
            Scanner scanner2 = new Scanner( System.in);
            dalsza_gra = scanner2.nextInt();
        }
    }
}
