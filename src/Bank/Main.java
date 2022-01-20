package Bank;

import Bank.model.Klient;
import Bank.model.ObiektBazodanowy;
import Bank.model.Osobiste;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static  List<ObiektBazodanowy> bazaDanych = new ArrayList<>();

    public static List<ObiektBazodanowy> getBazaDanych() {
        return bazaDanych;
    }

    public static void main(String[] args) {

        // TODO code application logic here


    bazaDanych.add( new Klient("rasz", 301, 20000, "Marusz", "suchar"));
    bazaDanych.add(new Osobiste("nazwa",(Klient) getBazaDanych().get(0),500));

    System.out.println(bazaDanych.get(1).toString());
//    for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
//
//            System.out.println(obiektBazodanowy.toString());
//    }


    }

}
