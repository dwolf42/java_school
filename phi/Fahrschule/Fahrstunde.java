package school.repeat_exercise.Fahrschule;

import java.util.Calendar;

public class Fahrstunde {
    private long datum;
    protected int anzahl;
    private boolean fastLane;

    public Fahrstunde(long datum, int anzahl) {
        this.datum = berechneDatum(datum);
        this(anzahl);
    }

    public Fahrstunde(int anzahl) {
        if (anzahl < 1 || anzahl > 3) {
            this.anzahl = 2;
        }

        this.anzahl = anzahL;
    }

    public void ausgeben() {

    }


    // Hilfsfunktion zum bestimmen des aktuellen Datum als Zahl
    // im Format yyyymmdd
    public static long berechneDatum() {
        Calendar ziel = Calendar.getInstance();
        int y = ziel.get(Calendar.YEAR);
        int m = ziel.get(Calendar.MONTH);
        int d = ziel.get(Calendar.DAY_OF_MONTH);
        long date = y * 10000 + (m + 1) * 100 + d;

        return date;
    }

    public long getDatum() {
        return datum;
    }

    public void setDatum(long datum) {
        this.datum = datum;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public void setFastLane(boolean fastLane) {
        this.fastLane = fastLane;
    }
}
