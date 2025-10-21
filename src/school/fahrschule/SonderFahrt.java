package school.fahrschule;

public class SonderFahrt extends Fahrstunde{
    public static int TYP = 1;
    public static String TYP_NAME = "Sonder";
    private double preis = 31.0;

    public SonderFahrt(long datum, int anzahl) {
        super(datum, anzahl);
    }

    public SonderFahrt(int anzahl) {
        super(anzahl);
    }

    @Override
    public int getTyp() {
        return TYP;
    }

    @Override
    public String getTypName() {
        return TYP_NAME;
    }

    @Override
    public double berechnePreis() {
        if (super.isFastLane()) {
            return super.anzahl * (preis * 1.90);
        }
        return super.anzahl * preis;
    }
}
