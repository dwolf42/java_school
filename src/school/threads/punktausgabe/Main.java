package school.threads.punktausgabe;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		punktausgabeExtendsThread();
		punktausgabeImplementsRunnable();
	}

	public static void punktausgabeImplementsRunnable() {
		PunktausgabeRunnable r1 = new PunktausgabeRunnable("^", 1000);
		Thread t1 = new Thread(r1);
		t1.start();

		Scanner scanner = new Scanner(System.in);
		String eingabe;

		while (true) {
			eingabe = scanner.nextLine();
			System.out.println(eingabe);

			if (eingabe.equalsIgnoreCase("q")) {
				t1.interrupt();
				break;
			}
		}
	}

	public static void punktausgabeExtendsThread() {
		PunktausgabeThread t1 = new PunktausgabeThread(".", 1000);
		t1.start();

		Scanner scanner = new Scanner(System.in);
		String eingabe;

		while (true) {
			eingabe = scanner.nextLine();
			System.out.println(eingabe);

			if (eingabe.equalsIgnoreCase("q")) {
				t1.interrupt();
				break;
			}
		}
	}
}
