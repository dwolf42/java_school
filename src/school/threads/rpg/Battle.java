package school.threads.rpg;

import java.util.Scanner;

class Battle {
	String heroName;
	int heroHp;
	String monsterName;
	int monsterHp;

	public Battle(String heroName, int heroHp, String monsterName, int monsterHp) {
		this.heroName = heroName;
		this.heroHp = heroHp;
		this.monsterName = monsterName;
		this.monsterHp = monsterHp;
	}

	public void startMe() {
		StatusPrinter statusThread = new StatusPrinter(1500);
		Thread t1 = new Thread(statusThread);
		t1.start();

		Scanner scanner = new Scanner(System.in);
		String input;
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("Enter (a)ttack or (q)uit:");
			input = scanner.nextLine().trim();
			if (input.equalsIgnoreCase("a")) {
				// Hero attacks monster (reduce monster's HP)
			} else if (input.equalsIgnoreCase("q") ||
					heroHp <= 0 ||
					monsterHp <= 0) {
				// Terminates Thread gracefully => in Thread there must run a !isInterrupted

				Thread.currentThread().interrupt();
			} else {
				System.err.println("Quack!");
			}
		}
	}

	class StatusPrinter implements Runnable {
		int intervalMillis;

		public StatusPrinter(int intervalMillis) {
			this.intervalMillis = intervalMillis;
		}

		public void run() {
			while (true) {
				if (!Thread.currentThread().isInterrupted() &&
						Battle.this.heroHp > 0 && Battle.this.monsterHp > 0) {
					try {
						Thread.sleep(intervalMillis);
						System.out.print(Battle.this.heroName + ": " + Battle.this.heroHp);
						System.out.print(" vs. ");
						System.err.print(Battle.this.monsterName + ": " + Battle.this.monsterHp + "\n");
					} catch (InterruptedException e) {
						System.out.println("Battle was interrupted by some weird Kreuz-Otters");
					}
				} else {
					if (Battle.this.heroHp <= 0) {
						System.out.println("~Game over~");
						System.out.println(Battle.this.heroName + " lost the battle against " +
								Battle.this.monsterName + "...");
						System.out.println(Battle.this.monsterName + " still has " + Battle.this.monsterHp + "HP left!");
					} else {
						System.out.println(Battle.this.heroName + " wins against the evil " +
								Battle.this.monsterName + "!!!");
						System.out.println("You still have " + Battle.this.heroHp + "HP left!!");
					}
				}
			}
		}
	}
}
