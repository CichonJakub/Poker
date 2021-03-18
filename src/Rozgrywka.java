import java.io.IOException;
import java.util.Scanner;

public class Rozgrywka {

    private Reka reka_gracza;
    private Reka reka_przeciwnika;

    private int wartosc_reki;
    private int wartosc_reki_gracz;
    private int wartosc_reki_przeciwnik;
    private boolean czy_wygral_gracz_GUI = false;
    private boolean czy_wygral_przeciwnik_GUI = false;

    public Rozgrywka( Reka r_g, Reka r_p) {

        this.reka_gracza = r_g;
        this.reka_przeciwnika = r_p;
    }

    public void wymiana_przeciwnika(){ // mozna usunac te nic nie robiace funkcje ale pogladowo na razie zostawiam

        int wartosc_enemy=getWartosc_reki(reka_przeciwnika);
        Wymiana wymiana2 = new Wymiana(reka_przeciwnika);

        if(wartosc_enemy==9){ ////////// poker krolewski ej to jest wg potrzebne myslisz??? bo rownie dobrze mogloby tego nie byc :(
        }

        if(wartosc_enemy==8){ // poker -nic nie robie
        }

        if(wartosc_enemy==7){ // kareta- nic nie robi
        }

        if(wartosc_enemy==6){ // full- nic nie robi
        }

        if(wartosc_enemy==5){ // kolor- nic nie robi
        }

        if(wartosc_enemy==4){ //  strit- nic nie robi
        }

        if(wartosc_enemy==3){ // trojka-wymienia 2 karty nie nalezace do ukladu trojki

            int wartosc_trojki=reka_przeciwnika.wartoscKartyReka(2); // biore sb wartosc srodkowej (zawsze rowna wart ukladu 3)
            for(int i=0; i<5; i++){
                if(reka_przeciwnika.wartoscKartyReka(i)!=wartosc_trojki){
                    wymiana2.wymianaKarty(i);
                }
            }

            reka_przeciwnika.sortowanieReka();

        }

        if(wartosc_enemy==2){ // dwie pary- wymienia jedna karte nie nalezaca do par

            int para_przeciwnika1=0;
            int para_przeciwnika2=0;
            int miejsce_pary_przeciwnika1=0;
            int miejsce_pary_przeciwnika2=0;

            for (int licznik = 1; licznik < 5; licznik++) {
                if (reka_przeciwnika.wartoscKartyReka(licznik - 1) == reka_przeciwnika.wartoscKartyReka(licznik)) {
                    para_przeciwnika1++;
                }
                if(para_przeciwnika1==1){
                    miejsce_pary_przeciwnika1=licznik;
                    break;
                }
            }

            for (int licznik = 1; licznik < 5; licznik++) {
                if (reka_przeciwnika.wartoscKartyReka(licznik - 1) == reka_przeciwnika.wartoscKartyReka(licznik)) {
                    para_przeciwnika2++;
                }
                if(para_przeciwnika2==2){
                    miejsce_pary_przeciwnika2=licznik;
                    break;
                }
            }

            for(int i=0; i<5; i++){
                if(i!=miejsce_pary_przeciwnika1 && i!=miejsce_pary_przeciwnika1-1 && i!=miejsce_pary_przeciwnika2 && i!=miejsce_pary_przeciwnika2-1){
                    wymiana2.wymianaKarty(i);
                }
            }

            reka_przeciwnika.sortowanieReka();
        }

        if(wartosc_enemy==1){ // para-wymienia pozostale poza para
            int para_przeciwnika=0;
            int miejsce_pary_przeciwnika=0;

            for (int licznik = 1; licznik < 5; licznik++) {
                if (reka_przeciwnika.wartoscKartyReka(licznik - 1) == reka_przeciwnika.wartoscKartyReka(licznik)) {
                    para_przeciwnika++;
                }
                if(para_przeciwnika==1){
                    miejsce_pary_przeciwnika=licznik;
                    break;
                }
            }

            for(int i=0; i<5; i++){
                if(i!=miejsce_pary_przeciwnika && i!=miejsce_pary_przeciwnika-1){
                    wymiana2.wymianaKarty(i);
                }
            }

            reka_przeciwnika.sortowanieReka();
        }

        if(wartosc_enemy==0) { // wysoka karta - wymieniam 3 najnizsze
            for (int i = 2; i < 5; i++) {
                wymiana2.wymianaKarty(i);
                wymiana2.wymianaKarty(i);
                wymiana2.wymianaKarty(i);
            }

            reka_przeciwnika.sortowanieReka();
        }

    }


    public int getWartosc_reki(Reka r){

        Ulozenia u = new Ulozenia(r);

        if(u.czy_wysoka_karta()){
            wartosc_reki = 0;
        }
        if(u.czy_para()){           // musi być takie sprawdzanie, ponieważ jak będzie miał lepsze układy to będzie inkrementował sobie wartość_reki
            wartosc_reki = 1;
        }
        if(u.czy_dwie_pary()){      // problem może być w testach jednostkowych bo trojka będzie też czytana jako dwie_pary, ale w grze tak się nie stanie
            wartosc_reki = 2;       // bo jesli trojka to lepsza wartosc wiec dwojki nie da, a da dwie_pary dopiero jak będzie idealnie dwie_pary
        }
        if(u.czy_trojka()){
            wartosc_reki = 3;
        }
        if(u.czy_strit()){
            wartosc_reki = 4;
        }
        if(u.czy_kolor()){
            wartosc_reki = 5;
        }
        if(u.czy_full()){
            wartosc_reki = 6;
        }
        if(u.czy_kareta()){
            wartosc_reki = 7;
        }
        if(u.czy_poker()){
            wartosc_reki = 8;
        }
        if(u.czy_poker_krol()){
            wartosc_reki = 9;
        }

        return wartosc_reki;
    }


    public void wygrywajacyUklad(int wartosc_reki){
        if(wartosc_reki == 0){
            System.out.println("wysoka karta");
        }
        if(wartosc_reki == 1){
            System.out.println("para");
        }
        if(wartosc_reki == 2){
            System.out.println("dwie pary");
        }
        if(wartosc_reki == 3){
            System.out.println("trójka");
        }
        if(wartosc_reki == 4){
            System.out.println("strit");
        }
        if(wartosc_reki == 5){
            System.out.println("kolor");
        }
        if(wartosc_reki == 6){
            System.out.println("full");
        }
        if(wartosc_reki == 7){
            System.out.println("kareta");
        }
        if(wartosc_reki == 8){
            System.out.println("poker");
        }
        if(wartosc_reki == 9){
            System.out.println("poker królewski");
        }
    }




    public void roztrzygniecie() {        // podstawowe porownanie dziala, tylko zastanawiam sie jak zrobic zeby pisalo ze wygrales i co sie mialo

        wartosc_reki_gracz = getWartosc_reki(reka_gracza);
        wartosc_reki_przeciwnik = getWartosc_reki(reka_przeciwnika);

        if (wartosc_reki_gracz == wartosc_reki_przeciwnik) {
            System.out.println("Na razie remisik");

                if(wartosc_reki_gracz==0){  /// przypadek remisu z  najwyzsza karta
                    int i=0;
                    int gracz=0;      // najwyzsza karta gracza
                    int przeciwnik=0;// najwzsza karta przeciwnika
                    while(gracz==przeciwnik) {
                        gracz = reka_gracza.wartoscKartyReka(i);
                        przeciwnik = reka_przeciwnika.wartoscKartyReka(i);
                        if(gracz!=przeciwnik){
                            if(gracz>przeciwnik){
                                System.out.println("Gracz wygrywa bo ma wyzsza karte!");
                                czy_wygral_gracz_GUI = true;

                            }
                            else{
                                System.out.println("Przeciwnik wygrywa bo ma wyższa karte!");
                                czy_wygral_przeciwnik_GUI = true;
                            }
                        }
                        i++;
                    }
                }

                if(wartosc_reki_gracz==1){  // przypadek remisu par, staszny kod ale dziala... jak wymyslisz cos lepszego to pisz :P

                    int para_gracza = 0;
                    int miejsce_pary_gracza=0; // wskazuje nr tej drogiej karty z pary
                    int para_przeciwnika=0;
                    int miejsce_pary_przeciwnika=0;

                    for (int licznik = 1; licznik < 5; licznik++) {
                        if (reka_gracza.wartoscKartyReka(licznik - 1) == reka_gracza.wartoscKartyReka(licznik)) {
                            para_gracza++;
                        }
                        if(para_gracza==1){
                            miejsce_pary_gracza=licznik;
                            break;
                        }
                    }

                    for (int licznik = 1; licznik < 5; licznik++) {
                        if (reka_przeciwnika.wartoscKartyReka(licznik - 1) == reka_przeciwnika.wartoscKartyReka(licznik)) {
                            para_przeciwnika++;
                        }
                        if(para_przeciwnika==1){
                            miejsce_pary_przeciwnika=licznik;
                            break;
                        }
                    }

                    if(reka_gracza.wartoscKartyReka(miejsce_pary_gracza)>reka_przeciwnika.wartoscKartyReka(miejsce_pary_przeciwnika)){
                        System.out.println("Gracz wygrywa, ponieważ ma wyższa pare!");
                        czy_wygral_gracz_GUI = true;
                    }
                    else if(reka_gracza.wartoscKartyReka(miejsce_pary_gracza)<reka_przeciwnika.wartoscKartyReka(miejsce_pary_przeciwnika)){
                        System.out.println("Przeciwnik wygrywa, ponieważ ma wyższa parę!");
                        czy_wygral_przeciwnik_GUI = true;
                    }
                    else{ // ta czesc wchodzi jak oboje maja taka sama pare i decyduje najw karta (w tym te wchodzace w sklad par) mzoemy chyba nagiac zasady
                        int i=0;
                        int gracz=0;      // najwyzsza karta gracza
                        int przeciwnik=0;// najwzsza karta przeciwnika
                        while(gracz==przeciwnik) {
                            gracz = reka_gracza.wartoscKartyReka(i);
                            przeciwnik = reka_przeciwnika.wartoscKartyReka(i);
                            if(gracz!=przeciwnik){
                                if(gracz>przeciwnik){
                                    System.out.println("Gracz wygrywa bo ma wyzsza karte! (para nie rozstrzyga)");
                                    czy_wygral_gracz_GUI = true;
                                }
                                else if(gracz<przeciwnik){
                                    System.out.println("Przeciwnik wygrywa bo ma wyższa karte! (para nie rozstrzyga)");
                                    czy_wygral_przeciwnik_GUI = true;
                                }
                            }
                            i++;
                        }
                    }

                }

                if(wartosc_reki_gracz==2){ // przypadek remisu dwoch par

                    int para_gracza1=0;
                    int para_gracza2=0;
                    int miejsce_pary_gracza1=0; // miejsce 2 karty z wiekszej pary
                    int miejsce_pary_gracza2=0; // miejsce 2 karty z mniejszej pary

                    int para_przeciwnika1=0;
                    int para_przeciwnika2=0;
                    int miejsce_pary_przeciwnika1=0;
                    int miejsce_pary_przeciwnika2=0;

                    // chce miec miejsce wiekszej pary (przez miejsce utworu rozumiem numer miejsca tej drogiej karty z pary
                    // jak mam uklad 10,10,9,9,5 to miejscem1 bedzie 1, a miejscem2 bedzie 3 :P

                    for (int licznik = 1; licznik < 5; licznik++) {
                        if (reka_gracza.wartoscKartyReka(licznik - 1) == reka_gracza.wartoscKartyReka(licznik)) {
                            para_gracza1++;
                        }
                        if(para_gracza1==1){
                            miejsce_pary_gracza1=licznik;
                            break;
                        }
                    }
                    // chce miec meijsce mniejszej pary
                    for (int licznik = 1; licznik < 5; licznik++) {
                        if (reka_gracza.wartoscKartyReka(licznik - 1) == reka_gracza.wartoscKartyReka(licznik)) {
                            para_gracza2++;
                        }
                        if(para_gracza2==2){
                            miejsce_pary_gracza2=licznik;
                            break;
                        }
                    }

                    for (int licznik = 1; licznik < 5; licznik++) {
                        if (reka_przeciwnika.wartoscKartyReka(licznik - 1) == reka_przeciwnika.wartoscKartyReka(licznik)) {
                            para_przeciwnika1++;
                        }
                        if(para_przeciwnika1==1){
                            miejsce_pary_przeciwnika1=licznik;
                            break;
                        }
                    }

                    for (int licznik = 1; licznik < 5; licznik++) {
                        if (reka_przeciwnika.wartoscKartyReka(licznik - 1) == reka_przeciwnika.wartoscKartyReka(licznik)) {
                            para_przeciwnika2++;
                        }
                        if(para_przeciwnika2==2){
                            miejsce_pary_przeciwnika2=licznik;
                            break;
                        }
                    }


                    if(reka_gracza.wartoscKartyReka(miejsce_pary_gracza1)>reka_przeciwnika.wartoscKartyReka(miejsce_pary_przeciwnika1)){
                        System.out.println("Gracz wygrywa, ponieważ ma wyższa pare!");
                        czy_wygral_gracz_GUI = true;
                    }
                    else if(reka_gracza.wartoscKartyReka(miejsce_pary_gracza1)<reka_przeciwnika.wartoscKartyReka(miejsce_pary_przeciwnika1)){
                        System.out.println("Przeciwnik wygrywa, ponieważ ma wyższa pierwszą parę!");
                        czy_wygral_przeciwnik_GUI = true;
                    }
                    else if(reka_gracza.wartoscKartyReka(miejsce_pary_gracza1)==reka_przeciwnika.wartoscKartyReka(miejsce_pary_przeciwnika1)){
                        if(reka_gracza.wartoscKartyReka(miejsce_pary_gracza2)>reka_przeciwnika.wartoscKartyReka(miejsce_pary_przeciwnika2)){
                            System.out.println("Gracz wygrał, ponieważ ma wyższa druga parę!");
                            czy_wygral_gracz_GUI = true;
                        }
                        else if(reka_gracza.wartoscKartyReka(miejsce_pary_gracza2)<reka_przeciwnika.wartoscKartyReka(miejsce_pary_przeciwnika2)){
                            System.out.println("Przeciwnik wygrał, ponieważ ma wyższą druga parę!");
                            czy_wygral_przeciwnik_GUI = true;
                        }
                        else{
                            // ta czesc wchodzi jak oboje maja obie pary takie same i decyduje najw karta (w tym te wchodzace w sklad par) mzoemy chyba nagiac zasady
                                int i=0;
                                int gracz=0;      // najwyzsza karta gracza
                                int przeciwnik=0;// najwzsza karta przeciwnika
                                while(gracz==przeciwnik) {
                                    gracz = reka_gracza.wartoscKartyReka(i);
                                    przeciwnik = reka_przeciwnika.wartoscKartyReka(i);
                                    if (gracz != przeciwnik) {
                                        if (gracz > przeciwnik) {
                                            System.out.println("Gracz wygrywa bo ma wyzsza karte! (żadna z par nie rozstrzyga)");
                                            czy_wygral_gracz_GUI = true;
                                        } else if (gracz < przeciwnik) {
                                            System.out.println("Przeciwnik wygrywa bo ma wyższa karte! (żadna z par nie rozstrzyga)");
                                            czy_wygral_przeciwnik_GUI = true;
                                        }
                                    }
                                    i++;
                                }
                        }

                    }///// mozna doddac jeszcze przypadek ze oboje maja te same obie pary i trzeba bedzie porownywac karte najwyzsza spoza par, ona moze byc na miejscu 0 2 lub 4
                    /// mysle jednak ze to tak marginalny przypadek ze mozemy go pominąć

                }

                if(wartosc_reki_gracz==3){ // przypadek remisu trojki
                    int gracz=0;
                    int przeciwnik=0;

                    gracz=reka_gracza.wartoscKartyReka(2);  ///  dobrze to rozumiem ze srodkowa karta ma wartpsc 2? :)
                    przeciwnik=reka_przeciwnika.wartoscKartyReka(2);

                    if(gracz>przeciwnik){
                        System.out.println("Gracz wygrał, ponieważ ma wyzszy układ trojki ");
                        czy_wygral_gracz_GUI = true;
                    }
                    else if(gracz<przeciwnik){
                        System.out.println("Przeciwnyk wygrał, ponieważ ma wyższy ukłąd trojki ");
                        czy_wygral_przeciwnik_GUI = true;
                    }
                }



                if(wartosc_reki_gracz==4){ // przypadek remisu strita
                    int i=0;
                    int gracz=0;      // najwyzsza karta gracza
                    int przeciwnik=0;// najwzsza karta przeciwnika
                    while(gracz==przeciwnik) {
                        gracz = reka_gracza.wartoscKartyReka(i);
                        przeciwnik = reka_przeciwnika.wartoscKartyReka(i);
                        if(gracz!=przeciwnik){
                            if(gracz>przeciwnik){
                                System.out.println("Gracz wygrywa bo ma wyzsza karte w stricie!");
                                czy_wygral_gracz_GUI = true;
                            }
                            else if(gracz<przeciwnik){
                                System.out.println("Przeciwnik wygrywa bo ma wyższa karte w stricie!");
                                czy_wygral_przeciwnik_GUI = true;
                            }
                        }
                        i++;
                    }
                }

                if(wartosc_reki_gracz==5){ // przyapdek remisu koloru
                    int i=0;
                    int gracz=0;      // najwyzsza karta gracza
                    int przeciwnik=0;// najwzsza karta przeciwnika
                    while(gracz==przeciwnik) {
                        gracz = reka_gracza.wartoscKartyReka(i);
                        przeciwnik = reka_przeciwnika.wartoscKartyReka(i);
                        if(gracz!=przeciwnik){
                            if(gracz>przeciwnik){
                                System.out.println("Gracz wygrywa bo ma wyzsza karte w kolorze!");
                                czy_wygral_gracz_GUI = true;
                            }
                            else if(gracz<przeciwnik){
                                System.out.println("Przeciwnik wygrywa bo ma wyższa kartew kolorze!");
                                czy_wygral_przeciwnik_GUI = true;
                            }
                        }
                        i++;
                    }

                }

                if(wartosc_reki_gracz==6){ // przypadek remisu fulla
                    int gracz=0;
                    int przeciwnik=0;

                    gracz=reka_gracza.wartoscKartyReka(2);  ///  dobrze to rozumiem ze srodkowa karta ma wartpsc 2? :)
                    przeciwnik=reka_przeciwnika.wartoscKartyReka(2);

                    if(gracz>przeciwnik){
                        System.out.println("Gracz wygrał, ponieważ ma wyzszy układ full-u ");
                        czy_wygral_gracz_GUI = true;
                    }
                    else if(gracz<przeciwnik){
                        System.out.println("Przeciwnyk wygrał, ponieważ ma wyższy ukłąd full-u ");
                        czy_wygral_przeciwnik_GUI = true;
                    }
                }

                if(wartosc_reki_gracz==7){ // prypadek remisu karety
                    int gracz=0;
                    int przeciwnik=0;

                    gracz=reka_gracza.wartoscKartyReka(2);  ///  dobrze to rozumiem ze srodkowa karta ma wartpsc 2? :)
                    przeciwnik=reka_przeciwnika.wartoscKartyReka(2);

                    if(gracz>przeciwnik){
                        System.out.println("Gracz wygrał, ponieważ ma wyzszy układz karety ");
                        czy_wygral_gracz_GUI = true;
                    }
                    else if(gracz<przeciwnik){
                        System.out.println("Przeciwnyk wygrał, ponieważ ma wyższy ukłąd karety ");
                        czy_wygral_przeciwnik_GUI = true;
                    }
                }

                if(wartosc_reki_gracz==8){ // przyapdek remisu pokera
                    int i=0;
                    int gracz=0;      // najwyzsza karta gracza
                    int przeciwnik=0;// najwzsza karta przeciwnika
                    while(gracz==przeciwnik) {
                        gracz = reka_gracza.wartoscKartyReka(i);
                        przeciwnik = reka_przeciwnika.wartoscKartyReka(i);
                        if(gracz!=przeciwnik){
                            if(gracz>przeciwnik){
                                System.out.println("Gracz wygrywa bo ma wyzsza karte w pokerze!");
                                czy_wygral_gracz_GUI = true;
                            }
                            else if(gracz<przeciwnik){
                                System.out.println("Przeciwnik wygrywa bo ma wyższa karte w pokerze!");
                                czy_wygral_przeciwnik_GUI = true;
                            }
                        }
                        i++;
                    }

                }

                if(wartosc_reki_gracz==9){ // przyapdek remisu pokera krolewskiego

                }



            // dopisanie warunku na sprawdzanie przypadku takiego samego ulozenia, pewnie najwyzsza karta lub lepszy uklad danego ukladu na przyklad lepszy full
        }

        if (wartosc_reki_gracz > wartosc_reki_przeciwnik) {
            System.out.println("Wygrałeś koleżko");
            czy_wygral_gracz_GUI = true;
            for (int i = 9; i > -1; i--) {
                if (wartosc_reki_gracz == i) {
                    System.out.println("Wygrywający układ to ");
                    wygrywajacyUklad(wartosc_reki_gracz);
                    break;
                }
            }
        }
        if (wartosc_reki_gracz < wartosc_reki_przeciwnik) {
            System.out.println("Graczu pierwszy, no niestety przegrałeś :P, wygrał Twój przeciwnik !");
            czy_wygral_przeciwnik_GUI = true;
            for (int i = 9; i > -1; i--) {
                if (wartosc_reki_przeciwnik == i) {
                    System.out.println("Wygrywający układ to ");
                    wygrywajacyUklad(wartosc_reki_przeciwnik);
                    break;
                }
            }
        }
    }

    public boolean isCzy_wygral_gracz_GUI() {
        return czy_wygral_gracz_GUI;
    }

    public boolean isCzy_wygral_przeciwnik_GUI() {
        return czy_wygral_przeciwnik_GUI;
    }
}