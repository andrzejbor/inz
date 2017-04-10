package sample;

import java.util.*;

import static javafx.scene.input.KeyCode.L;

/**
 * Created by Andrzej on 29.03.2017.
 */
public class Mrowka {


    private int numer;

    private List<Port> odwiedzonePorty = new LinkedList<>();

    private List<Trasa> przebyteTrasy = new LinkedList<>();

    private List<Trasa> mozliweTrasy = new LinkedList<>();

    private int kosztTrasy;

    private Port obecnyPort;

    private Port ostatniPort;

    public Mrowka(int numer) {
        this.numer = numer;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int getKosztTrasy() {
        return kosztTrasy;
    }

    public void setKosztTrasy(int kosztTrasy) {
        this.kosztTrasy = kosztTrasy;
    }



    public void losujPort(List<Port> porty) {
        Random random = new Random();
        int wylosowanyPort = random.nextInt(porty.size());
        odwiedzonePorty.add(porty.get(wylosowanyPort));
        obecnyPort = porty.get(wylosowanyPort);
    }


    public void wypiszOdwiedzonePorty() {
        System.out.println("Odwiedzone porty to: ");
        for (Port port : odwiedzonePorty) {
            System.out.println(port.getNazwaPortu());
        }

    }



    public void wypiszPrzebyteTrasy(){
        System.out.println("Przebyte trasy to:");
        for (Trasa trasa : przebyteTrasy) {
            System.out.println(trasa.getIdTrasy());
        }
    }


    public void wykonajTraseFeromon(List<Port> porty, List<Trasa> trasy) {
        mozliweTrasy = trasy;
        losujPort(porty);
        losujPierwszaTrase(mozliweTrasy);
        losujTrase(mozliweTrasy);
    }

//    public void losujPortFeromon(List<Port> porty, List<Trasa> trasy) {
//        Random random = new Random();
//        List<Trasa> trasyDoLosowania = new LinkedList<>();
//        List<Trasa> selekcjaTras = new LinkedList<>();
//        for (Port port : porty) {
//            for (Trasa trasa : obecnyPort.getMozliweTrasy()) {
//                if (trasa.getPort1() == port || trasa.getPort2() == port) {
//                    selekcjaTras.add(trasa);
//                }
//            }
//        }
//        for (Trasa trasa : selekcjaTras) {
//            int j = trasa.getIloscFeromonu() + 1;
//            for ( int i = 0; i < j ; i++) {
//                trasyDoLosowania.add(trasa);
//            }
//        }
//        int wylosowanaTrasa;
//        wylosowanaTrasa = random.nextInt(trasyDoLosowania.size());
//
//
//
//    }

    public void losujPierwszaTrase(List<Trasa> trasy) {
        Iterator<Trasa> i = trasy.iterator();
        Random random = new Random();
        mozliweTrasy = trasy;
        int wylosowanaTrasa = random.nextInt(obecnyPort.getMozliweTrasy().size());
        przebyteTrasy.add(obecnyPort.getMozliweTrasy().get(wylosowanaTrasa));
        ostatniPort = obecnyPort;
        if (ostatniPort.getMozliweTrasy().get(wylosowanaTrasa).getPort1() == obecnyPort) {
            obecnyPort = ostatniPort.getMozliweTrasy().get(wylosowanaTrasa).getPort2();
        } else {
            obecnyPort = ostatniPort.getMozliweTrasy().get(wylosowanaTrasa).getPort1();
        }
        odwiedzonePorty.add(obecnyPort);
        while (i.hasNext()) {
            Trasa t = i.next();
            if (t.getPort1() == ostatniPort || t.getPort2() == ostatniPort ) {
                i.remove();
            }
        }
    }

    public void losujTrase(List<Trasa> trasy) {
        Iterator<Trasa> i = trasy.iterator();
        Random random = new Random();
        List<Trasa> mozliweTrasyDlaPortu = new LinkedList<>();
        for (Trasa trasa : trasy) {
            if (trasa.getPort1() == obecnyPort || trasa.getPort2() == obecnyPort) {
                mozliweTrasyDlaPortu.add(trasa);
            }
        }
        int wylosowanaTrasa = random.nextInt(mozliweTrasyDlaPortu.size());
        przebyteTrasy.add(mozliweTrasyDlaPortu.get(wylosowanaTrasa));
        ostatniPort = obecnyPort;
        if (obecnyPort == mozliweTrasyDlaPortu.get(wylosowanaTrasa).getPort1()){
            obecnyPort = mozliweTrasyDlaPortu.get(wylosowanaTrasa).getPort2();
        } else {
            obecnyPort = mozliweTrasyDlaPortu.get(wylosowanaTrasa).getPort1();
        }
        odwiedzonePorty.add(obecnyPort);
        while (i.hasNext()) {
            Trasa t = i.next();
            if (t.getPort1() == ostatniPort || t.getPort2() == ostatniPort ) {
                i.remove();
            }

        }

        if (mozliweTrasy.size() > 0){
            losujTrase(mozliweTrasy);
        }

    }



}
