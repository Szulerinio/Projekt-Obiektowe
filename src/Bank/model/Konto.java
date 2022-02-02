package Bank.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Konto extends ObiektBazodanowy {
    private Klient wlasciciel;
    private double stanKonta;
    private List<Przelew> przelewyPrzychodzace;

    public Konto(String nazwa, Klient klient) {
        super(nazwa);
        this.wlasciciel = klient;
        this.stanKonta = 0;
        klient.dodajKonto(this);
        this.przelewyPrzychodzace = new ArrayList<>();
    }


    void aktualizujStan(double kwota) {
        this.stanKonta += kwota;

    }
    public void dodajPrzelewPrzychodzacy( Przelew przelew) {
            this.przelewyPrzychodzace.add(przelew);
    }

    public Klient getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(Klient wlasciciel) {
        this.getWlasciciel().usunKonto(this);
        wlasciciel.dodajKonto(this);
        this.wlasciciel = wlasciciel;
    }

    public double getStanKonta() {
        return stanKonta;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", wlasciciel: { imię: " + this.getWlasciciel().getImie() +
                ", Nazwisko" + this.getWlasciciel().getNazwisko() +
                ", identyfikator" + this.getWlasciciel().getIdentyfikator() +
                ", stanKonta: " + this.getStanKonta()+
                ", uznania : {"+ getPrzelewyPrzychodzaceString() +
                "}";
    }



    private String getPrzelewyPrzychodzaceString(){
        String toReturn= "";
        if (this.przelewyPrzychodzace.size()>0){

            for (Przelew przelew: this.przelewyPrzychodzace){
                toReturn += "identyfikator: " + przelew.getIdentyfikator() +
                        ", źródło : " + (przelew.getNadawca() == null ?  " wpłata" : przelew.getNadawca().getIdentyfikator() ) +
                        ", kwota: " + przelew.getKwota() +
                        ", data: " + przelew.getData();
            }
        }

        return toReturn;
    }
}
