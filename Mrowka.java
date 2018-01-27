package sample;

import java.util.*;

import static oracle.jrockit.jfr.events.Bits.intValue;
import static sample.Main.random;

/**
 * Created by Andrzej on 29.03.2017.
 */
public class Mrowka {


    private int numer;

    private List<Port> odwiedzonePorty = new LinkedList<>();

    private List<Trasa> przebyteTrasy = new LinkedList<>();

    private int kosztTrasy;

    private Port obecnyPort;

    private Port ostatniPort;

    private final int podstawowyFeromon = 70;

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

    public List<Trasa> getPrzebyteTrasy() {
        return przebyteTrasy;
    }

    public void setPrzebyteTrasy(List<Trasa> przebyteTrasy) {
        this.przebyteTrasy = przebyteTrasy;
    }

    public Port getObecnyPort() {
        return obecnyPort;
    }

    public void setObecnyPort(Port obecnyPort) {
        this.obecnyPort = obecnyPort;
    }

    public void dodajOdwiedzonyPort(Port odwiedzonyPort) {
        odwiedzonePorty.add(odwiedzonyPort);
    }

    public List<Port> getOdwiedzonePorty() {
        return odwiedzonePorty;
    }

    public void wypiszOdwiedzonePorty() {
        System.out.println("Odwiedzone porty to: ");
        for (Port port : odwiedzonePorty) {
            System.out.println(port.getNazwaPortu());
        }

    }


    public void wypiszPrzebyteTrasy(List<Trasa> przebyteTrasy) {
        System.out.println("Przebyte trasy to:");
        for (Trasa trasa : przebyteTrasy) {
            System.out.println(trasa.getIdTrasy());
        }
    }


//    public void wykonajTraseFeromon(List<Port> porty, List<Trasa> trasy) {
//        List<Trasa> mozliweTrasy = new LinkedList<>(trasy);
//        przebyteTrasy.clear();
//        odwiedzonePorty.clear();
//        kosztTrasy = 0;
//        losujPort(porty);
//        losujPierwszaTrase(mozliweTrasy);
//        losujTrase(mozliweTrasy);
//        dodawanieFeromonu(przebyteTrasy);
//        parowanieFeromonu(trasy);
//    }

    public void wykonajTrasePart1(List<Trasa> trasy) {
        List<Trasa> mozliweTrasy = new LinkedList<>(trasy);
        przebyteTrasy.clear();
        wyczyscListe(odwiedzonePorty);
        kosztTrasy = 0;
        losujPierwszaTrase(mozliweTrasy);
        losujTrase(mozliweTrasy);
    }

    public void wykonajTrasePart2(List<Trasa> trasy) {
        dodawanieFeromonu(przebyteTrasy);
        parowanieFeromonu(trasy);
    }


    public void losujPierwszaTrase(List<Trasa> trasy) {
        int wylosowanaTrasa = random.nextInt(obecnyPort.getMozliweTrasy().size());
        przebyteTrasy.add(obecnyPort.getMozliweTrasy().get(wylosowanaTrasa));
        ostatniPort = obecnyPort;
        kosztTrasy += obecnyPort.getMozliweTrasy().get(wylosowanaTrasa).getKosztTransportu();
        if (ostatniPort.getMozliweTrasy().get(wylosowanaTrasa).getPort1() == obecnyPort) {
            obecnyPort = ostatniPort.getMozliweTrasy().get(wylosowanaTrasa).getPort2();
        } else {
            obecnyPort = ostatniPort.getMozliweTrasy().get(wylosowanaTrasa).getPort1();
        }
        odwiedzonePorty.add(obecnyPort);
        usunTrasyZListy(trasy);
    }

    public void losujTrase(List<Trasa> trasy) {
        Random random = new Random();
        int maksymalnyKoszt = maksymalnyKosztTrasy(trasy);
        List<Trasa> mozliweTrasyDlaPortu = new LinkedList<>();
        for (Trasa trasa : trasy) {
            if (trasa.getPort1() == obecnyPort || trasa.getPort2() == obecnyPort) {
                if (trasa.getIloscFeromonu() == 0) {
                    for (int k = 0; k < (((maksymalnyKoszt-trasa.getKosztTransportu())+2)*2); k++){
                        mozliweTrasyDlaPortu.add(trasa);
                    }
                } else {
                    int j = trasa.getIloscFeromonu();
                    for (int i = 0; i < j; i++) {
                        mozliweTrasyDlaPortu.add(trasa);
                    }
                    for (int k = 0; k < ((maksymalnyKoszt-trasa.getKosztTransportu()+2)); k++){
                        mozliweTrasyDlaPortu.add(trasa);
                    }
                }
            }
        }
        int wylosowanaTrasa = random.nextInt(mozliweTrasyDlaPortu.size());
        przebyteTrasy.add(mozliweTrasyDlaPortu.get(wylosowanaTrasa));
        ostatniPort = obecnyPort;
        kosztTrasy += mozliweTrasyDlaPortu.get(wylosowanaTrasa).getKosztTransportu();
        if (obecnyPort == mozliweTrasyDlaPortu.get(wylosowanaTrasa).getPort1()) {
            obecnyPort = mozliweTrasyDlaPortu.get(wylosowanaTrasa).getPort2();
        } else {
            obecnyPort = mozliweTrasyDlaPortu.get(wylosowanaTrasa).getPort1();
        }
        odwiedzonePorty.add(obecnyPort);
        usunTrasyZListy(trasy);

        if (trasy.size() > 0) {
            losujTrase(trasy);
        }

    }

    public void usunTrasyZListy(List<Trasa> trasy) {
        Iterator<Trasa> i = trasy.iterator();
        while (i.hasNext()) {
            Trasa t = i.next();
            if (t.getPort1() == ostatniPort || t.getPort2() == ostatniPort) {
                i.remove();
            }

        }
    }

    public void parowanieFeromonu(List<Trasa> trasy) {
        for (Trasa trasa : trasy) {
            int i = trasa.getIloscFeromonu();
            if (i * 0.8 > 1) {
                trasa.setIloscFeromonu(intValue(i * 0.8));
            }
        }
    }

    public void dodawanieFeromonu(List<Trasa> trasy) {
        for (Trasa trasa : trasy) {
            if (podstawowyFeromon - trasa.getKosztTransportu() > 0) {
                trasa.setIloscFeromonu(trasa.getIloscFeromonu() + (podstawowyFeromon - trasa.getKosztTransportu()));
            }
        }
    }

    public void wyczyscListe (List<Port> porty) {
        Port zastepczy = new Port();
        zastepczy = porty.get(0);
        porty.clear();
        porty.add(zastepczy);
    }

    public int maksymalnyKosztTrasy(List<Trasa> trasy){
        int maksymalnyKoszt = 0;
        for (Trasa trasa:trasy) {
            if (trasa.getKosztTransportu() > maksymalnyKoszt){
                maksymalnyKoszt = trasa.getKosztTransportu();
            }
        }
        return maksymalnyKoszt;
    }

}
