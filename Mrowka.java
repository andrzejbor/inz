package sample;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Created by Andrzej on 29.03.2017.
 */
public class Mrowka {

    private int numer;

    private int[] trasa = new int[6];

    private List<Port> odwiedzonePorty = new LinkedList<>();

    private List<Port> mozliwePorty = new LinkedList<>();

    public Mrowka(int numer) {
        this.numer = numer;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int[] getTrasa() {
        return trasa;
    }

    public void setTrasa(int[] trasa) {
        this.trasa = trasa;
    }



    public void wykonajTrase(List<Port> porty){
        mozliwePorty = porty;
        wypiszMozliwe(mozliwePorty);
        losujPort(mozliwePorty);
        if (mozliwePorty.size() > 0 ){
            wykonajTrase(mozliwePorty);
        }
    }

    public void losujPort(List<Port> porty) {
        Random random = new Random();
        int wylosowanyPort;
        wylosowanyPort = random.nextInt(porty.size());
       odwiedzonePorty.add(porty.get(wylosowanyPort));
        porty.remove(wylosowanyPort);
    }


    public void wypiszPorty() {
        System.out.println("Odwiedzone porty to: ");
        for (Port port : odwiedzonePorty) {
            System.out.println(port.getNazwaPortu());
        }

    }

    public void wypiszMozliwe(List<Port> porty) {
        System.out.println("Mozliwe porty to: ");
        for (Port port : porty) {
            System.out.println(port.getNazwaPortu());
        }

    }



}
