package school.threads.spiel77;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Spiel77 extends Frame {

	private Label[] zahlLbl;        // Array aller Zahlen-Label
	private Button btnStart;
	private Button btnStop;

	// TODO
	// Array der ZahlenGenerator-Thread-Objekte
	private ZahlenGenerator[] zahlenGeneratorThreadObjekte;
	private final int TIME = 1500;
	private final int SLEEP = 20;

	// TODO ZahlenGenerator-Thread-Klasse (z.B. als Innere Member Class)

	class ZahlenGenerator extends Thread {
		final int indexOfLabel;
		boolean isGenerating = true;

		public ZahlenGenerator(int indexOfLabel) {
			this.indexOfLabel = indexOfLabel;
		}

		public void run() {
			/* index label
				über Konstruktor den Index rein gegben
				paar ms schlafen, dann incremet
				setText() um Text bei Label zu setzen
				// random.nextInt(100 - 20 + 1) + 100
			 */
			try {
				int startNumber = new Random().nextInt(10);
				while (isGenerating) {
					if (startNumber % 10 == 0) {
						startNumber = new Random().nextInt(10);
					}
					zahlLbl[indexOfLabel].setText("" + startNumber);
					Thread.sleep(new Random().nextInt(100 - 20 + 1) + 20);
					startNumber++;
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public Spiel77() {
		super("Spiel 77");

		zahlLbl = new Label[7];

		// ZahlenGenerator Thread Objekte
		zahlenGeneratorThreadObjekte = new ZahlenGenerator[7];

		add(new Label("Gewinnzahlen:"), BorderLayout.NORTH);
		// Gewinnzahl-Labels anlegen
		Panel zahlen = new Panel(new GridLayout(1, 7));
		for (int i = 0; i < zahlLbl.length; i++) {
			Label lbl = new Label("0");
			lbl.setFont(new Font("Arial", Font.BOLD, 16));
			zahlLbl[i] = lbl;
			zahlen.add(lbl);
		}
		add(zahlen);
		// Start-/Stop-Buttons
		Panel buttons = new Panel(new GridLayout(1, 2));
		btnStart = new Button("Ziehung starten");
		buttons.add(btnStart);
		btnStop = new Button("Ziehung beenden");
		buttons.add(btnStop);
		btnStop.setEnabled(false);
		add(buttons, BorderLayout.SOUTH);

		pack();
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Threads erzeugen/starten
				for (int i = 0; i < zahlenGeneratorThreadObjekte.length; i++) {
					zahlenGeneratorThreadObjekte[i] = new ZahlenGenerator(i);
					zahlenGeneratorThreadObjekte[i].start();
				}
			}
		});
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
				// Allen Zahlengeneratoren mitteilen, dass 
				// Zahlenermittlung jetzt beginnt, d.h. die Threads
				// zeitversetzt ihre Zahl bestimmen und sich dann 
				// beenden.
			}
		});

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO 
				// Allen laufenden Threads auffordern, dass sie sich (baldmöglichst) beenden.

				dispose();
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {
		new Spiel77();
	}
}
