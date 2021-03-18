public class Ulozenia {

    private Reka r;


    private boolean czy_para = false;
    private boolean czy_dwie_pary = false;
    private boolean czy_trojka = false;
    private boolean czy_kareta = false;
    private boolean czy_strit = false;
    private boolean czy_kolor = false;
    private boolean czy_poker = false;
    private boolean czy_poker_krol = false;
    private boolean czy_full = false;
    private boolean czy_wysoka_karta = true;


    public Ulozenia(Reka r) {        // <- konstruktor klasy Ulozenia, gdzie przy wywołaniu podajemy konkretną reke

        this.r = r;
   }

    /// 1 najsilniejszy uklad

    public boolean czy_poker_krol(){
        if(czy_kolor() && czy_strit() && r.wartoscKartyReka(0) == 14){ // wartość 14 = AS
            czy_poker_krol = true;
        }
        return czy_poker_krol;
    }

    public boolean czy_poker(){
        if(czy_kolor() && czy_strit()){
            czy_poker = true;
        }
        return czy_poker;

    }

    /// 2 najsilniejszy uklad

    public boolean czy_kareta(){
        int kareta = 0;
        for(int i = 1; i < 6;i++ ) {
            if (r.wartoscKartyReka(2) == r.wartoscKartyReka(i - 1)) {
                kareta++;
            }
        }
        if (kareta == 4) {
            czy_kareta = true;
        }
        return czy_kareta;
    }

    /// 3 najsilneijszy ukłąd

    public boolean czy_full(){
        if(czy_trojka()){
            int para = 0;
            for (int licznik = 1; licznik < 5; licznik++) {
                if (r.wartoscKartyReka(licznik - 1) == r.wartoscKartyReka(licznik)) {
                    para++;
                }
            }
            if (para == 3) {
                czy_full = true;
            }
        }
    return czy_full;
    }

    //4 najsilniejszy układ

    public  boolean czy_kolor(){
        int kolor = 0;
        for(int i = 1; i < 5; i++){
            if(r.kolorKartyReka(i-1) == r.kolorKartyReka(i)){
                kolor++;
            }
            else break;
        }
        if(kolor == 4){
            czy_kolor=true;
        }
        return czy_kolor;
    }

    /// 5 najsilniejszy uklad

    public boolean czy_strit(){
        int strit = 0;
        for(int i = 1; i < 5; i++){
            if(r.wartoscKartyReka(i-1) == r.wartoscKartyReka(i)+1) {
                strit++;
            }
            else break;
        }
        if(strit == 4){
            czy_strit = true;
        }

        return czy_strit;
    }


    /// 6 najsilneijszy układ

    public boolean czy_trojka(){
        int trojka = 0;
        for(int i = 0; i < 5;i++ ) {
            if (r.wartoscKartyReka(2) == r.wartoscKartyReka(i)) {
                trojka++;
            }
        }
        if (trojka == 3) {
            czy_trojka = true;
        }
        return czy_trojka;
    }

    /// 7 najmocniejszy uklad

    public boolean czy_dwie_pary()
    {
        boolean nie_ma_dwóch_par = false;
        if(czy_trojka()){
            nie_ma_dwóch_par = true;
        }

        int para = 0;
        for (int licznik = 1; licznik < 5; licznik++) {
            if (r.wartoscKartyReka(licznik - 1) == r.wartoscKartyReka(licznik)) {
                para++;
            }
        }
        if (para == 2 && !nie_ma_dwóch_par) {
            czy_dwie_pary = true;
        }
        return czy_dwie_pary;

    }



    /// 8 najmocniejszy uklad

    public boolean czy_para()
    {
        int para = 0;
        for (int licznik = 1; licznik < 5; licznik++) {
            if (r.wartoscKartyReka(licznik - 1) == r.wartoscKartyReka(licznik)) {
                para++;
            }
        }

        if (para == 1) {
            czy_para=true;
        }
        return czy_para;
    }

    public boolean czy_wysoka_karta(){
        return czy_wysoka_karta;
    }




















/**** starsze algorytmy na razie nie usuwam:P

    //kolor
    public int czy_kolor(Reka r){
        for (int licznik = 1; licznik < 5; licznik ++){
            if(r.kolorKartyReka(0) != r.kolorKartyReka(licznik)){
                return 0;
            }
            else
                return 1;

        }
        return 0;       // <- to dopisałem, bo się nie kompilowało, nie wiem jeszcze co ma tam zwracać, więc to do zmiany ;)
    }

    //strit
    public int czy_strit(Reka r)  /// tu tez przyda sie reka uszeregowana od najw wartosci do najmniejszej
    {
        for (int licznik = 1; licznik < 5; licznik++)
        {
            if (r.kolorKartyReka(0) != r.kolorKartyReka(licznik))
            {
                return 0;                   // <- tu chyba nie dopiasny kod, dobzre rozumiem ?
            }
        }
        for (int licznik2 = 1; licznik2 < 5; licznik2++)
        {
            if (r.wartoscKartyReka(licznik2 - 1) != (r.wartoscKartyReka(licznik2) - 1))
            {
                return 0;                 // <- tu chyba też dopisać, zobacz odwołania w tym ifie wyżej, bo nie wiem
            }                               // czy dobrze je dopisałem zgodnie z Twoim założeniem

        }
        return 1;

    }

    //dwie pary! uwaga tamten algorytm nei uwzglednia dwoch par

    //!!!!
    //naprawiłem odwołania do listy na Reka
    //stworzyłem też dwie nowe metody w Reka -> wartoscKartyReka, kolorKartyReka, które zwracają kolor i wartosc danej karty na ręce


  ****/



}

