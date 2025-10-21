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
       stunden = new ArrayList<>();
       this.fastLane = false;
    }
// in die Testklasse reinschauen, wie das implementiert wird
   // install Eclipse, um das zu lernen
    public boolean eintragen(Fahrstunde neu) {
       int anzStandard = 0;
       int anzSonder = 0;
       double preisStandard = 0;
       double preisSonder = 0;

        for(Fahrstunde f : stunden) {
            if(f.getTyp() == StandardFahrt.TYP) {
                anzStandard += f.getAnzahl();
                preisStandard += f.berechnePreis();
            } else {

            }
        }

    }

    public ausgabenStatus() {

    }

    public void setFastLane(boolean fastLane) {
        this.fastLane = fastLane;
    }

    public boolean isFastLane() {
        return fastLane;
    }
}
