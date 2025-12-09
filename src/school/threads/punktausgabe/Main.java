package school.threads.punktausgabe;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Punktausgabe t1 = new Punktausgabe(".", 1000);
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
