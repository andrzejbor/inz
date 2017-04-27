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

    static Random random = new Random();

    public static ObservableList<Record> data = FXCollections.observableArrayList();

    static final String Porty[] = {
            "Gdynia",
            "Gdansk",
            "Szczecin",
            "Swinoujscie",
            "Ustka"};

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Algorytm mrówkowy");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);


        List<Port> porty = new LinkedList<>();

        List<Trasa> trasy = new LinkedList<>();

        List<Mrowka> mrowki = new LinkedList<>();

        NajlepszaTrasa najlepszaTrasa = new NajlepszaTrasa();

        Port gdynia = new Port(1, "Gdynia");
        Port gdansk = new Port(2, "Gdansk");
        Port szczecin = new Port(3, "Szczecin");
        Port swinoujscie = new Port(4, "Swinoujscie");

        porty.add(gdynia);
        porty.add(gdansk);
        porty.add(szczecin);
        porty.add(swinoujscie);

        Trasa gdyniaGdansk = new Trasa(10, gdynia, gdansk, 10);
        Trasa gdyniaSzczecin = new Trasa(11, gdynia, szczecin, 11);
        Trasa gdyniaSwinoujscie = new Trasa(12, gdynia, swinoujscie, 12);
        Trasa gdanskSzczecin = new Trasa(13, gdansk, szczecin, 13);
        Trasa gdanskSwinoujscie = new Trasa(14, gdansk, swinoujscie, 14);
        Trasa szczecinSwinoujscie = new Trasa(15, szczecin, swinoujscie, 15);

        trasy.add(gdyniaGdansk);
        trasy.add(gdyniaSzczecin);
        trasy.add(gdyniaSwinoujscie);
        trasy.add(gdanskSzczecin);
        trasy.add(gdanskSwinoujscie);
        trasy.add(szczecinSwinoujscie);


        for (Port port : porty) {
            port.dostepneTrasy(port, trasy);
        }

        tworzMrowki(mrowki, 10);

        int iloscProb = 1000;

        for (int i = 0; i < iloscProb; i++) {
            for (Mrowka mrowkaZ : mrowki) {
//                mrowkaZ.wykonajTraseFeromon(porty, trasy);
                mrowkaZ.wykonajTrasePart1(porty, trasy);
                wybierzNajlepszaTrase(mrowkaZ, najlepszaTrasa);
            }
            for (Mrowka mrowkaZ : mrowki) {
                mrowkaZ.wykonajTrasePart2(trasy);
                System.out.println(mrowkaZ.getKosztTrasy());
            }
        }

        wypiszFeromon(trasy);
        wypiszNajlepszaTrase(najlepszaTrasa);
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
        } else if (najlepszaTrasa.getKosztTrasy()>mrowka.getKosztTrasy()){
            najlepszaTrasa.setKosztTrasy(mrowka.getKosztTrasy());
            najlepszaTrasa.setZawarteTrasy(mrowka.getPrzebyteTrasy());
        }
    }

    public static void wypiszNajlepszaTrase (NajlepszaTrasa najlepszaTrasa){
        System.out.println("Najlepsza trasa to ");
        for (Trasa trasa: najlepszaTrasa.getZawarteTrasy()) {
            System.out.println(trasa.getIdTrasy());
        }
        System.out.println("Koszt trasy to "+najlepszaTrasa.getKosztTrasy());
    }

}


