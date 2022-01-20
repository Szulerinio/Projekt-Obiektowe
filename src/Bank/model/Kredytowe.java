package Bank.model;


public class Kredytowe extends Konto {
    private double rata;
    private double dlugCalkowity;

    public double getRata() {
        return rata;
    }

    public double getDlugCalkowity() {
        return dlugCalkowity;
    }

    public Kredytowe(String nazwa, Klient wlasciciel, float procent, double wartoscKredytu, int iloscRat) {
        super(nazwa, wlasciciel);
        this.dlugCalkowity = wartoscKredytu*procent;
        this.rata = wartoscKredytu*procent/iloscRat;
    }
    public void nowaRata(){
        if (dlugCalkowity>rata) {
            this.dlugCalkowity -= rata;
            this.aktualizujStan(rata);
        }else {
            this.aktualizujStan(dlugCalkowity);
            dlugCalkowity=0;
        }
    }

    @Override
    public String toString() {
        return "Kredytowe{ " +
                super.toString() +
                ", rata:" + rata +
                ", dlugCalkowity: " + dlugCalkowity +
                "} \n ";
    }
}
