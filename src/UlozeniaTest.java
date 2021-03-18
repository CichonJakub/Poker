import org.junit.Assert;

// testy jednostkowe na ułożenia
public class UlozeniaTest {

    @org.junit.Test
    public void czy_poker_krol() {
        Talia t = new Talia();                                      // podajemy talie
        Reka r = new Reka(t);                                       // podajemy reke
        r.getReka().set(0, new Karta(14,2));          // ustawiamy sobie wartosci jakie chcemy :)
        r.getReka().set(1, new Karta(13,2));
        r.getReka().set(2, new Karta(12,2));
        r.getReka().set(3, new Karta(11,2));
        r.getReka().set(4, new Karta(10,2));
        Ulozenia u = new Ulozenia(r);                               // powołujemy ulozenia
        Assert.assertEquals(true, u.czy_poker_krol());     // testowanie
    }

    @org.junit.Test
    public void czy_poker() {
        Talia t = new Talia();                                      // podajemy talie
        Reka r = new Reka(t);                                       // podajemy reke
        r.getReka().set(0, new Karta(12,2));          // ustawiamy sobie wartosci jakie chcemy :)
        r.getReka().set(1, new Karta(11,2));
        r.getReka().set(2, new Karta(10,2));
        r.getReka().set(3, new Karta(9,2));
        r.getReka().set(4, new Karta(8,2));
        Ulozenia u = new Ulozenia(r);                               // powołujemy ulozenia
        Assert.assertEquals(true, u.czy_poker());     // testowanie
    }

    @org.junit.Test
    public void czy_kareta() {
        Talia t = new Talia();                                      // podajemy talie
        Reka r = new Reka(t);                                       // podajemy reke
        r.getReka().set(0, new Karta(14,2));          // ustawiamy sobie wartosci jakie chcemy :)
        r.getReka().set(1, new Karta(14,1));
        r.getReka().set(2, new Karta(14,3));
        r.getReka().set(3, new Karta(14,4));
        r.getReka().set(4, new Karta(10,2));
        Ulozenia u = new Ulozenia(r);                               // powołujemy ulozenia
        Assert.assertEquals(true, u.czy_kareta());     // testowanie
    }

    @org.junit.Test
    public void czy_full() {
        Talia t = new Talia();                                      // podajemy talie
        Reka r = new Reka(t);                                       // podajemy reke
        r.getReka().set(0, new Karta(14,1));          // ustawiamy sobie wartosci jakie chcemy :)
        r.getReka().set(1, new Karta(14,2));
        r.getReka().set(2, new Karta(14,3));
        r.getReka().set(3, new Karta(10,1));
        r.getReka().set(4, new Karta(10,2));
        Ulozenia u = new Ulozenia(r);                               // powołujemy ulozenia
        Assert.assertEquals(true, u.czy_full());     // testowanie
    }

    @org.junit.Test
    public void czy_kolor() {
        Talia t = new Talia();                                      // podajemy talie
        Reka r = new Reka(t);                                       // podajemy reke
        r.getReka().set(0, new Karta(14,2));          // ustawiamy sobie wartosci jakie chcemy :)
        r.getReka().set(1, new Karta(13,2));
        r.getReka().set(2, new Karta(12,2));
        r.getReka().set(3, new Karta(11,2));
        r.getReka().set(4, new Karta(10,2));
        Ulozenia u = new Ulozenia(r);                               // powołujemy ulozenia
        Assert.assertEquals(true, u.czy_kolor());     // testowanie
    }

    @org.junit.Test
    public void czy_strit() {
        Talia t = new Talia();                                      // podajemy talie
        Reka r = new Reka(t);                                       // podajemy reke
        r.getReka().set(0, new Karta(14,2));          // ustawiamy sobie wartosci jakie chcemy :)
        r.getReka().set(1, new Karta(13,2));
        r.getReka().set(2, new Karta(12,2));
        r.getReka().set(3, new Karta(11,2));
        r.getReka().set(4, new Karta(10,2));
        Ulozenia u = new Ulozenia(r);                               // powołujemy ulozenia
        Assert.assertEquals(true, u.czy_strit());     // testowanie
    }

    @org.junit.Test
    public void czy_trojka() {
        Talia t = new Talia();                                      // podajemy talie
        Reka r = new Reka(t);                                       // podajemy reke
        r.getReka().set(0, new Karta(14,2));          // ustawiamy sobie wartosci jakie chcemy :)
        r.getReka().set(1, new Karta(13,2));
        r.getReka().set(2, new Karta(10,3));
        r.getReka().set(3, new Karta(10,1));
        r.getReka().set(4, new Karta(10,2));
        Ulozenia u = new Ulozenia(r);                               // powołujemy ulozenia
        Assert.assertEquals(true, u.czy_trojka());     // testowanie
    }

    @org.junit.Test
    public void czy_dwie_pary() {
        Talia t = new Talia();                                      // podajemy talie
        Reka r = new Reka(t);                                       // podajemy reke
        r.getReka().set(0, new Karta(12,2));          // ustawiamy sobie wartosci jakie chcemy :)
        r.getReka().set(1, new Karta(12,3));
        r.getReka().set(2, new Karta(12,1));
        r.getReka().set(3, new Karta(11,1));
        r.getReka().set(4, new Karta(10,2));
        Ulozenia u = new Ulozenia(r);                               // powołujemy ulozenia
        Assert.assertEquals(false, u.czy_dwie_pary());     // testowanie
    }

    @org.junit.Test
    public void czy_para() {
        Talia t = new Talia();                                      // podajemy talie
        Reka r = new Reka(t);                                       // podajemy reke
        r.getReka().set(0, new Karta(14,2));          // ustawiamy sobie wartosci jakie chcemy :)
        r.getReka().set(1, new Karta(13,2));
        r.getReka().set(2, new Karta(12,2));
        r.getReka().set(3, new Karta(10,1));
        r.getReka().set(4, new Karta(10,2));
        Ulozenia u = new Ulozenia(r);                               // powołujemy ulozenia
        Assert.assertEquals(true, u.czy_para());     // testowanie
    }
}