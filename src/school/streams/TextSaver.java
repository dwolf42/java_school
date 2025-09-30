package school.streams;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextSaver {
    public static void main(String[] args) throws IOException {
        Scanner aScanner = new Scanner ( System.in );



        String	zeile;

        do {
            zeile = aScanner.nextLine();
            System.out.println(zeile);

            try (FileWriter out1 = new FileWriter("out1.txt");
                 PrintWriter out2 = new PrintWriter("out2.txt", true)) {
                out1.write(zeile);
                out2.write(zeile);

            }


        } while ( !zeile.equalsIgnoreCase("exit") );
        System.out.println("Tschüss...");

    }
}

