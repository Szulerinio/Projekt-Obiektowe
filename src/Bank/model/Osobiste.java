package Bank.model;

import Bank.interfaces.przelewalne;


public class Osobiste extends Konto implements przelewalne {
    private double limitWyplaty;

    void setLimitWyplaty(double nowyLimit){
        this.limitWyplaty= nowyLimit;
    }
    double getLimitWyplaty(){
        return limitWyplaty;
    }


    public Osobiste(String nazwa,  Klient wlasciciel, double limitWyplaty) {
        super(nazwa, wlasciciel);
        this.limitWyplaty = limitWyplaty;
    }

    public Przelew przelew(long kontoDolcelowe, double kwota){
        Przelew toReturn= new Przelew(kwota, this.getIdentyfikator(), kontoDolcelowe);
        return toReturn;
    }

    @Override
    public String toString() {
        return "Osobiste{ " +
                super.toString()+
                "limitWyplaty: " + this.getLimitWyplaty() +
                "} \n";
    }
}

