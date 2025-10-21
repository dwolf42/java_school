package school.fahrschule;

import java.util.ArrayList;

public class FahrSchueler {
    private String name;
    private double gebuehr;
    private boolean fastLane;
    private ArrayList<Fahrstunde> stunden;

    public FahrSchueler(String name, double gebuehr) {
       this.name = name;
       this.gebuehr = gebuehr;
    }

    public boolean eintragen(Fahrstunde neu) {

    }

    public ausgabenStatus() {

    }

    public void setFastLane(boolean fastLane) {
        this.fastLane = fastLane;
        this.gebuehr += 75;
    }

    public boolean isFastLane() {
        return fastLane;
    }
}
