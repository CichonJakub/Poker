import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;



public class RozgrywkaGUI extends JFrame{
    private JPanel panel1;
    private JLabel karta1;
    private JLabel karta2;
    private JLabel karta3;
    private JLabel karta4;
    private JLabel karta5;
    private JButton wymiana_karta1;
    private JButton zostaw_karta1;
    private JButton wymiana_karta2;
    private JButton zostaw_karta2;
    private JButton wymiana_karta3;
    private JButton zostaw_karta3;
    private JButton wymiana_karta4;
    private JButton zostaw_karta4;
    private JButton wymiana_karta5;
    private JButton zostaw_karta5;
    private JButton koniecWymiany;
    private JButton sprawdzenie;
    private JButton nowaRozgrywka;
    private JLabel karta1_przeciwnik;
    private JLabel karta2_przeciwnik;
    private JLabel karta3_przeciwnik;
    private JLabel karta4_przeciwnik;
    private JLabel karta5_przeciwnik;
    private JButton koniec;
    private JTextField kaska_przeciwnika_1;
    private JTextField kaska_gracza_1;

    private Karta karta;
    private Reka reka_gracz;
    private Reka reka_przeciwnik;
    private int kolejna_partia = 1;

    private int kaska_gracza_GUI;
    private int kaska_przeciwnik_GUI;

    private Icon wierzch = new javax.swing.ImageIcon(getClass().getResource("1.jpg"));
    private boolean czy_mozna_sprawdzic;
    private String[] uklad_zwyciezcy = {"wysoka karta", "para", "dwie pary", "trójka", "strit", "kolor", "full", "kareta", "poker", "poker królewski"};


    public String karta_z_reki(Reka reka, int numer_karty){

        String kartaString;
        karta = reka.getReka().get(numer_karty);

        String[] listaWartosci = { " ", " ","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jopek", "Dama", "Król", "As"};
        String[] listaKolory = {" ", "karo", "kier", "pik", "trefl"};   // <- dodane te puste po to żeby wartości kart się pokrywały w rzeczywostosci i kodzie XD

        kartaString = listaWartosci[karta.get_wartosc()] + " " + listaKolory[karta.get_kolor()];

        return kartaString;
    }

    public RozgrywkaGUI(Reka r_g, Reka r_p, int kaska_gracza, int kaska_przeciwnika, JFrame frame) {
            reka_gracz = r_g;
            reka_przeciwnik = r_p;
            kaska_przeciwnik_GUI = kaska_przeciwnika;
            kaska_gracza_GUI = kaska_gracza;

            kaska_przeciwnika_1.setText(kaska_przeciwnik_GUI + " $");
            kaska_gracza_1.setText(kaska_gracza_GUI + " $");

            JOptionPane.showMessageDialog(null, "Pobieramy z kont po 100 $");
            kaska_przeciwnik_GUI = kaska_przeciwnik_GUI - 100;
            kaska_gracza_GUI = kaska_gracza_GUI - 100;
            kaska_przeciwnika_1.setText(kaska_przeciwnik_GUI + " $");
            kaska_gracza_1.setText(kaska_gracza_GUI + " $");

            karta1.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    super.componentResized(e);
                    karta1.setText(karta_z_reki(reka_gracz, 0));
                }
            });
            karta2.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    super.componentResized(e);
                    karta2.setText(karta_z_reki(reka_gracz, 1));
                }
            });
            karta3.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    super.componentResized(e);
                    karta3.setText(karta_z_reki(reka_gracz, 2));
                }
            });
            karta4.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    super.componentResized(e);
                    karta4.setText(karta_z_reki(reka_gracz, 3));
                }
            });
            karta5.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    super.componentResized(e);
                    karta5.setText(karta_z_reki(reka_gracz, 4));
                }
            });
            koniecWymiany.addActionListener(new ActionListener() {      // przyciski służące do wymiany lub zostawienie z koncowym koniecWymiany
                @Override
                public void actionPerformed(ActionEvent e) {
                    czy_mozna_sprawdzic = true;

                    wymiana_karta1.setVisible(false);       // zamkniecie ewentualnie nie wcisnietych przcisków aby zapobiec ponownemu wymienieniu
                    zostaw_karta1.setVisible(false);
                    wymiana_karta2.setVisible(false);
                    zostaw_karta2.setVisible(false);
                    wymiana_karta3.setVisible(false);
                    zostaw_karta3.setVisible(false);
                    wymiana_karta4.setVisible(false);
                    zostaw_karta4.setVisible(false);
                    wymiana_karta5.setVisible(false);
                    zostaw_karta5.setVisible(false);

                    reka_gracz.sortowanieReka();        // pokazanie nowej reki
                    karta1.setText(karta_z_reki(reka_gracz, 0));
                    karta2.setText(karta_z_reki(reka_gracz, 1));
                    karta3.setText(karta_z_reki(reka_gracz, 2));
                    karta4.setText(karta_z_reki(reka_gracz, 3));
                    karta5.setText(karta_z_reki(reka_gracz, 4));
                }
            });
            wymiana_karta1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    karta1.setText("Wymieniono");
                    reka_gracz.getReka().set(0, reka_gracz.dobranieKarty());
                    wymiana_karta1.setVisible(false);
                    zostaw_karta1.setVisible(false);
                }
            });
            wymiana_karta2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    karta2.setText("Wymieniono");
                    reka_gracz.getReka().set(1, reka_gracz.dobranieKarty());
                    wymiana_karta2.setVisible(false);
                    zostaw_karta2.setVisible(false);
                }
            });
            wymiana_karta3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    karta3.setText("Wymieniono");
                    reka_gracz.getReka().set(2, reka_gracz.dobranieKarty());
                    wymiana_karta3.setVisible(false);
                    zostaw_karta3.setVisible(false);
                }
            });
            wymiana_karta4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    karta4.setText("Wymieniono");
                    reka_gracz.getReka().set(3, reka_gracz.dobranieKarty());
                    wymiana_karta4.setVisible(false);
                    zostaw_karta4.setVisible(false);
                }
            });
            wymiana_karta5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    karta5.setText("Wymieniono");
                    reka_gracz.getReka().set(4, reka_gracz.dobranieKarty());
                    wymiana_karta5.setVisible(false);
                    zostaw_karta5.setVisible(false);
                }
            });
            zostaw_karta1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    wymiana_karta1.setVisible(false);
                    zostaw_karta1.setVisible(false);
                }
            });
            zostaw_karta2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    wymiana_karta2.setVisible(false);
                    zostaw_karta2.setVisible(false);
                }
            });
            zostaw_karta3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    wymiana_karta3.setVisible(false);
                    zostaw_karta3.setVisible(false);
                }
            });
            zostaw_karta4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    wymiana_karta4.setVisible(false);
                    zostaw_karta4.setVisible(false);
                }
            });
            zostaw_karta5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    wymiana_karta5.setVisible(false);
                    zostaw_karta5.setVisible(false);
                }
            });
            nowaRozgrywka.addActionListener(new ActionListener() {  // nowe rozdanie, ktore jeszcze nie dziala do konca poprawnie
                @Override
                public void actionPerformed(ActionEvent e) {
                    czy_mozna_sprawdzic = false;

                    frame.setVisible(false);
                    frame.dispose();
                    JOptionPane.showMessageDialog(null, " Nowa partia za 3... 2... 1... no weź kliknik ok ! :P");

                    Talia talia = new Talia();
                    talia.tasowanie();
                    talia.tasowanie();
                    Reka reka_gracz = new Reka(talia);
                    reka_gracz.sortowanieReka();

                    Reka reka_przeciwnik = new Reka(talia);
                    reka_przeciwnik.sortowanieReka();

                    JFrame frame = new JFrame("Poker");
                    frame.setContentPane(new RozgrywkaGUI(reka_gracz, reka_przeciwnik, kaska_gracza_GUI, kaska_przeciwnik_GUI, frame).panel1);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Let's go boys :*");
                }
            });
            sprawdzenie.addActionListener(new ActionListener() {    //porownanie, minus taki ze wypisuje na konsoli
                @Override
                public void actionPerformed(ActionEvent e) {
                    // pokazanie kart przeciwnika czy nie kantuje przy sprawdzaniu
                    if (czy_mozna_sprawdzic) {
                        Rozgrywka r = new Rozgrywka(reka_gracz, reka_przeciwnik);
                        r.wymiana_przeciwnika();
                        karta1_przeciwnik.setText(karta_z_reki(reka_przeciwnik, 0));
                        karta1_przeciwnik.setIcon(wierzch);
                        karta2_przeciwnik.setText(karta_z_reki(reka_przeciwnik, 1));
                        karta2_przeciwnik.setIcon(wierzch);
                        karta3_przeciwnik.setText(karta_z_reki(reka_przeciwnik, 2));
                        karta3_przeciwnik.setIcon(wierzch);
                        karta4_przeciwnik.setText(karta_z_reki(reka_przeciwnik, 3));
                        karta4_przeciwnik.setIcon(wierzch);
                        karta5_przeciwnik.setText(karta_z_reki(reka_przeciwnik, 4));
                        karta5_przeciwnik.setIcon(wierzch);
                        // wywolanie roztrzygniecia wczesniej utworzonego w Rozgrywka

                        r.roztrzygniecie();
                        if (r.isCzy_wygral_gracz_GUI()) {
                            JOptionPane.showMessageDialog(null, "Wygrałeś z układem " + uklad_zwyciezcy[r.getWartosc_reki(reka_gracz)]);
                            kaska_gracza_GUI = kaska_gracza_GUI + 200;
                        }
                        if (r.isCzy_wygral_przeciwnik_GUI()) {
                            JOptionPane.showMessageDialog(null, "Przeciwnik wygrywa z układem " + uklad_zwyciezcy[r.getWartosc_reki(reka_przeciwnik)]);
                            kaska_przeciwnik_GUI = kaska_przeciwnik_GUI + 200;
                        }
                        kaska_przeciwnika_1.setText(kaska_przeciwnik_GUI + " $");
                        kaska_gracza_1.setText(kaska_gracza_GUI + " $");
                        sprawdzenie.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Żeby sprawdzić kto wygrał, najpierw zakończ wymianę klikając przycisk Koniec Wymiany ");
                    }

                }
            });
            koniec.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int potwierdzenie = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz zakończyć rozgrywkę ?", null, JOptionPane.YES_NO_OPTION);
                    if (potwierdzenie == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Do zobaczenia wkrótce :)");
                        System.exit(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "No to grajmy dalej :)");
                    }
                }
            });
}


    public static void main(String[] args) throws IOException {

            Talia talia = new Talia();          // rozdanie typu komputer - gracz
            talia.tasowanie();
            talia.tasowanie();

            Reka reka_gracz = new Reka(talia);
            reka_gracz.sortowanieReka();

            Reka reka_przeciwnik = new Reka(talia);
            reka_przeciwnik.sortowanieReka();

            int i = -1;      // zmienna pomocnicza
            String wprowadz_kaske_gracza = null;
            int kaska_gracza = 0;
            int kaska_przeciwnika = 0;

            while(i == -1) {
                wprowadz_kaske_gracza = JOptionPane.showInputDialog(null, "Podaj swoje zasoby pieniężne ( pamiętaj że minimum wkładu to 500 $ ) ");
                i = czy_poprawne_dane(wprowadz_kaske_gracza);
            }
            if(i != -1) {
                kaska_gracza = Integer.parseInt(wprowadz_kaske_gracza);
                kaska_przeciwnika = kaska_gracza + 500;
            }

            JFrame frame = new JFrame("Poker"); // powolanie pierwszego frame'a
            frame.setContentPane(new RozgrywkaGUI(reka_gracz, reka_przeciwnik, kaska_gracza, kaska_przeciwnika, frame).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

    }
    private static int czy_poprawne_dane(String dane){
        try{
            if(Integer.parseInt(dane) >= 500) {
                return Integer.parseInt(dane);
            }
            else{
                JOptionPane.showMessageDialog(null, " Z tym nie wejdziesz do Naszego kasyna ");
                return -1;
            }
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, " Z tym nie wejdziesz do Naszego kasyna ");
            return -1;
        }
    }
}
