package school.abstract_geoform;

import java.util.Scanner;

public class TestAbstract {
	private final static int MAX = 10;
	
	// Array aller geometrischen Figuren
	private GeoForm[] figuren = new GeoForm[MAX];
	
	// Array von Hilfsobjekten zur Erzeugung der unterschiedlichen Figur-Typen
	private GeoFormCreator[] creator = {   new RechteckCreator("Rechteck"),
			                               new KreisCreator("Kreis")
									   };
	
	// Ausgeben aller Figuren des figuren-Arrays
	private void ausgebenFiguren() {
		// HINWEIS: an dieser Methode sieht man den Vorteil von abstrakten Klassen:
		// Diese Methode aendert sich nicht bei neuen GeoForm-Unterklassen, da hier nur 
		// mit GeoForm-Referenzen und den abstrakten Methoden der Klasse GeoForm gearbeitet
		// wird. Tatsaechlich verbergen sich dann konkrete Kreis-, Rechteck-,... Objekte
		// hinter den GeoForm-Referenzen!
		System.out.println();
		System.out.println("Die gespeicherten Figuren:");
		for (int i = 0; i < figuren.length; i++) {
			if (figuren[i] != null) {
				System.out.println("Nummer: " + i + " " + "Typ:    "
						+ figuren[i].getTyp());
				System.out.println("Fläche: " + figuren[i].getFlaeche());
				System.out.println("Umfang: " + figuren[i].getUmfang());
			}
		}
	}

	private void neueFigurEinfuegen() {
		GeoForm geo = null;
		System.out.println("Welchen Typ soll die neue Figur haben");
		// moegliche GeoForm-Typen ausgeben:
		for (int i = 0; i < creator.length; i++) {
			System.out.println("  " + creator[i].getTyp());
		}
		Scanner ein = new Scanner(System.in);
		String auswahl = ein.nextLine();
		// zugehoerigen Creator suchen und Objekt erzeugen
		for (int i = 0; i < creator.length; i++) {
			if (auswahl.equalsIgnoreCase(creator[i].getTyp())) {
				// Figur erzeugen
				geo = creator[i].create();
				// Figur an erste freie Stelle in figuren-Array einfuegen
				for (int j = 0; j < figuren.length; j++) {
					if (figuren[j] == null) {
						figuren[j] = geo;
						return;
					}
				}
			}
		}
		System.out.println("Fehler: unegueltiger Figurtyp oder Array voll");

	}

	public void loeschenFigur() {
		int nr;
		Scanner ein = new Scanner(System.in);
		System.out.println("Geben Sie die Nummer der zu löschenden Figur ein");
		nr = ein.nextInt();
		if (nr >= 0 && nr < figuren.length && figuren[nr] != null)
			figuren[nr] = null;
	}

	public void run() {

		char auswahl = 'e';
		Scanner ein = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("Mit diesem Programm können Sie ");
			System.out.println("Geometrische Figuren verwalten");
			System.out.println("Wählen Sie:");
			System.out.println("  a  ausgeben aller Figuren");
			System.out.println("  n  neue Figur einfügen");
			System.out.println("  l  eine Figur löschen");
			System.out.println("  e  das Programm beenden ");

			auswahl = ein.nextLine().toLowerCase().charAt(0);
			switch (auswahl) {
			case 'a':
				ausgebenFiguren();
				break;
			case 'n':
				neueFigurEinfuegen();
				break;
			case 'l':
				loeschenFigur();
				break;
			}
		} while (auswahl != 'e');
		ein.close();
	}

	public static void main(String[] args) {
		TestAbstract ta = new TestAbstract();
		ta.run();
	}
}
