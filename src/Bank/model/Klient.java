package Bank.model;


import java.util.ArrayList;
import java.util.List;

public class Klient extends ObiektBazodanowy{
    long pesel;
    double zdolnoscKredytowa;
    String imie;
    String nazwisko;
    private List<Konto> listaKont;

    public Klient(String nazwa, long pesel, double zdolnoscKredytowa, String imie, String nazwisko) {
        super(nazwa);
        this.pesel = pesel;
        this.zdolnoscKredytowa = zdolnoscKredytowa;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.listaKont = new ArrayList<>();
    }

    public long getPesel() {
        return pesel;
    }

    public double getZdolnoscKredytowa() {
        return zdolnoscKredytowa;
    }

    public void setZdolnoscKredytowa(double zdolnoscKredytowa) {
        this.zdolnoscKredytowa = zdolnoscKredytowa;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }




    public void dodajKonto(Konto konto){
        this.listaKont.add(konto);
    }
    public void usunKonto(Konto konto){
        this.listaKont.remove(konto);
    }
    @Override
    public String toString() {
        return "Klient{" +
                super.toString() +
                ", pesel: " + pesel +
                ", zdolnoscKredytowa: " + zdolnoscKredytowa +
                ", imie: " + imie  +
                ", nazwisko: " + nazwisko +
                ", listaKont: " + this.getKonta() +
                "} \n";
    }

    private String getKonta(){
        String toReturn= "";
        if (this.listaKont.size()>0){

            for (Konto konto: this.listaKont){
                toReturn += "identyfikator: " + konto.getIdentyfikator() +
                        ", nazwa: {" + konto.getNazwa() + " }" ;
            }
        }

        return toReturn;
    }

}
