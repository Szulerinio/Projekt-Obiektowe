package Bank;

import Bank.interfaces.przelewalne;
import Bank.model.*;

import static Bank.Main.*;

public class Menu {

    public static void dodaj() {
        int userInput;
        System.out.println("""
                Wybierz:\s
                1 by dodać Klienta\s
                2 by dodać konto osobiste\s
                3 by dodać konto oszczędnościowe\s
                4 by dodać konto kredytowe\s
                5 by zrobić przelew\s
                0 by wrócić\s
                """);
        while (!Main.sc.hasNextInt()) {
            String input = Main.sc.next();
            System.out.println("niepoprawna liczba");
        }
        userInput = Main.sc.nextInt();

        switch (userInput) {
            case 1 -> {
                System.out.println("Podaj nazwę: ");
                String nazwa = Main.sc.next();
                System.out.println("Podaj pesel: ");
                while (!Main.sc.hasNextLong()) {
                    Main.sc.next();
                    System.out.println("niepoprawna liczba");
                }
                long pesel = Main.sc.nextLong();
                for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
                    if (obiektBazodanowy instanceof Klient) {
                        if (((Klient) obiektBazodanowy).getPesel() == pesel) {
                            System.out.println("Klient z tym peselem już istnieje");
                            return;
                        }
                    }
                }

                System.out.println("Podaj zdolnosc kredytową: ");
                while (!Main.sc.hasNextDouble()) {
                    Main.sc.next();
                    System.out.println("niepoprawna liczba");
                }
                double zdolnoscKredytowa = Main.sc.nextDouble();

                System.out.println("Podaj imie: ");
                String imie = Main.sc.next();
                System.out.println("Podaj nazwisko: ");
                String nazwisko = Main.sc.next();
                addToBazaDanych(new Klient(nazwa, pesel, zdolnoscKredytowa, imie, nazwisko));
            }
            case 2 -> {
                System.out.println("Podaj nazwę: ");
                String nazwa = Main.sc.next();
                System.out.println("Podaj pesel właściciela: ");
                while (!Main.sc.hasNextLong()) {
                    Main.sc.next();
                    System.out.println("niepoprawna liczba");
                }
                long pesel = Main.sc.nextLong();
                Klient wlasciciel = null;
                for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
                    if (obiektBazodanowy instanceof Klient) {
                        if (((Klient) obiektBazodanowy).getPesel() == pesel)
                            wlasciciel = (Klient) obiektBazodanowy;
                    }
                }
                if (wlasciciel == null) {
                    System.out.println("Nie istnieje taki klient: ");
                    break;
                }

                System.out.println("Podaj limit wyplaty: ");

                while (!Main.sc.hasNextDouble()) {
                    Main.sc.next();
                    System.out.println("niepoprawna liczba");
                }
                double limitWyplaty = Main.sc.nextDouble();
                addToBazaDanych(new Osobiste(nazwa, wlasciciel, limitWyplaty));
            }
            case 3 -> {
                System.out.println("Podaj nazwę: ");
                String nazwa = Main.sc.next();
                System.out.println("Podaj pesel właściciela: ");

                while (!Main.sc.hasNextLong()) {
                    Main.sc.next();
                    System.out.println("niepoprawna liczba");
                }
                long pesel = Main.sc.nextLong();
                Klient wlasciciel = null;
                for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
                    if (obiektBazodanowy instanceof Klient) {
                        if (((Klient) obiektBazodanowy).getPesel() == pesel)
                            wlasciciel = (Klient) obiektBazodanowy;
                    }
                }
                if (wlasciciel == null) {
                    System.out.println("Nie istnieje taki klient: ");
                    break;
                }

                System.out.println("Podaj procent: ");

                while (!Main.sc.hasNextFloat()) {
                    Main.sc.next();
                    System.out.println("niepoprawna liczba");
                }
                float procent = Main.sc.nextFloat();
                addToBazaDanych(new Oszczednosciowe(nazwa, wlasciciel, procent));
            }
            case 4 -> {
                System.out.println("Podaj nazwę: ");
                String nazwa = Main.sc.next();
                System.out.println("Podaj limit wyplaty: ");

                while (!Main.sc.hasNextLong()) {
                    Main.sc.next();
                    System.out.println("niepoprawna liczba");
                }
                long pesel = Main.sc.nextLong();
                Klient wlasciciel = null;
                for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
                    if (obiektBazodanowy instanceof Klient) {
                        if (((Klient) obiektBazodanowy).getPesel() == pesel)
                            wlasciciel = (Klient) obiektBazodanowy;
                    }
                }
                if (wlasciciel == null) {
                    System.out.println("Nie istnieje taki klient: ");
                    break;
                }

                System.out.println("Podaj procent: ");

                while (!Main.sc.hasNextFloat()) {
                    Main.sc.next();
                    System.out.println("niepoprawna liczba");
                }
                float procent = Main.sc.nextFloat();

                System.out.println("Podaj wartość kredytu: ");

                while (!Main.sc.hasNextDouble()) {
                    Main.sc.next();
                    System.out.println("niepoprawna liczba");
                }
                double wartoscKredytu = Main.sc.nextDouble();
                if (wartoscKredytu> wlasciciel.getZdolnoscKredytowa()){
                    System.out.println("Zbyt duża : ");
                    break;
                }

                System.out.println("Podaj ilość rat: ");

                while (!Main.sc.hasNextInt()) {
                    Main.sc.next();
                    System.out.println("niepoprawna liczba");
                }
                int iloscRat = Main.sc.nextInt();
                addToBazaDanych(new Kredytowe(nazwa, wlasciciel, procent, wartoscKredytu, iloscRat));
            }
            case 5 -> Menu.wyswietlWszystkie();
            default -> System.out.println("niepoprawny wybór");
        }

    }

    public static void usunObiekt() {
        int userInput;
        System.out.println("Podaj wybrany indeks: \n" +
                "-1 by wrócić \n");
        while (!Main.sc.hasNextInt()) {
            Main.sc.next();
            System.out.println("niepoprawna liczba");
        }
        userInput = Main.sc.nextInt();
        getBazaDanych().removeIf(obiekt -> obiekt.getIdentyfikator() == userInput);
    }

    public static void wyswietlWszystkie() {
        for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
            System.out.println(obiektBazodanowy);
        }
    }

    public static void wyswietlWybrane() {
        int userInput = 1;
        while (userInput != 0) {
            System.out.println("Wybierz: \n" +
                    "1 by wyświetlić Klientów \n" +
                    "2 by wyświetlić Przelewy \n" +
                    "3 by wyświetlić Konta \n" +
                    "4 by wyświetlić Konta osobiste  \n" +
                    "5 by wyświetlić Konta oszczędnościowe \n" +
                    "6 by wyświetlić Konta kredytowe \n" +
                    "0 by wrócić \n");
            while (!Main.sc.hasNextInt()) {
                Main.sc.next();
                System.out.println("niepoprawna liczba");
            }
            userInput = Main.sc.nextInt();
            switch (userInput) {
                case 1:
                    for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
                        if (obiektBazodanowy instanceof Klient) {
                            System.out.println(obiektBazodanowy);
                        }
                    }
                    break;
                case 2:
                    for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
                        if (obiektBazodanowy instanceof Przelew) {
                            System.out.println(obiektBazodanowy);
                        }
                    }

                    break;
                case 3:
                    for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
                        if (obiektBazodanowy instanceof Konto) {
                            System.out.println(obiektBazodanowy);
                        }
                    }
                    break;
                case 4:
                    for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
                        if (obiektBazodanowy instanceof Osobiste) {
                            System.out.println(obiektBazodanowy);
                        }
                    }
                    break;
                case 5:
                    for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
                        if (obiektBazodanowy instanceof Oszczednosciowe) {
                            System.out.println(obiektBazodanowy);
                        }
                    }
                    break;
                case 6:
                    for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
                        if (obiektBazodanowy instanceof Kredytowe) {
                            System.out.println(obiektBazodanowy);
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("niepoprawny wybór");
                    break;

            }

        }
    }

    public static void wyswietlPoNazwie() {
        System.out.println("Podaj fragment nazwy: \n");
        String userInput = "" + Main.sc.next();
        for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
            if (obiektBazodanowy.getNazwa().contains(userInput)) {
                System.out.println(obiektBazodanowy);
            }
        }
    }

    public static void wykonajPrzelew() {
        System.out.println("Podaj nazwę: \n");
        String nazwa = Main.sc.next();
        System.out.println("Podaj kwotę: \n");
        while (!Main.sc.hasNextDouble()) {
            Main.sc.next();
            System.out.println("niepoprawna liczba");
        }
        double kwota = Main.sc.nextDouble();
        System.out.println("Podaj konto z którego wykonasz przelew (-1 to wpłata): \n");
        while (!Main.sc.hasNextLong()) {
            Main.sc.next();
            System.out.println("niepoprawna liczba");
        }
        long idKontaOut = Main.sc.nextLong();
        Konto kontoOut = null;
        if (idKontaOut != -1) {

            for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
                if (obiektBazodanowy instanceof przelewalne && obiektBazodanowy.getIdentyfikator() == idKontaOut) {
                    kontoOut = (Konto) obiektBazodanowy;
                }
            }
            if (kontoOut == null) {
                System.out.println("Nie istnieje takie konto: \n");
                return;
            }

            if (kontoOut instanceof Kredytowe) {

                System.out.println("Nie można przelewać z konta kredytowego: \n");
                return;
            }

            if (kontoOut.getStanKonta() < kwota) {

                System.out.println("Nie posiadasz wystarczających środków: \n");
                return;
            }
        }
        System.out.println("Podaj id konta docelowego: \n");
        while (!Main.sc.hasNextLong()) {
            Main.sc.next();
            System.out.println("niepoprawna liczba");
        }
        long idKontaIn = Main.sc.nextLong();
        Konto kontoIn = null;
        for (ObiektBazodanowy obiektBazodanowy : getBazaDanych()) {
            if (obiektBazodanowy instanceof Konto && obiektBazodanowy.getIdentyfikator() == idKontaIn) {
                kontoIn = (Konto) obiektBazodanowy;
            }
        }

        if (kontoIn == null) {
            System.out.println("Nie istnieje takie konto: \n");
            return;
        }

        addToBazaDanych(new Przelew(nazwa, kwota, kontoOut, kontoIn));


    }

}
