package a6;

import java.io.*;

class Mitarbeiter {
	private String name;
	private int pnr;
	private double gehalt;

	public Mitarbeiter(String name, int pnr, double gehalt) {
		super();
		this.name = name;
		this.pnr = pnr;
		this.gehalt = gehalt;
	}

	public String getName() {
		return name;
	}

	public int getPnr() {
		return pnr;
	}

	public double getGehalt() {
		return gehalt;
	}

	public void print() {
		System.out.println(name + "|" + pnr + "|" + gehalt);
	}
}

public class DataStorage {

	public static void main(String[] args) throws IOException {

		Mitarbeiter[] mList = { new Mitarbeiter("Maier", 815, 1700.0),
								new Mitarbeiter("Dagobert Duck", 101, 4800000.0),
								new Mitarbeiter("Bond", 7, 70000.0) };
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			out = new DataOutputStream(
						new BufferedOutputStream(
								new FileOutputStream("Mitarbeiter.data")));
			// Anzahl Mitarbeiter schreiben
			out.writeInt(mList.length);
			// einzelne Attribute binär schreiben
			for (Mitarbeiter m : mList) {
				out.writeUTF(m.getName());
				out.writeInt(m.getPnr());
				out.writeDouble(m.getGehalt());
			}
			out.close();

			// Array leermachen
			mList = null;

			// Dateneingabestrom mit Pufferung aus Datei erzeugen
			in = new DataInputStream(
						new BufferedInputStream(
								new FileInputStream("Mitarbeiter.data")));

			// Anzahl gespeicherter Mitarbeiter lesen
			int anzahl = in.readInt();

			// Neues Array der benoetigten Groesse erzeugen
			mList = new Mitarbeiter[anzahl];

			// Attribute wieder einlesen und damit Objekte erzeugen
			for (int i = 0; i < anzahl; i++) {
				String name = in.readUTF();
				int pnr = in.readInt();
				double gehalt = in.readDouble();
				// Neues Mitarbeiterobjekt mit gelesenen Daten erzeugen
				mList[i] = new Mitarbeiter(name, pnr, gehalt);
			}
			// Alles wieder ausgeben
			for (Mitarbeiter m : mList) {
				m.print();
			}
		} finally {
			if (out != null)
				out.close();
			if (in != null)
				in.close();
		}
	}
}
