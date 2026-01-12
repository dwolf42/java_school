package school.threads.info_ticker;

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class InfoClient extends Frame {
	private Label status;        // Statuszeile
	private TextField topic;

	private Socket toServer = null;
	private BufferedReader input = null;
	private PrintWriter output = null;
	private PrintWriter logger = null;
	private List topicList;        // Liste fuer empfangene Infos
	private Receiver receiver;

	// TODO weitere Attribute

	// TODO innere Receiver-Thread-Klasse

	class Receiver extends Thread {
		private boolean init = true;
		private ArrayList<String> keys = new ArrayList<>();

		public void run() {
			while (!this.isInterrupted()) {
				try {
					String line;
					if ((line = input.readLine()) != null) {
						if (line.equals("<START_INIT>")) {
							topicList.removeAll();
							keys.clear();
							init = false;
						} else {
							String[] words = line.split(":");
							if (init) {
								keys.add(words[0]);
								topicList.add(line);
							} else {
								int index = keys.indexOf(words[0]);
								topicList.replaceItem(line, index);
							}
						}
					} else {
						Thread.currentThread().interrupt();
					}
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			receiver = null;
		}
	}

	public InfoClient(String hostIP, int portnummer, String code) {
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
				send2Server("<INIT>" + topic.getText());
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

		if (connect(hostIP, portnummer, code)) {
			status.setText("Verbindung erfolgreich");
		} else {
			status.setText("Verbindung fehlgeschlagen");
		}
		pack();
		setVisible(true);
	}

	public boolean connect(String hostIP, int portnummer, String username) {
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
			toServer = new Socket(hostIP, portnummer);
			input = new BufferedReader(new InputStreamReader(toServer.getInputStream()));
			output = new PrintWriter(toServer.getOutputStream(), true);
			send2Server("<LOGIN>:" + username);
			if (input.readLine().contains("<END_LOGIN>:OK")) {
				receiver = new Receiver();
				receiver.start();
				return true;
			}
			toServer.close();
			return false;
		} catch (
			IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void send2Server(String line) {
		// TODO Zeile an Server senden
		this.output.println(line);
	}

	public void exit() {
		// TODO
		// Beenden Receiver-Thread, falls noch aktiv
		// Abmelden beim Server
		// Ressourcen schliessen
		try {
			toServer.close();
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String hostIP = "127.0.0.1";        // TODO eintragen der IP-Adresse
		int portnummer = 7077;
		String username = "Radieschen";            // TODO eintragen des Anmeldenamens

		new InfoClient(hostIP, portnummer, username);
	}
}
