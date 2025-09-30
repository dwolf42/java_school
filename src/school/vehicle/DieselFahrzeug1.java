package school.vehicle;

public class DieselFahrzeug1 extends Fahrzeug1 {

    DieselFahrzeug1(String typ, double verbrauch) {
       super(typ + "-Dieselmotor", verbrauch);
    }

    public double getVerbrauch() {
        return verbrauch;
    }

    public String getTyp() {
        return getType();
    }
    public double berechneFahrtkosten(double km) {
        return getVerbrauch() / 100 * km * Fahrzeug1.getDieselpreis();
    }
}
