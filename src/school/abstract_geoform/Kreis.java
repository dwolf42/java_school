package school.abstract_geoform;

public class Kreis extends GeoForm {
    protected double radius;

    public Kreis(double radius) {
        this.radius = radius;
    }

    @Override
    public String getTyp() {
        return "Kreis";
    }

    @Override
    public double getUmfang() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getFlaeche() {
       return Math.PI * Math.pow(radius, 2);
    }

}
