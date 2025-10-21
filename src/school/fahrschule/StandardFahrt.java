package school.fahrschule;

public class StandardFahrt extends Fahrstunde {

    public static final int TYP = 0;

    public StandardFahrt(long datum, int anzahl) {
        super(datum, anzahl);
    }

    public StandardFahrt(int anzahl) {
        super(anzahl);
    }

    @Override
    public int getTyp() {
        return TYP;
    }

    @Override
    public String getTypName() {
        return "";
    }

    @Override
    public double berechnePreis() {
        return 0; // berechne bei Sonder mit 90% Aufschlag = * 1.90;
    }
}
