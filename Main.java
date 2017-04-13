package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }







    public static void main(String[] args) {
        launch(args);

        Mrowka mrowka = new Mrowka(1);
        Mrowka mrowka2 = new Mrowka(2);
        Mrowka mrowka3 = new Mrowka(3);
        Mrowka mrowka4 = new Mrowka(4);
        Mrowka mrowka5 = new Mrowka(5);
        Mrowka mrowka6 = new Mrowka(6);
        Mrowka mrowka7 = new Mrowka(7);
        Mrowka mrowka8 = new Mrowka(8);
        Mrowka mrowka9 = new Mrowka(9);
        Mrowka mrowka10 = new Mrowka(10);

        List<Port> porty = new LinkedList<>();

        List<Trasa> trasy = new LinkedList<>();

        List<Mrowka> mrowki = new LinkedList<>();

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

        mrowki.add(mrowka);
        mrowki.add(mrowka2);
        mrowki.add(mrowka3);
        mrowki.add(mrowka4);
        mrowki.add(mrowka5);
        mrowki.add(mrowka6);
        mrowki.add(mrowka7);
        mrowki.add(mrowka8);
        mrowki.add(mrowka9);
        mrowki.add(mrowka10);


        for (Port port : porty) {
            port.dostepneTrasy(port, trasy);
        }


        int sredniKoszt = 0;
        int iloscProb = 5000;

        for (int i = 0; i < iloscProb; i++) {
            for (Mrowka mrowkaZ : mrowki) {
//                mrowkaZ.wykonajTraseFeromon(porty, trasy);
                mrowkaZ.wykonajTrasePart1(porty,trasy);
                System.out.println(mrowkaZ.getKosztTrasy());
            }
            for (Mrowka mrowkaZ : mrowki) {
                mrowkaZ.wykonajTrasePart2(trasy);
            }
        }

        wypiszFeromon(trasy);
    }


    public static void wypiszFeromon (List<Trasa> trasy){
        System.out.println("Ilosc feromonu to: ");
        for (Trasa trasa : trasy) {
            System.out.println(trasa.getIdTrasy() + " " + trasa.getIloscFeromonu());
        }
    }



}


