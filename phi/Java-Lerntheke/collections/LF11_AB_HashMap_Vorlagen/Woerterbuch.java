
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Woerterbuch extends Frame {

	private TextField tfEnglish;
	private TextField tfDeutsch;

	// TODO passende Collection anlegen

	public Woerterbuch() {
		super("Wörterbuch");
		// TODO 
		// Woerterbuchdatei "dict_unicode_e-d.txt" oeffnen und einlesen
		// und Collection fuellen

		// GUI initialisieren
		initializeGUI();
	}

	private void initializeGUI() {
		Panel labelPanel = new Panel(new GridLayout(2, 1));
		labelPanel.add(new Label("English"));
		labelPanel.add(new Label("Deutsch"));
		add(labelPanel, BorderLayout.WEST);

		Panel textPanel = new Panel(new GridLayout(2, 1));
		tfEnglish = new TextField("");
		textPanel.add(tfEnglish);
		tfDeutsch = new TextField("");
		textPanel.add(tfDeutsch);
		add(textPanel);

		Button btnSearch = new Button("Suchen");
		add(btnSearch, BorderLayout.EAST);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String text = tfEnglish.getText();
				
				// TODO 
				// Ermitteln der deutschen Bedeutung aus der Collection
				// und Anzeige im Textfeld:
				
				tfDeutsch.setText("kein Eintrag gefunden");
			}
		});
		// Bearbeitung Fenster-Close-Button
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});
		setSize(500, 100);
		setVisible(true);

	}
	
	public static void main(String[] args) {

		Woerterbuch thisClass = new Woerterbuch();
	}


}
