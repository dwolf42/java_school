package school.abstract_geoform;

public class Rechteck extends GeoForm {
    protected double breite;

    protected double hoehe;

    public Rechteck(double breite, double hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;
    }

    public double getUmfang() {
        return 2 * (breite + hoehe);
    }

    public double getFlaeche() {
        return breite * hoehe;
    }

    public String getTyp() {
        return "Rechteck";
    }
}
