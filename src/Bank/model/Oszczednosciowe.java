package Bank.model;
import Bank.interfaces.przelewalne;

import java.util.ArrayList;
import java.util.List;

public class Oszczednosciowe extends Konto implements przelewalne {
    private float procent;
    private List<Przelew> przelewyWychodzace;

    public float getProcent() {
        return procent;
    }

    public void setProcent(float procent) {
        this.procent = procent;
    }

    public void dodajPrzelewWychodzacy( Przelew przelew){

        this.przelewyWychodzace.add(przelew);

    }

    public Oszczednosciowe(String nazwa, Klient wlasciciel, float procent) {
        super(nazwa, wlasciciel);
        this.przelewyWychodzace = new ArrayList<>();
        this.procent = procent;
    }

    @Override
    public String toString() {
        return "Oszczednosciowe{ " +
                super.toString() +
                ", obciążenia : {" + getPrzelewyWychodzaceString() +
                "}, procent: " + this.getProcent() +
                "} \n ";
    }

    private String getPrzelewyWychodzaceString(){
        String toReturn= "";
        if (this.przelewyWychodzace.size()>0){

            for (Przelew przelew: this.przelewyWychodzace){
                toReturn += "identyfikator: " + przelew.getIdentyfikator() +
                        ", konto docelowe: " + przelew.getOdbiorca().getIdentyfikator() +
                        ", kwota: " + przelew.getKwota() +
                        ", data: " + przelew.getData();
            }
        }

        return toReturn;
    }
}
