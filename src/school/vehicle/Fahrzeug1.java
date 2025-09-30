package school.vehicle;

public class Fahrzeug1 {

    // a) Attributes
    private static double benzinpreis;
    private static double dieselpreis;
    protected String fahrzeugTyp;
    protected double verbrauch;

    // a) Constructor
    public Fahrzeug1(String fahrzeugTyp, double verbrauch) {
        this.fahrzeugTyp = fahrzeugTyp;
        this.verbrauch = verbrauch;
    }

    // b) Getter / Setter methods
    public static double getBenzinpreis() {
        return benzinpreis;
    }

    public static void setBenzinpreis(double benzinpreis) {
        Fahrzeug1.benzinpreis = benzinpreis;
    }

    // c) Getter only, as changing is now allowed
    public String getType() {
        return fahrzeugTyp;
    }

    public double getVerbrauch() {
        return verbrauch;
    }

    // d) Calculate Fahrtkosten
    public double berechneFahrtkosten(double km) {
        return getVerbrauch() / 100 * km * getBenzinpreis();
    }

    public static double getDieselpreis() {
        return dieselpreis;
    }

    public static void setDieselpreis(double dieselpreis) {
        Fahrzeug1.dieselpreis = dieselpreis;
    }


}
