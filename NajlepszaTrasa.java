package sample;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrzej on 14.04.2017.
 */
public class NajlepszaTrasa {

    private List<Trasa> zawarteTrasy = new LinkedList<>();

    private int kosztTrasy;

    public NajlepszaTrasa() {
    }

    public NajlepszaTrasa(List<Trasa> zawarteTrasy, int kosztTrasy) {
        this.zawarteTrasy = zawarteTrasy;
        this.kosztTrasy = kosztTrasy;
    }

    public List<Trasa> getZawarteTrasy() {
        return zawarteTrasy;
    }

    public void setZawarteTrasy(List<Trasa> zawarteTrasy) {
        this.zawarteTrasy = zawarteTrasy;
    }

    public int getKosztTrasy() {
        return kosztTrasy;
    }

    public void setKosztTrasy(int kosztTrasy) {
        this.kosztTrasy = kosztTrasy;
    }
}
