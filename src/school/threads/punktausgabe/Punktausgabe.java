package school.threads.punktausgabe;

class Punktausgabe extends Thread {
	private String text;
	private int warteZeit;

	public Punktausgabe(String text, int wZeit) {
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

