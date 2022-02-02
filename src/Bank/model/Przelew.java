package Bank.model;

import Bank.enums.TypPrzelewu;
import Bank.interfaces.przelewalne;

import static Bank.enums.TypPrzelewu.wlasny;
import static Bank.enums.TypPrzelewu.zwykly;

public class Przelew extends ObiektBazodanowy {
    private double kwota;
    private Konto nadawca;
    private long data;
    private Konto odbiorca;
    private TypPrzelewu typ ;


    public double getKwota() {
        return kwota;
    }

    public Konto getNadawca() {
        return nadawca;
    }

    public long getData() {
        return data;
    }

    public Konto getOdbiorca() {
        return odbiorca;
    }

    public TypPrzelewu getTyp() {
        return typ;
    }

    public Przelew(String nazwa,double kwota, Konto nadawca,Konto odbiorca) {
        super(nazwa);
        this.kwota = kwota;
        this.data = System.currentTimeMillis();
        this.nadawca = nadawca;
        this.odbiorca= odbiorca;
        odbiorca.aktualizujStan(kwota);
        if (nadawca != null){
            if (nadawca.getWlasciciel()== odbiorca.getWlasciciel()) {
                this.typ = wlasny;
            } else{
                this.typ = zwykly;
            }
            if(nadawca instanceof przelewalne){
                ((przelewalne) nadawca).dodajPrzelewWychodzacy(this);
            }else{
                return;
            }
            nadawca.aktualizujStan(-kwota);
        }else{
            this.typ = wlasny;
        }
        odbiorca.dodajPrzelewPrzychodzacy(this);
    }

    @Override
    public String toString() {
        return "Przelew{ " +
                super.toString() +
                ", kwota: " + this.getKwota()+
                ", konto źródłowe: " + (this.getNadawca() == null ? "wpłata" : this.getNadawca().getIdentyfikator())+
                ", timestamp: " + this.getData()+
                ", konto docelowe: " + this.getOdbiorca().getIdentyfikator() +
                ", typ: " + this.getTyp() +
                "} \n";

    }

}
