

public class Fuehrerschein {

	public static void main(String[] args) {
		
		
		FahrSchueler fahrschueler = new FahrSchueler( "Fritz", 120.0);
		
		fahrschueler.eintragen( new StandardFahrt(20180105, 2) );
		fahrschueler.eintragen( new StandardFahrt(20180110, 2) );
		fahrschueler.eintragen( new StandardFahrt(20180211, 2) );
		fahrschueler.eintragen( new StandardFahrt(20180217, 2) );
		fahrschueler.eintragen( new StandardFahrt(20180318, 2) );
		fahrschueler.eintragen( new StandardFahrt(20180420, 2) );
		fahrschueler.eintragen( new StandardFahrt(20180425, 2) );

		fahrschueler.ausgebenStatus();
//		Erwartete Ausgabe:
//		
//		Name: Fritz
//		Grundgebühr: 120.0
//		20180105: Standard-Fahrt Stunden 2
//		20180110: Standard-Fahrt Stunden 2
//		20180211: Standard-Fahrt Stunden 2
//		20180217: Standard-Fahrt Stunden 2
//		20180318: Standard-Fahrt Stunden 2
//		20180420: Standard-Fahrt Stunden 2
//		20180425: Standard-Fahrt Stunden 2
//		Anzahl Standard-Fahrten: 14 Preis: 378.0
//		Anzahl Sonder-Fahrten: 0 Preis: 0.0
//		Gesamtpreis: 498.0
//		Mindeststundenzahl noch nicht erreicht.

		System.out.println("-----------------------------");

		fahrschueler.eintragen( new StandardFahrt(20180502, 2) );
		// Umschalten auf Turbo-Tarif
		fahrschueler.setFastLane(true);
		fahrschueler.eintragen( new StandardFahrt(20180507, 2) );
		fahrschueler.eintragen( new StandardFahrt(20180510, 2) );
		fahrschueler.eintragen( new StandardFahrt(20180511, 2) );
		fahrschueler.eintragen( new SonderFahrt(20180514, 2) );
		fahrschueler.eintragen( new SonderFahrt(20180520, 2) );
		fahrschueler.eintragen( new SonderFahrt(20180524, 3) );
		fahrschueler.eintragen( new SonderFahrt(20180525, 2) );
		fahrschueler.eintragen( new SonderFahrt(20180601, 2) );
		fahrschueler.eintragen( new StandardFahrt(2) );
		fahrschueler.eintragen( new SonderFahrt(1) );
		
		fahrschueler.ausgebenStatus();
//		Erwartete Ausgabe:
//		
//		Name: Fritz
//		Grundgebühr: 195.0
//		20180105: Standard-Fahrt Stunden 2
//		20180110: Standard-Fahrt Stunden 2
//		20180211: Standard-Fahrt Stunden 2
//		20180217: Standard-Fahrt Stunden 2
//		20180318: Standard-Fahrt Stunden 2
//		20180420: Standard-Fahrt Stunden 2
//		20180425: Standard-Fahrt Stunden 2
//		20180502: Standard-Fahrt Stunden 2
//		20180507: Standard-Fahrt Stunden 2 fast lane
//		20180510: Standard-Fahrt Stunden 2 fast lane
//		20180511: Standard-Fahrt Stunden 2 fast lane
//		20180514: Sonder-Fahrt Stunden 2 fast lane
//		20180520: Sonder-Fahrt Stunden 2 fast lane
//		20180524: Sonder-Fahrt Stunden 3 fast lane
//		20180525: Sonder-Fahrt Stunden 2 fast lane
//		20180601: Sonder-Fahrt Stunden 2 fast lane
//		20180620: Standard-Fahrt Stunden 2 fast lane
//		20180620: Sonder-Fahrt Stunden 1 fast lane
//		Anzahl Standard-Fahrten: 24 Preis: 832.0
//		Anzahl Sonder-Fahrten: 12 Preis: 706.7999999999998
//		Gesamtpreis: 1733.7999999999997
//		Mindeststundenanzahlen erreicht. Viel Erfolg bei der Prüfung
//		
		
		
	}

}
