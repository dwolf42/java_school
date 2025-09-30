package school.abstract_geoform;

public abstract class GeoForm {
    public abstract double getUmfang();

    public abstract double getFlaeche();

    public abstract String getTyp();

    public void showInfo() {
        System.out.println("Ich bin ein Objekt vom Typ" + this.getTyp());
        System.out.println("Mein Umfang: " + this.getUmfang() + "Fläche: " + this.getFlaeche());
    }
}
