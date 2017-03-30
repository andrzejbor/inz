package sample;

import java.util.Random;

/**
 * Created by Andrzej on 29.03.2017.
 */
public class Mrowka {

    private int numer;

    private int[] trasa;

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

    public int losujPierwszyPort(){
        Random random = new Random();
        int wylosowanyPort;
        wylosowanyPort = random.nextInt(3) + 1;
        return wylosowanyPort;
    }

    public void losujKolejnyPort(){
        Random random = new Random();
        int wylosowanyPort;

    }



}
