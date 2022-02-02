package Bank.model;

import Bank.interfaces.przelewalne;

import java.util.ArrayList;
import java.util.List;

import static Bank.Main.getBazaDanych;


public class Osobiste extends Konto implements przelewalne {
    private double limitWyplaty;
    private List<Przelew> przelewyWychodzace;

    void setLimitWyplaty(double nowyLimit) {
        this.limitWyplaty = nowyLimit;
    }

    double getLimitWyplaty() {
        return limitWyplaty;
    }


    public Osobiste(String nazwa, Klient wlasciciel, double limitWyplaty) {
        super(nazwa, wlasciciel);
        this.limitWyplaty = limitWyplaty;
        this.przelewyWychodzace = new ArrayList<>();
    }


    public void dodajPrzelewWychodzacy(Przelew przelew) {

        this.przelewyWychodzace.add(przelew);

    }

    @Override
    public String toString() {
        return "Osobiste{ " +
                super.toString() +
                ", obciążenia : {" + getPrzelewyWychodzaceString() +
                "}, limitWyplaty: " + this.getLimitWyplaty() +
                "} \n";
    }

    private String getPrzelewyWychodzaceString() {
        String toReturn = "";
        if (this.przelewyWychodzace.size() > 0) {

            for (Przelew przelew : this.przelewyWychodzace) {
                toReturn += "identyfikator: " + przelew.getIdentyfikator() +
                        ", konto docelowe: " + przelew.getOdbiorca().getIdentyfikator() +
                        ", kwota: " + przelew.getKwota() +
                        ", data: " + przelew.getData();
            }
        }

        return toReturn;
    }
}

