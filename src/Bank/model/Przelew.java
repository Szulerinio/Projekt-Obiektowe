package Bank.model;

import Bank.enums.TypPrzelewu;

import java.util.HashMap;

import static Bank.enums.TypPrzelewu.wlasny;
import static Bank.enums.TypPrzelewu.zwykly;

public class Przelew {
    private double kwota;
    private long idNadawcy;
    private long data;
    private long idOdbiorcy;
    private TypPrzelewu typ ;


    public double getKwota() {
        return kwota;
    }

    public long getIdNadawcy() {
        return idNadawcy;
    }

    public long getData() {
        return data;
    }

    public long getIdOdbiorcy() {
        return idOdbiorcy;
    }

    public TypPrzelewu getTyp() {
        return typ;
    }

    public Przelew(double kwota, long idNadawcy, long idOdbiorcy) {
        this.kwota = kwota;
        this.idNadawcy = idNadawcy;
        this.data = System.currentTimeMillis();;
        this.idOdbiorcy = idOdbiorcy;
        if (idNadawcy== idNadawcy) {
            this.typ = wlasny;
        } else{
            this.typ = zwykly;
        }

    }

    @Override
    public String toString() {
        return "Przelew{ " +
                super.toString() +
                ", kwota: " + this.getKwota()+
                ", idNadawcy: " + this.getIdNadawcy() +
                ", timestamp: " + this.getData()+
                ", idOdbiorcy: " + this.getIdOdbiorcy() +
                ", typ: " + this.getTyp() +
                "} \n";
    }

}
