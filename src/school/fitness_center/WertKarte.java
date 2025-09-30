package school.fitness_center;

public class WertKarte {
    private double guthaben = 50;
    private double kostenSauna = 10.0;

    public WertKarte() {
        // empty / no-argument constructor
    }

    public WertKarte(double guthaben) {
        this.guthaben = guthaben;
    }

    public double getGuthaben() {

        return guthaben;
    }

    public double aufladen(double betrag) {
        guthaben += betrag;

        return guthaben;
    }

    public double abbuchenSauna() {
        if (guthaben < kostenSauna) {

            return 0.0;
        }

        return abbuchen(kostenSauna);
    }

    private double abbuchen(double betrag) {
        if (guthaben < betrag) {
            return 0.0;
        }

        guthaben -= betrag;

        return guthaben;
    }

}
