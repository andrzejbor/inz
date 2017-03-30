package sample;

import java.util.List;

/**
 * Created by Andrzej on 29.03.2017.
 */
public class Trasa implements funkcje {

    private int idTrasy;

    private int port1;

    private int port2;

    private int kosztTransportu;

    private int iloscFeromonu;

    public Trasa() {}

    public Trasa(int port1, int port2) {
        this.port1 = port1;
        this.port2 = port2;
    }

    public Trasa(int idTrasy, int port1, int port2) {
        this.idTrasy = idTrasy;
        this.port1 = port1;
        this.port2 = port2;
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

    public int getPort1() {
        return port1;
    }

    public void setPort1(int port1) {
        this.port1 = port1;
    }

    public int getPort2() {
        return port2;
    }

    public void setPort2(int port2) {
        this.port2 = port2;
    }

    public int getIdTrasy() {
        return idTrasy;
    }

    public void setIdTrasy(int idTrasy) {
        this.idTrasy = idTrasy;
    }

    static void dodawanieTras(List<Port> porty, List<Trasa> trasy) {
        for (Port port : porty) {
            int i = 0;
            for (Trasa trasa : trasy){
                if (trasa.getPort1() == port.getId() || trasa.getPort2() == port.getId()){
                    port.dodajDostepnaTrase(i,trasa.getIdTrasy());
                    i++;
                }
            }

        }
    }

}
