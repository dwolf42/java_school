package school.threads;

class MyThread extends Thread {
	private String text;
	private int runden, warteZeit;

	public MyThread(String text, int runden, int wZeit) {
		this.text = text;
		this.runden = runden;
		this.warteZeit = wZeit;
	}

	public void run() {
		try {
			for (int i = 0; i < runden; i++) {
				Thread.sleep(warteZeit);
				System.out.println(text);
			}
			System.out.println(text);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadBasics {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("xxx", 2, 3000);
		t1.start();
	}
}
