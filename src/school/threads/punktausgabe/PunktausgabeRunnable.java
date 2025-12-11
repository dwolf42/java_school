package school.threads.punktausgabe;

class PunktausgabeRunnable implements Runnable {
	private String text;
	private int warteZeit;

	public PunktausgabeRunnable(String text, int warteZeit) {
		this.text = text;
		this.warteZeit = warteZeit;
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep(warteZeit);
				System.out.println(text);
			}
		} catch (InterruptedException e) {
		}

		System.out.println("Thread was interrupted");
	}
}
