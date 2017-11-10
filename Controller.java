package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.*;

public class Controller implements Initializable {

    @FXML
    Button Losowanie;

    @FXML
    Button Algorytm;

    @FXML
    TextField tekst;

    @FXML
    TableView tableView;


    EventHandler<ActionEvent> btnSecAction = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            tworzMrowki(mrowki, 10);

            losujPort(porty, mrowki);
            

            int i = 0;
            int kosztNajlepszejTrasy = najlepszaTrasa.getKosztTrasy();

            while (i < 10) {

                for (Mrowka mrowkaZ : mrowki) {
                    mrowkaZ.wykonajTrasePart1(porty, trasy);
                    wybierzNajlepszaTrase(mrowkaZ, najlepszaTrasa);
                }
                for (Mrowka mrowkaZ : mrowki) {
                    mrowkaZ.wykonajTrasePart2(trasy);
                    System.out.println(mrowkaZ.getKosztTrasy());
                }
                if (kosztNajlepszejTrasy == najlepszaTrasa.getKosztTrasy()) {
                    i++;
                } else {
                    if (kosztNajlepszejTrasy == 0) {
                        kosztNajlepszejTrasy = najlepszaTrasa.getKosztTrasy();
                    } else {
                        if (kosztNajlepszejTrasy > najlepszaTrasa.getKosztTrasy()) {
                            kosztNajlepszejTrasy = najlepszaTrasa.getKosztTrasy();
                            i = 0;
                        }
                    }
                }
            }

            wypiszFeromon(trasy);
            wypiszNajlepszaTrase(najlepszaTrasa);
        }
    };

    EventHandler<ActionEvent> btnNewHandler =
            new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {

                    data.clear();
                    for (int j = 0; j < porty.size(); j++) {
                        Record newRec = new Record(
                                porty.get(j).getNazwaPortu(),
                                random.nextInt(100),
                                random.nextInt(100),
                                random.nextInt(100),
                                random.nextInt(100),
                                random.nextInt(100));
                        zerowanie(j, newRec);
                        data.add(newRec);
                    }
                    Algorytm.setDisable(false);
                }

            };

    private void zerowanie(int j, Record record) {
        switch (j) {
            case 0:
                record.setValue_0(0);
                break;
            case 1:
                record.setValue_1(0);
                break;
            case 2:
                record.setValue_2(0);
                break;
            case 3:
                record.setValue_3(0);
                break;
            case 4:
                record.setValue_4(0);
                break;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Algorytm.setOnAction(btnSecAction);
        Losowanie.setOnAction(btnNewHandler);
        tableView.setEditable(true);
        Callback<TableColumn, TableCell> cellFactory =
                new Callback<TableColumn, TableCell>() {

                    @Override
                    public TableCell call(TableColumn p) {
                        return new EditingCell();
                    }
                };
        TableColumn col_id = new TableColumn("Port");
        tableView.getColumns().add(col_id);
        col_id.setCellValueFactory(new PropertyValueFactory<Record, String>("id"));
        for (int i = 0; i < porty.size(); i++) {
            TableColumn col = new TableColumn(porty.get(i).getNazwaPortu());
            col.setCellValueFactory(
                    new PropertyValueFactory<Record, String>(
                            "value_" + String.valueOf(i)));
            tableView.getColumns().add(col);
            col.setCellFactory(cellFactory);
            tableView.setItems(data);

        }
    }
}

