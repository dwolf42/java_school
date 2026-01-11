package school.threads.info_ticker;

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class InfoClient extends Frame {

	/*
	Was will der jetzt eigentlich von mir?

Also, der Server stellt den Clients Infos zu verschiedenen Themen (Topics) zur
Verfügung, die er immer aktualisiert.
Heiz den Server an und gib ne Portnummer ein, dann wartet der Server auf
eingehende Verbindungen.

Dem Server kann ich mit Textkommands, die ich ihm schicken muss, angesprochen werden:
z. B. <LOGIN>:name usw.

Ich soll den Client implementieren, anhand des Klassendiagramms und den Anforderungen

Client erbt von Frame
-> hat folgende Attribute:
Socket object: toServer
BufferedReader: in - für Zeug, was vom Server kommt
PrintWriter: out - für Zeug, was an Server geht
AWT-List: topicList - für die Topics

-> hat folgende Methoden
InfoCliet(host:String,port:int,code:String)
Ich muss Kommunikationsobjekte und ne HashMap erzeugen



send2Server(line:String) -> sende den String an den Server - dah

exit() -> joar, alles abbauen und so.
Beendet den receiver.Thread (Thread.currentThread.isInterrupted())
Sendet Logout-Kommando an Server, schließt alle lokalen Ressourcen.

----
Receiver-Klasse, erbt von Thread: receiver, 1 Objekt, muss ich implementieren
Ist eine Komposition, also hat keine Existenz ohne den Client.

-> hat folgende Attribute:
init: boolean - ist init aktiv?
ein Attribut zur Speicherung aller Keys eines Topics (Map?)

-> hat folgende Methoden:
run()
empfängt asynchron alle Nachrichten vom Server

Damit empfange ich nach Initialisierung alle Rückantworten des Servers, verarbeite
sie und zeig sie in der GUI an.
Während dem INIT, werden alle Infos in die topicList hinzugefügt und mir
zusätzlich zu jedem Schlüssel den Indexwert der List-Komponente merken.

Neue Nachrichten nach <END_INIT> ersetzen dann das jeweilige Item in der
List mit dem aktuellen neuen Wert.

Beim Start einer INIT-Phase wird die topicList neu initialisiert und die
gemerkten Indexwerte verworfen.

Der Thread muss sich beenden, wenns Lesefehler gibt
    */

	private Label status;        // Statuszeile
	private TextField topic;

	private Socket toServer = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private PrintWriter logger = null;
	private List topicList;        // Liste fuer empfangene Infos

	// TODO weitere Attribute

	// TODO innere Receiver-Thread-Klasse

	public InfoClient(String hostname, int portnummer, String code) {
		super("InfoClient");
		status = new Label("Status");
		add(status, BorderLayout.SOUTH);

		topicList = new List(6);
		add(topicList);

		// Aufbau GUI
		Panel top = new Panel();
		top.add(new Label("Topic"));
		topic = new TextField();
		topic.setColumns(10);
		top.add(topic);
		Button btnSend = new Button("Senden");
		// Reaktion beim Druecken Senden-Button
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("eingegebens Topic: " + topic.getText());
				// TODO senden <INIT>-Befehl mit Topic

			}
		});

		top.add(btnSend);
		add(top, BorderLayout.NORTH);

		// Aktivieren Close-Button, sauberes Beenden der Anwendung
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
				dispose();
			}
		});

		if (connect(hostname, portnummer, code)) {
			status.setText("Verbindung erfolgreich");
		} else {
			status.setText("Verbindung fehlgeschlagen");
		}
		pack();
		setVisible(true);
	}

	public boolean connect(String hostname, int portnummer, String username) {
		// TODO
		// - Erzeugen von Socket, BufferedReader, PrintWriter, PrintWriter zu Logging
		// - Senden Login an Server
		// - Empfang Rueckantwort und Auswertung
		// - Erzeugen und Starten Receiver-Thread bei erfolgreichem Login
		// - Rueckgabe true bei OK, false bei ERROR
	/*
Verbindung zum Server aufbauen, alle nötigen Objekte erzeugen und initialisieren,
und in den entsprechenden Attributen speichern.
Schreiben eienr Log-Datei.
Sendet Login-Kommando mit Anmeldename an Server und wertet dessen Antwort aus.
Wenn das klappt, erzeugen wir einen Receiver-Thread und start()en ihn.
Wenn das alles klappt, geben wir true zurück, sonst false.
	 */

		try {
			toServer = new Socket(hostname, portnummer);

		} catch (IOException e) {

		}

		return false;
	}

	public void send2Server(String line) {
		// TODO Zeile an Server senden
	}

	public void exit() {
		// TODO
		// Beenden Receiver-Thread, falls noch aktiv
		// Abmelden beim Server
		// Ressourcen schliessen

	}

	public static void main(String[] args) {
		String hostname = "localhost";        // TODO eintragen der IP-Adresse
		int portnummer = 7077;
		String username = "Radieschen";            // TODO eintragen des Anmeldenamens

		new InfoClient(hostname, portnummer, username);
	}
}
