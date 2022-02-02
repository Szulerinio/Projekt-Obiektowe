package Bank;

import Bank.model.Klient;
import Bank.model.ObiektBazodanowy;
import Bank.model.Osobiste;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Main {
    private static List<ObiektBazodanowy> bazaDanych = new ArrayList<>();

    public static List<ObiektBazodanowy> getBazaDanych() {

        return bazaDanych;
    }
    public static void addToBazaDanych(ObiektBazodanowy obiekt) {
        bazaDanych.add(obiekt);
    }

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // TODO code application logic here
        int userInput = 7;
        while (userInput != 0) {
            System.out.println("""
                    Wybierz:\s
                    1 by dodać obiekt\s
                    2 by usunąć obiekt\s
                    3 by wyświetlić obiekty\s
                    4 by wyświetlić wybrany typ obiektów\s
                    5 by wyświetlić obiekty po nazwie\s
                    6 by wykonać operację\s
                    0 by zakończyć program\s
                    """);
            while (!sc.hasNextInt()) {
                String input = sc.next();
                System.out.println("niepoprawna liczba");
            }
            userInput = Main.sc.nextInt();

            switch (userInput) {
                case 1:
                    Menu.dodaj();
                    break;
                case 2:
                    Menu.usunObiekt();
                    break;
                case 3:
                    Menu.wyswietlWszystkie();
                    break;
                case 4:
                    Menu.wyswietlWybrane();
                    break;
                case 5:
                    Menu.wyswietlPoNazwie();
                    break;
                case 6:
                    Menu.wykonajPrzelew();
                    break;
                default:
                    System.out.println("Zakończenie programu"+
                            "\n aaaaa"+
                            "bbbb");


                    break;

            }

        }

    }

}
