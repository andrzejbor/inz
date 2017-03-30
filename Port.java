package sample;

import java.util.List;

/**
 * Created by Andrzej on 29.03.2017.
 */
public class Port implements funkcje {

    private int id;

    private String nazwaPortu;

    private int[] dostepneTrasy = new int[5];


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

    public int[] getDostepneTrasy() {
        return dostepneTrasy;
    }

    public void dodajDostepnaTrase(int i, int trasa) {
        dostepneTrasy[i] = trasa;
    }

    static void wypiszDostepneTrasy(List<Port> porty) {
        for (Port port : porty){
            System.out.println(port.getNazwaPortu());
            for (int i=0; i < port.dostepneTrasy.length; i++ ){
                if (!(port.dostepneTrasy[i] == 0 )) {
                    System.out.println(port.dostepneTrasy[i]+" ");
                }
            }
        }
    }
}
