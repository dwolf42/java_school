package school.fitness_center;

public class Kunde {
    private String id;
    private String name;
    private double gewicht;
    private double groesse;

    public Kunde(String id, String name, double gewicht, double groesse) {
        super();
        this.id = id;
        this.name = name;
        this.gewicht = gewicht;
        this.groesse = groesse;
    }

    public Kunde(String id, String name) {
        this(id, name, 0, 0);
    }

    public double berechneBMI() {
        if (groesse != 0.0 && gewicht != 0.0) {
            return Math.pow(gewicht / groesse, 2);
        }
        return -1.0;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGroesse(double groesse) {
        this.groesse = groesse;
    }

    public double getGroesse() {
        return groesse;
    }
}
