package a1_Lsg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class CopyTextFile {

	public static void main(String[] args) {
		// Variante 1
		FileReader in = null;
		FileWriter out = null;
		try {
			in = new FileReader("xanadu.txt");
			out = new FileWriter("xanadu_copy.txt");
			int c;

			while ((c = in.read()) != -1) {
				System.out.print((char) c);
				out.write(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
			}
		}

		// copy("xanadu.txt", "xanadu_copy.txt");
		// copy("java.jpg", "java_copy.jpg");

	}

	public static void copy(String src, String dest) {
		// Variante mit "try-with-resources" Statement:
		// - Alle im try deklarierten Ressourcen werden am
		// Blockende automatisch wieder geschlossen!
		try (FileReader in = new FileReader(src);
				FileWriter out = new FileWriter(dest)) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
