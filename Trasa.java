package sample;

import java.util.List;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by Andrzej on 29.03.2017.
 */
public class Trasa implements funkcje {

    private int idTrasy;

    private Port port1;

    private Port port2;

    private int kosztTransportu;

    private int iloscFeromonu;

    public Trasa() {}

    public Trasa(int idTrasy, Port port1, Port port2, int kosztTransportu) {
        this.idTrasy = idTrasy;
        this.port1 = port1;
        this.port2 = port2;
        this.kosztTransportu = kosztTransportu;
    }

    public int getKosztTransportu() {
        return kosztTransportu;
    }

    public void setKosztTransportu(int kosztTransportu) {
        this.kosztTransportu = kosztTransportu;
    }

    public int getIloscFeromonu() {
        return iloscFeromonu;
    }

    public void setIloscFeromonu(int iloscFeromonu) {
        this.iloscFeromonu = iloscFeromonu;
    }

    public Port getPort1() {
        return port1;
    }

    public void setPort1(Port port1) {
        this.port1 = port1;
    }

    public Port getPort2() {
        return port2;
    }

    public void setPort2(Port port2) {
        this.port2 = port2;
    }

    public int getIdTrasy() {
        return idTrasy;
    }

    public void setIdTrasy(int idTrasy) {
        this.idTrasy = idTrasy;
    }


}
