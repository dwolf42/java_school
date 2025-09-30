package school.vehicle;

import java.util.ArrayList;

public class TestFahrzeug {

	public static void main(String[] args) {
		// Object creation of class Fahrzeug
		Fahrzeug1 golf = new Fahrzeug1("VW-Golf", 6.5);
		Fahrzeug1 scudo = new Fahrzeug1("FIAT Scudo", 8.3);

		// Fuel price set to 1,5€
		Fahrzeug1.setBenzinpreis(1.5);

		// Diesel price set to 2,0€
		Fahrzeug1.setDieselpreis(2.0);

		BenzinFahrzeug1 golfBenzin = new BenzinFahrzeug1("VW-Golf", 6.5);
		DieselFahrzeug1 golfDiesel = new DieselFahrzeug1("VW-Golf", 4.9);
		DieselFahrzeug1 scudoDiesel = new DieselFahrzeug1("FIAT-Scudo", 8.3);

		// Benzinpreis == 1,5€, Dieselpreis == 1.0€
		Fahrzeug1.setBenzinpreis(1.5);
		Fahrzeug1.setDieselpreis(1.0);
		System.out.println("Fahrtkosten Golf Benzin " + golfBenzin.berechneFahrtkosten(100) + " €");
		System.out.println("Fahrtkosten Golf Diesel " + golfDiesel.berechneFahrtkosten(100) + " €");
		System.out.println("Fahrtkosten Scudo Benzin " + scudoDiesel.berechneFahrtkosten(100) + " €");

		// Benzinpreis == 2.0€, Dieselpreis == 1.5€
		Fahrzeug1.setBenzinpreis(2.0);
		Fahrzeug1.setDieselpreis(1.5);
		System.out.println("Fahrtkosten Golf Benzin " + golfBenzin.berechneFahrtkosten(100) + " €");
		System.out.println("Fahrtkosten Golf Diesel " + golfDiesel.berechneFahrtkosten(100) + " €");
		System.out.println("Fahrtkosten Scudo Benzin " + scudoDiesel.berechneFahrtkosten(100) + " €");

		System.out.println(" ");
		System.out.println(" ");

		// Array List of Fahrzeug

		ArrayList<Fahrzeug1> fahrzeuge = new ArrayList<>();
		fahrzeuge.add(new BenzinFahrzeug1("BMW-5er", 8.6));
		fahrzeuge.add(new BenzinFahrzeug1("VW-Scirocco", 10.8));
		fahrzeuge.add(new DieselFahrzeug1("Audi-A6", 5.5));
		fahrzeuge.add(new DieselFahrzeug1("Opel-Astra", 4.9));

		for (Fahrzeug1 fahrzeug1 : fahrzeuge) {
			System.out.println("Fahrkosten für " + fahrzeug1.getType() + " betragen " + fahrzeug1.berechneFahrtkosten(100) + " €");
		}
	}

}
