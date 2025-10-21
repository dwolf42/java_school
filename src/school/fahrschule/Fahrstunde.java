package school.fahrschule;

import java.util.Calendar;

public abstract class Fahrstunde {
    private long datum;
    protected int anzahl;
    private boolean fastLane;

    public Fahrstunde(long datum, int anzahl) {
        if (anzahl < 1 || anzahl > 3) {
            this.anzahl = 2;
        } else {
            this.anzahl = anzahl;
        }
        this.datum = datum;
        this.fastLane = false;

    }

    public Fahrstunde(int anzahl) {
        this(berechneDatum(), anzahl);
    }

    public void ausgeben() {
        System.out.print("Datum: " + datum + ", " + "Typ: " + getTypName() + ", " + "Anzahl: " + anzahl);
        if (fastLane) {
            System.out.print(", " + "fast lane");
        }
        System.out.println();
    }

    public abstract int getTyp();

    public abstract String getTypName();

    public abstract double berechnePreis();

    public void setFastLane() {
        this.fastLane = true;

    }

    public boolean isFastLane() {
        return fastLane;
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

}
