package school.threads.Wetterclient;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;
import java.net.*;

public class WetterClient extends Frame {

	// feste Regionnamen
	static private String[] region = {"NordWest", "Nord", "NordOst", "West", "Mitte", "Ost", "SuedWest", "Sued",
		"SuedOst"};

	// TODO Anlegen einer HashMap fuer die Zuordnung der Region-Namen
	// zu den Label-Objekten, die die jeweiligen Werte anzeigen sollen
	Map<String, Label> regionLabelMap = new HashMap<>();

	// Statuszeile oben
	private Label status;

	private Socket toServer = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private PrintWriter logger = null;
	private WetterUpdate updateReceiver = null;

	// TODO 
	// Hier innere UpdateThread-Klasse einfuegen
	// Die Klasse soll asynchrone Update-Nachrichten vom Server empfangen und in der GUI anzeigen
	class WetterUpdate extends Thread {
		@Override
		public void run() {
			String line;
			String[] splitted;

			try {
				while (!currentThread().isInterrupted() &&
					(line = in.readLine()) != null &&
					!line.equals("<END_INIT>") &&
					!line.equals("<END_UPDATE>")) {
					splitted = line.split(":");
					regionLabelMap.get(splitted[0].trim()).setText(splitted[1].trim() + "°C");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("WetterUpdate-Thread endet");
		}
	}

	// Komstruktor Aufbau der GUI
	public WetterClient(String host, int portnummer) {
		super("WetterClient");
		// Statuszeile oben
		status = new Label("Status");
		add(status, BorderLayout.NORTH);

		// Panel mit 9 Labels erzeugen, um die Temperaturen der einzelnen 
		// Regionen darzustellen
		Panel wetterkarte = new Panel(new GridLayout(3, 3));
		for (String r : region) {
			Label label = new Label("0,0");
			wetterkarte.add(label);

			// TODO Zuordnung von Label und Region in HashMap speichern
			regionLabelMap.put(r, label);
		}
		add(wetterkarte);

		// Bedienbuttons unten anlegen
		Panel action = new Panel();
		Button btnInit = new Button("Initialisieren");
		Button btnUpdStart = new Button("Update starten");
		Button btnUpdEnd = new Button("Update beenden");
		action.add(btnInit);
		action.add(btnUpdStart);
		action.add(btnUpdEnd);
		add(action, BorderLayout.SOUTH);
		// Buttons mit Verarbeitungsmethoden verbinden
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initialize();
			}
		});
		btnUpdStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateStart();
			}
		});
		btnUpdEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateEnd();
			}
		});

		// Bearbeitung Fenster-Close-Button
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
				dispose();
			}
		});
		// Verbindungsaufbau versuchen
		if (connect(host, portnummer)) {
			status.setText("Verbindung erfolgreich! Weiter mit 'Initialisieren'...");
		} else {
			status.setText("Verbindung fehlgeschlagen");
		}
		// Fenster anzeigen
		pack();
		setVisible(true);
	}

	public boolean connect(String host, int portnummer) {
		// TODO
		// - Verbindungsaufbau zum Server
		// - Initialisierung aller Reader/Writer-Objekte
		// - Rueckgabe true bei erfolgreicher Verbindung

		try {
			toServer = new Socket(host, portnummer);
			// Der Buffered Reader liest Strings, braucht daher etwas,
			// um den Stream vom Server zu lesen, also new InputStreamReader
			in = new BufferedReader(new InputStreamReader(toServer.getInputStream())); // kommt vom Server
			// Der PrintWriter schreibt auf den Output vom Socket
			out = new PrintWriter(toServer.getOutputStream(), true); // schreibe ich an den Sever
			logger = new PrintWriter(toServer.getOutputStream(), true); // TODO: Logger überarbeiten
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void initialize() {
		// TODO
		// - evtl. Update-Modus beenden
		// - Senden <INIT> an Server
		// - enpfang der Init-Werte mit receiveInitValues
		updateEnd();
		status.setText("Neu initialisieren");
		out.println("<INIT>");
		receiveInitValues();
		status.setText("Normal Modus");
	}

	public void receiveInitValues() {
		// TODO
		// - Empfang aller INIT-Nachrichten vom Server
		//   bis "<END_INIT>" gesendet wird.
		// - Zuordnung und Anzeige der empfangenen Werte
		//   in den Region-Labels
		//   mit 'setText(String text)' kann bei Labels ein neuer Text gesetzt werden
		String line;
		String[] splitted;
		try {
			while ((line = in.readLine()) != null &&
				!line.equals("<END_INIT>")) {
				splitted = line.split(":");
				regionLabelMap.get(splitted[0].trim()).setText(splitted[1].trim() + "°C");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateStart() {
		// TODO
		// Einschalten Update-Modus, sofern nicht schon Update-Modus aktiv
		// Es muss ein eigener Thread zum Empfang
		// von Update-Zeilen erzeugt und gestartet werden.
		// Damit der WetterServer mit dem Versand von Aktualisierungen beginnt,
		// muss das Kommando "<UPDATE>" als eine Textzeile an den Server
		// gesendet werden.
		if (updateReceiver == null) {
			status.setText("Update Modus");
			updateReceiver = new WetterUpdate();
			updateReceiver.start();
			out.println("<UPDATE>");
		}
	}

	public void updateEnd() {
		// TODO
		// Ausschalten Update-Modus (einschalten Normalmodus), wenn Update-Modus
		// aktiv:
		// Senden Kommando "<END UPDATE>" an Server.
		// Der bestehende Update-Thread muss benachrichtigt werden, so dass er
		// sich sauber selbst beendet.
		if (updateReceiver != null) {
			status.setText("Normal Modus");
			out.println("<END_UPDATE>");
			updateReceiver.interrupt();
			updateReceiver = null;
		}
	}

	public void exit() {
		// Abmelden vom Server, ggf. Update-Modus vorher beenden
		// lokale Aufraeumarbeiten == alle Ressourcen schließen, also:
		updateEnd();
		try {
			if (toServer != null) {
				out.println("<EXIT>"); // EXIT an den Server senden
				out.close(); // PrintWriter schließen
				in.close(); // BufferedReader schließen
				toServer.close(); // Server schließen
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// TODO zum Server passenden Hostname, Portnummer eintragen
		String hostname = "localhost";
		int portnummer = 45678;

		if (args.length == 2) {
			hostname = args[0];
			portnummer = Integer.parseInt(args[1]);
		}
		new WetterClient(hostname, portnummer);
	}
}
