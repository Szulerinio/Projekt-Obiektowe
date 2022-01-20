package Bank.model;
import Bank.interfaces.przelewalne;

public class Oszczednosciowe extends Konto implements przelewalne {
    private float procent;

    public float getProcent() {
        return procent;
    }

    public void setProcent(float procent) {
        this.procent = procent;
    }

    public Oszczednosciowe(String nazwa, Klient wlasciciel, float procent) {
        super(nazwa, wlasciciel);
        this.procent = procent;
    }
    public Przelew przelew(long kontoDolcelowe, double kwota){
        Przelew toReturn= new Przelew(kwota, this.getIdentyfikator(), kontoDolcelowe);
        return toReturn;
    }

    @Override
    public String toString() {
        return "Oszczednosciowe{ " +
                super.toString() +
                "procent:" + this.getProcent() +
                "} \n ";
    }
}
