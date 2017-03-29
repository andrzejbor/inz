package sample;

/**
 * Created by Andrzej on 29.03.2017.
 */
public class Port {

    private int id;

    private String nazwaPortu;


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

}
