
import java.util.Calendar;

public class Fahrstunde { 
	
	// TODO Ergänzen sie die Klasse Fahrstunde anhand der Aufgabenstellung
	
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
