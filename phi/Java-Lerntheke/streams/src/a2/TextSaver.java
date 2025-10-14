
package a2;

import java.util.Scanner;
import java.io.*;

public class TextSaver {
	public static void main(String[] args) throws IOException {
		Scanner aScanner = new Scanner ( System.in );
		
		String	zeile;
		do {
			zeile = aScanner.nextLine();
			System.out.println(zeile);

		} while ( !zeile.equalsIgnoreCase("exit") );
		System.out.println("Tschüss...");
		
	}
}
