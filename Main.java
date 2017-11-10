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


        for (Port port : porty) {
            port.dostepneTrasy(port, trasy);
        }
    }

}


