package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

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

        List<Port> porty = new LinkedList<>();
        
        List<Trasa> trasy = new LinkedList<>();

        Port gdynia = new Port(1,"Gdynia");
        Port gdansk = new Port(2,"Gdansk");
        Port szczecin = new Port(3,"Szczecin");

        porty.add(gdynia);
        porty.add(gdansk);
        porty.add(szczecin);

        Trasa gdyniaGdansk = new Trasa(10,1,2);
        Trasa gdyniaSzczecin = new Trasa(11,1,3);
        Trasa gdanskSzczecin = new Trasa(12,2,3);
        
        trasy.add(gdyniaGdansk);
        trasy.add(gdyniaSzczecin);
        trasy.add(gdanskSzczecin);

        Trasa.dodawanieTras(porty,trasy);

        Port.wypiszDostepneTrasy(porty);

    }

    

}
