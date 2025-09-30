package school.vehicle;

public class BenzinFahrzeug1 extends Fahrzeug1 {

        BenzinFahrzeug1(String typ, double verbrauch) {
            super(typ + "-Benzinfahrzeug", verbrauch);
        }

        public double getVerbrauch() {
            return verbrauch;
        }

        public String getTyp() {
            return getType();
        }
        public double berechneFahrtkosten(double km) {
            return getVerbrauch() / 100 * km * Fahrzeug1.getBenzinpreis();
        }
    }