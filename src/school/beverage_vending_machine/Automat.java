package school.beverage_vending_machine;

import java.util.ArrayList;
import java.util.Scanner;

public class Automat {
    private ArrayList<Schacht> schaechte = new ArrayList<>();
    String name;
    double preis;
    int maxAnzahl;
    int anzahl;
    int menuPunkt;

    public void runAutomat() {
        while (true) {
            System.out.println("Mit diesem Programm können Sie einen Gertränkeschacht verwalten.");
            System.out.println("Was möchten Sie tun?");
            System.out.println("  1  Neuen Schacht anlegen");
            System.out.println("  2  Schächte verwalten");
            System.out.println("  3  Etwas kaufen");
            menuPunkt = new Scanner(System.in).nextInt();

            switch (menuPunkt) {
                case 1:
                    neuerSchacht();
                    break;
                case 2:
                    schaechteVerwalten();
                    break;
                case 3:
                    kaufen();
                default:
                    System.out.println("Ungültige Eingabe");
            }
        }
    }

    // Objekt Schacht erzeugen
    private void neuerSchacht() {
        // Name
        System.out.println("Welches Getränk soll in dem Schacht angeboten werden?");
        name = new Scanner(System.in).nextLine();

        // Preis
        do {
            System.out.println("Welchen Preis soll eine Flasche" + name + " kosten?");
            preis = new Scanner(System.in).nextDouble();
        } while (preis <= 0);

        // Max Anzahl
        do {
            System.out.println("Wie hoch ist die maximale Anzahl " + name + " im Schacht?");
            maxAnzahl = new Scanner(System.in).nextInt();
        } while (maxAnzahl <= 0);

        // Anzahl
        do {
            System.out.println("Wie viel Stück von " + name + " sollen in den Schacht gefüllt werden?");
            anzahl = new Scanner(System.in).nextInt();
        } while (anzahl > maxAnzahl || anzahl <= 0);

        schaechte.add(new Schacht(name, preis, anzahl, maxAnzahl));
    }

    public void changeName(String name) {
        if (this.anzahl != 0) {
            throw new Error("Der Schacht ist nicht leer.");
        } else {
            this.name = name;
        }
    }

    private void schaechteVerwalten() {
        System.out.println("Welcher Schacht soll verwaltet werden?");
        for (int i = 0; i < schaechte.size(); i++) {
            System.out.println("Schacht " + i + 1 + schaechte.get(i).getName());
        }
        System.out.println("Ihre Eingabe: ");
        int zuVerwaltenderSchacht = new Scanner(System.in).nextInt();

        System.out.println("Was möchten Sie tun?");
        System.out.println("  1  Auffüllen");
        System.out.println("  2  Preis ändern");
        System.out.println("  3  Name ändern");
        System.out.println("  4  Maximale Anzahl ändern");
        menuPunkt = new Scanner(System.in).nextInt();

        switch (menuPunkt) {
            // Auffüllen
            case 1:
                System.out.println("Aktueller Füllstand: "
                        + schaechte.get(zuVerwaltenderSchacht).getAnzahl());
                System.out.println("Maximale Anzahl: "
                        + schaechte.get(zuVerwaltenderSchacht).getMaxAnzahl());
                System.out.println("");

                System.out.println("Wie viele Flaschen möchten Sie auffüllen?");
                while (true) {
                    try {
                        schaechte.get(zuVerwaltenderSchacht).setAnzahl(new Scanner(System.in).nextInt());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                break;
            // Preis ändern
            case 2:
                System.out.println("Aktueller Preis: "
                        + schaechte.get(zuVerwaltenderSchacht).getPreis());
                System.out.println("Geben Sie den Preis ein: ");
                schaechte.get(zuVerwaltenderSchacht).setPreis(new Scanner(System.in).nextDouble());
                break;
            // Name ändern
            case 3:
                System.out.println("Geben Sie einen neuen Namen ein: ");
                try {
                    schaechte.get(zuVerwaltenderSchacht).setName(new Scanner(System.in).nextLine());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            // Maximale Anzahl ändern
            case 4:
                System.out.println("Geben Sie die maximale Anzahl ein: ");
                schaechte.get(zuVerwaltenderSchacht).setMaxAnzahl(new Scanner(System.in).nextInt());
                break;
            default:
                System.out.println("Gehe zurück.");
                break;
        }
    }

    public void kaufen() {

    }
}
