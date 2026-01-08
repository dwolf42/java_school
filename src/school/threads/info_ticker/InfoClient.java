package school.threads.info_ticker;

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class InfoClient extends Frame {

	private Label status;		// Statuszeile
	private List topicList;		// Liste fuer empfangene Infos
	private TextField topic;
	
	private Socket toServer = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private PrintWriter logger = null;

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
		top.add(new Label ("Topic"));
		topic = new TextField();
		topic.setColumns(10);
		top.add(topic);	
		Button btnSend = new Button("Senden");
		// Reaktion beim Druecken Senden-Button
		btnSend.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("eingegebens Topic: "+topic.getText());
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
		
		return false; 
	}
	
	public void send2Server(String line){
		// TODO Zeile an Server senden
	}

	public void exit() {
		// TODO
		// Beenden Receiver-Thread, falls noch aktiv
		// Abmelden beim Server
		// Ressourcen schliessen
		
	}

	public static void main(String[] args) {
		String hostname = ""; 		// TODO eintragen der IP-Adresse
		int portnummer = 7077;
		String username = ""; 			// TODO eintragen des Anmeldenamens
		
		new InfoClient(hostname, portnummer, username);
	}

}
