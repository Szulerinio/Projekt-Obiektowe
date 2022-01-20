package Bank.model;

public abstract class Konto extends ObiektBazodanowy {
    private Klient wlasciciel;
    private double stanKonta;

    public Konto(String nazwa, Klient klient) {
        super(nazwa);
        this.wlasciciel = klient;
        this.stanKonta = 0;
        klient.dodajKonto(this);
    }


    void aktualizujStan(double kwota) {
        this.stanKonta += kwota;

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
        return  super.toString() +
                ", wlasciciel: " + this.getWlasciciel() +
                ", stanKonta: " + this.getStanKonta();
    }

}
