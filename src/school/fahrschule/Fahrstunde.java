package school.fahrschule;

import java.util.Calendar;

public abstract class Fahrstunde {
    private long datum;
    protected int anzahl;
    private boolean fastLane = false;

    public Fahrstunde (int anzahl) {
        if (anzahl < 1 || anzahl > 3) {
            this.anzahl = 2;
        } else {
            this.anzahl = anzahl;
        }
    }

    public Fahrstunde(long datum, int anzahl) {
        this(anzahl);
        this.datum = berechneDatum(datum);
    }

    public void setFastLane() {
       fastLane = true;
    }


	// Hilfsfunktion zum bestimmen des aktuellen Datum als Zahl
	// im Format yyyymmdd
	public static long berechneDatum(long datum) {
		Calendar ziel = Calendar.getInstance();
		int y = ziel.get(Calendar.YEAR);
		int m = ziel.get(Calendar.MONTH);
		int d = ziel.get(Calendar.DAY_OF_MONTH);
		long date = y * 10000 + (m + 1) * 100 + d;

		return date;
	}

}
