package Bank.interfaces;

import Bank.model.Przelew;

public interface przelewalne {
    Przelew przelew(long kontoDolcelowe, double kwota);

//    boolean zamknijKonto();
}
