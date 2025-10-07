package school.streams;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextSaver {
    public static void main(String[] args) throws IOException {
        Scanner aScanner = new Scanner(System.in);

        String zeile;

        try (FileWriter out1 = new FileWriter("out1.txt")) {
            do {
                zeile = aScanner.nextLine();
                System.out.println(zeile);
                out1.write(zeile);

            } while (!zeile.equalsIgnoreCase("exit"));
            System.out.println("Tschüss...");
        }
    }
}

