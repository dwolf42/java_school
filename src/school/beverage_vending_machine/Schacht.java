package school.beverage_vending_machine;

public class Schacht {
    private String name;
    private double preis;
    private int anzahl;
    private int maxAnzahl;

    public Schacht(String name, double preis, int anzahl, int maxAnzahl) {
        this.name = name;
        this.preis = preis;
        this.anzahl = anzahl;
        this.maxAnzahl = maxAnzahl;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        if (this.anzahl + anzahl > this.maxAnzahl) {
            throw new Error("Füllmenge passt nicht in den Schacht");
        } else {
            this.anzahl += anzahl;
        }
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        if (this.anzahl != 0) {
            throw new Error("Der Schacht ist nicht leer");
        } else {
            this.name = name;
        }
    }

    public void setMaxAnzahl(int maxAnzahl) {
        this.maxAnzahl = maxAnzahl;
    }

    public int getMaxAnzahl() {
        return maxAnzahl;
    }

    public boolean rausnehmen() {
        if (this.anzahl > 0) {
            this.anzahl--;
            return true;
        } else {
            return false;
        }
    }

    public void auffuellen(int anzahl) {
        this.anzahl -= anzahl;
    }
}
