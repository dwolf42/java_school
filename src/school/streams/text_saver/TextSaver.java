package school.streams.text_saver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextSaver {
    public static void main(String[] args) throws IOException {
        Scanner aScanner = new Scanner(System.in);

        String zeile;

        try (FileWriter out1 = new FileWriter("src/school/streams/text_saver/out1.txt")) {
            do {
                zeile = aScanner.nextLine();
                System.out.println(zeile);
                out1.write(zeile);

            } while (!zeile.equalsIgnoreCase("exit"));
            System.out.println("Tschüss...");
        }
    }
}

