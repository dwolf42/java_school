package school.fitness_center;

public class FitnessCenter {
    private String name;
    private Kunde[] kunden;

    public FitnessCenter(String name) {
        super();
        this.name = name;
        kunden = new Kunde[10];
    }

    public Kunde neuerKunde(String id, String name, double gewicht, double groesse) {
        for (int i = 0; i < kunden.length; i++) {
            if (kunden[i] == null) {
                kunden[i] = new Kunde(id, name, gewicht, groesse);
                return kunden[i]; // gibt den einen Kunden an diesem Index zurück
            }
        }

        return null;
    }

    public Kunde neuerKunde(String id, String name) {
        return neuerKunde(id, name, 0.0, 0.0); // man kann auf den anderen Konstruktor zugreifen
    }

    public Kunde loescheKunde(String id) {
        return null;
    }

    public void print() {
        for (Kunde kund : kunden) {
            System.out.println(kund);
        }
    }
}
