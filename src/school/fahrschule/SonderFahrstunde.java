package school.fahrschule;

public class SonderFahrstunde extends Fahrstunde{

    @Override
    public int getTyp() {
        return 0;
    }

    @Override
    public String getTypName() {
        return "";
    }

    @Override
    public double berechnePreis() {
        return 0;
    }
}
