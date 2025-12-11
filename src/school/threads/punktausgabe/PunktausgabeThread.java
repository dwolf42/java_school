package school.threads.punktausgabe;

class PunktausgabeThread extends Thread {
	private String text;
	private int warteZeit;

	public PunktausgabeThread(String text, int wZeit) {
		this.text = text;
		this.warteZeit = wZeit;
	}

	public void run() {
			try {
				while (!isInterrupted()) {
					Thread.sleep(warteZeit);
					System.out.println(text);
				}
			} catch (InterruptedException e) {
			}

		System.out.println("Thread was interrupted");
	}
}

