package sample;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrzej on 29.03.2017.
 */
public class Port implements funkcje {

    private int id;

    private String nazwaPortu;

    private List<Trasa> mozliweTrasy = new LinkedList<>();

    public Port(int id, String nazwaPortu) {
        this.id = id;
        this.nazwaPortu = nazwaPortu;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwaPortu() {
        return nazwaPortu;
    }

    public void setNazwaPortu(String nazwaPortu) {
        this.nazwaPortu = nazwaPortu;
    }

    public List<Trasa> getMozliweTrasy() {
        return mozliweTrasy;
    }

    public void setMozliweTrasy(List<Trasa> mozliweTrasy) {
        this.mozliweTrasy = mozliweTrasy;
    }

    public void dostepneTrasy (Port port, List<Trasa> trasy) {
        mozliweTrasy.clear();
        for (Trasa trasa : trasy) {
            if (trasa.getPort1() == port || trasa.getPort2() == port) {
                mozliweTrasy.add(trasa);
            }
        }

    }

}
