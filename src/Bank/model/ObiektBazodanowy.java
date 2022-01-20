package Bank.model;

public abstract class ObiektBazodanowy {
    private long identyfikator;
    private String nazwa;
    private static long idFactory = 0;

    public long getIdentyfikator() {
        return identyfikator;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    static void incrementidFactory(){
        idFactory++;
    }
    public ObiektBazodanowy(String nazwa) {
        this.nazwa = nazwa;
        this.identyfikator = idFactory;
        incrementidFactory();
    }

    @Override
    public String toString() {
        return  "identyfikator: " + this.getIdentyfikator() +
                ", nazwa: " + this.getNazwa();
    }
}
