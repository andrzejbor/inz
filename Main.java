package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;


public class Main extends Application {

    public static Random random = new Random();

    public static ObservableList<Record> data = FXCollections.observableArrayList();


    public static List<Port> porty = new LinkedList<>();

    public static List<Trasa> trasy = new LinkedList<>();

    public static List<Mrowka> mrowki = new LinkedList<>();

    public static NajlepszaTrasa najlepszaTrasa = new NajlepszaTrasa();

    @Override
    public void start(Stage primaryStage) throws Exception {
        przygotowanie();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Algorytm mrówkowy");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }


    public static void wypiszFeromon(List<Trasa> trasy) {
        System.out.println("Ilosc feromonu to: ");
        for (Trasa trasa : trasy) {
            System.out.println(trasa.getIdTrasy() + " " + trasa.getIloscFeromonu());
        }
    }


    public static void tworzMrowki(List<Mrowka> mrowki, int iloscMrowek) {
        for (int i = 0; i < iloscMrowek; i++) {
            mrowki.add(new Mrowka(i));
        }
    }

    public static void wybierzNajlepszaTrase(Mrowka mrowka, NajlepszaTrasa najlepszaTrasa) {
        if (najlepszaTrasa.getKosztTrasy() == 0) {
            najlepszaTrasa.setKosztTrasy(mrowka.getKosztTrasy());
            najlepszaTrasa.setZawarteTrasy(mrowka.getPrzebyteTrasy());
        } else if (najlepszaTrasa.getKosztTrasy() > mrowka.getKosztTrasy()) {
            najlepszaTrasa.setKosztTrasy(mrowka.getKosztTrasy());
            najlepszaTrasa.setZawarteTrasy(mrowka.getPrzebyteTrasy());
        }
    }

    public static void wypiszNajlepszaTrase(NajlepszaTrasa najlepszaTrasa) {
        System.out.println("Najlepsza trasa to ");
        for (Trasa trasa : najlepszaTrasa.getZawarteTrasy()) {
            System.out.println(trasa.getIdTrasy());
        }
        System.out.println("Koszt trasy to " + najlepszaTrasa.getKosztTrasy());
    }

    public static void losujPort(List<Port> porty, List<Mrowka> mrowki) {
        Random random = new Random();
        int wylosowanyPort = random.nextInt(porty.size());
        for (Mrowka mrowkaZ: mrowki) {
           mrowkaZ.dodajOdwiedzonyPort(porty.get(wylosowanyPort));
           mrowkaZ.setObecnyPort(porty.get(wylosowanyPort));
        }
    }

    public static void przygotowanie() {
        Port gdynia = new Port(1, "Gdynia");
        Port gdansk = new Port(2, "Gdansk");
        Port szczecin = new Port(3, "Szczecin");
        Port swinoujscie = new Port(4, "Swinoujscie");
        Port ustka = new Port(5, "Ustka");

        porty.add(gdynia);
        porty.add(gdansk);
        porty.add(szczecin);
        porty.add(swinoujscie);
        porty.add(ustka);

        Trasa gdyniaGdansk = new Trasa(10, gdynia, gdansk, 10);
        Trasa gdyniaSzczecin = new Trasa(11, gdynia, szczecin, 11);
        Trasa gdyniaSwinoujscie = new Trasa(12, gdynia, swinoujscie, 12);
        Trasa gdanskSzczecin = new Trasa(13, gdansk, szczecin, 13);
        Trasa gdanskSwinoujscie = new Trasa(14, gdansk, swinoujscie, 14);
        Trasa szczecinSwinoujscie = new Trasa(15, szczecin, swinoujscie, 15);
        Trasa gdyniaUstka = new Trasa(16, gdynia, ustka, 16);
        Trasa gdanskUstka = new Trasa(17, gdansk, ustka, 17);
        Trasa szczecinUstka = new Trasa(18, szczecin, ustka, 18);
        Trasa swinoujscieUstka = new Trasa(19, swinoujscie, ustka, 19);

        trasy.add(gdyniaGdansk);
        trasy.add(gdyniaSzczecin);
        trasy.add(gdyniaSwinoujscie);
        trasy.add(gdanskSzczecin);
        trasy.add(gdanskSwinoujscie);
        trasy.add(szczecinSwinoujscie);
        trasy.add(gdyniaUstka);
        trasy.add(gdanskUstka);
        trasy.add(szczecinUstka);
        trasy.add(swinoujscieUstka);


        Port oslo = new Port(6,"Oslo");

        porty.add(oslo);

        Trasa osloGdynia = new Trasa(20, oslo, gdynia,20);
        Trasa osloGdansk = new Trasa(21, oslo, gdansk, 21);
        Trasa osloSzczecin = new Trasa(22, oslo, szczecin, 22);
        Trasa osloSwinoujscie = new Trasa(23, oslo, swinoujscie, 23);
        Trasa osloUstka = new Trasa(24, oslo, ustka, 24);

        trasy.add(osloGdynia);
        trasy.add(osloGdansk);
        trasy.add(osloSzczecin);
        trasy.add(osloSwinoujscie);
        trasy.add(osloUstka);

        Port ystad = new Port(7,"Ystad");

        porty.add(ystad);

        Trasa ystadGdynia = new Trasa(25, ystad, gdynia, 25);
        Trasa ystadGdansk = new Trasa(26, ystad, gdansk, 26);
        Trasa ystadSzczecin = new Trasa(27, ystad, szczecin, 27);
        Trasa ystadSwinoujscie = new Trasa(28, ystad, swinoujscie, 28);
        Trasa ystadUstaka = new Trasa(29, ystad, ustka, 29);
        Trasa ystadOslo = new Trasa(30, ystad, oslo, 30);

        trasy.add(ystadGdynia);
        trasy.add(ystadGdansk);
        trasy.add(ystadSzczecin);
        trasy.add(ystadSwinoujscie);
        trasy.add(ystadUstaka);
        trasy.add(ystadOslo);

        Port tallin = new Port(8,"Tallin");

        porty.add(tallin);

        Trasa tallinGdynia = new Trasa(31, tallin, gdynia, 31);
        Trasa tallinGdansk = new Trasa(32, tallin, gdansk, 32);
        Trasa tallinSzczecin = new Trasa(33, tallin, szczecin, 33);
        Trasa tallinSwinoujscie = new Trasa(34, tallin, swinoujscie, 34);
        Trasa tallinUstka = new Trasa(35, tallin, ustka, 35);
        Trasa tallinOslo = new Trasa(36, tallin, oslo, 36);
        Trasa tallinYstad = new Trasa(37, tallin, ystad, 37);

        trasy.add(tallinGdynia);
        trasy.add(tallinGdansk);
        trasy.add(tallinSzczecin);
        trasy.add(tallinSwinoujscie);
        trasy.add(tallinUstka);
        trasy.add(tallinOslo);
        trasy.add(tallinYstad);


        Port ryga = new Port(9, "Ryga");

        porty.add(ryga);

        Trasa rygaGdynia = new Trasa(38, ryga, gdynia, 38);
        Trasa rygaGdansk = new Trasa(39, ryga, gdansk, 39);
        Trasa rygaSzczecin = new Trasa(40, ryga, szczecin, 40);
        Trasa rygaSwinoujscie = new Trasa(41, ryga, swinoujscie, 41);
        Trasa rygaUstka = new Trasa(42, ryga, ustka, 42);
        Trasa rygaOslo = new Trasa(43, ryga, oslo, 43);
        Trasa rygaYstad = new Trasa(44, ryga, ystad, 44);
        Trasa rygaTallin = new Trasa(45, ryga, tallin, 45);

        trasy.add(rygaGdynia);
        trasy.add(rygaGdansk);
        trasy.add(rygaSzczecin);
        trasy.add(rygaSwinoujscie);
        trasy.add(rygaUstka);
        trasy.add(rygaOslo);
        trasy.add(rygaYstad);
        trasy.add(rygaTallin);

        Port helsinki = new Port(10,"Helsinki");

        porty.add(helsinki);

        Trasa helsinkiGdynia = new Trasa(46, helsinki, gdynia, 46);
        Trasa helsinkiGdansk = new Trasa(47, helsinki, gdansk, 47);
        Trasa helsinkiSzczecin = new Trasa(48, helsinki, szczecin, 48);
        Trasa helsinkiSwinoujscie = new Trasa(49, helsinki, swinoujscie, 49);
        Trasa helsinkiUstka = new Trasa(50, helsinki, ustka, 50);
        Trasa helsinkiOslo = new Trasa(51, helsinki, oslo, 51);
        Trasa helsinkiYstad = new Trasa(52, helsinki, ystad, 52);
        Trasa helsinkiTallin = new Trasa(53, helsinki, tallin, 53);
        Trasa helsinkiRyga = new Trasa(54, helsinki, ryga, 54);

        trasy.add(helsinkiGdynia);
        trasy.add(helsinkiGdansk);
        trasy.add(helsinkiSzczecin);
        trasy.add(helsinkiSwinoujscie);
        trasy.add(helsinkiUstka);
        trasy.add(helsinkiOslo);
        trasy.add(helsinkiYstad);
        trasy.add(helsinkiTallin);
        trasy.add(helsinkiRyga);

        for (Port port : porty) {
            port.dostepneTrasy(port, trasy);
        }
    }

}


