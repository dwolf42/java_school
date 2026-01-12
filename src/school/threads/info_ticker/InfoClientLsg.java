package school.threads.info_ticker;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class InfoClientLsg extends Frame {
	private Label status = new Label("Status");
	private List topicList;
	private TextField topic;
	private Socket toServer = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private PrintWriter logger = null;
	private Receiver receiver = null;

	public InfoClientLsg(String hostname, int portnummer, String code) {
		super("InfoClient");
		this.add(this.status, "South");
		Panel top = new Panel();
		top.add(new Label("Topic"));
		this.topic = new TextField();
		this.topic.setColumns(10);
		top.add(this.topic);
		Button btnSend = new Button("Senden");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoClientLsg.this.send2Server("<INIT>:" + InfoClientLsg.this.topic.getText());
			}
		});
		top.add(btnSend);
		this.add(top, "North");
		this.topicList = new List(6);
		this.add(this.topicList);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				InfoClientLsg.this.exit();
				InfoClientLsg.this.dispose();
			}
		});
		if (this.connect(hostname, portnummer, code)) {
			this.status.setText("Verbindung erfolgreich");
		} else {
			this.status.setText("Verbindung fehlgeschlagen");
		}

		this.pack();
		this.setVisible(true);
	}

	public boolean connect(String hostname, int portnummer, String code) {
		try {
			this.toServer = new Socket(hostname, portnummer);
			this.in = new BufferedReader(new InputStreamReader(this.toServer.getInputStream()));
			this.out = new PrintWriter(this.toServer.getOutputStream(), true);
			this.logger = new PrintWriter(new FileWriter("WetterClient.log"), true);
			this.send2Server("<LOGIN>:" + code);
			String answer = this.readAndLog();
			if (answer.startsWith("<END_LOGIN>")) {
				if (answer.contains("OK")) {
					this.receiver = new Receiver();
					this.receiver.start();
					return true;
				}

				this.toServer.close();
			}

			return false;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void send2Server(String line) {
		this.out.println(line);
	}

	public String readAndLog() throws IOException {
		String line = this.in.readLine();
		LocalDateTime ldt = LocalDateTime.now();
		PrintWriter var10000 = this.logger;
		String var10001 = ldt.toString();
		var10000.println(var10001 + ":" + line);
		return line;
	}

	public void exit() {
		if (this.receiver != null) {
			this.receiver.interrupt();
		}

		try {
			if (this.toServer != null) {
				this.send2Server("<LOGOUT>");
				this.out.close();
				this.in.close();
				this.toServer.close();
				this.logger.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		String hostname = "";
		int portnummer = 7077;
		String name = "mein Name";
		hostname = "localhost";
		new InfoClientLsg(hostname, portnummer, name);
	}

	class Receiver extends Thread {
		private ArrayList<String> keys = new ArrayList();

		public void run() {
			boolean init = true;

			while(!this.isInterrupted()) {
				try {
					String line;
					if ((line = InfoClientLsg.this.readAndLog()) != null) {
						if (line.equals("<START_INIT>")) {
							InfoClientLsg.this.topicList.removeAll();
							this.keys.clear();
							init = true;
						} else if (line.startsWith("<END_INIT>")) {
							init = false;
						} else {
							String[] words = line.split(":");
							if (init) {
								this.keys.add(words[0]);
								InfoClientLsg.this.topicList.add(line);
							} else {
								int index = this.keys.indexOf(words[0]);
								InfoClientLsg.this.topicList.replaceItem(line, index);
							}
						}
					} else {
						Thread.currentThread().interrupt();
					}
				} catch (IOException var5) {
				}
			}

			InfoClientLsg.this.receiver = null;
			System.out.println("WetterUpdate-Thread ends");
		}
	}
}

