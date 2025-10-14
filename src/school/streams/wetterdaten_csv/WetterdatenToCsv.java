package school.streams.wetterdaten_csv;

import java.io.*;

public class WetterdatenToCsv {
    public static void main(String[] args) throws IOException {
       teachersApproach();
    }

    public static void myApproach() throws IOException {
        try (BufferedReader in = new BufferedReader(
                new FileReader("src/school/streams/wetterdaten_csv/wetterdaten_feldberg.txt"));
             PrintWriter out = new PrintWriter(
                     new FileWriter("src/school/streams/wetterdaten_csv/wetterdaten_feldberg.csv"));) {
            String line = null;
            String temp = null;
            String[] splitted = null;
            while ((line = in.readLine()) != null) {
                if (line.charAt(0) == '#') {
                    continue;
                }
                if (line.contains("_")) {
                    temp = line;
                    continue;
                }
                splitted = line.split(" +");
                for (int i = 0; i < splitted.length; i++) {
                    if (splitted[0].charAt(0) == 'D') {
                        splitted[0] = temp;
                    } else {
                        splitted[0] = splitted[0].substring(0, 2);
                    }
                    if (i == splitted.length - 1) {
                        out.write(splitted[i] + "\n");
                    } else {
                        splitted[i] = splitted[i].replaceAll("\\.", ",");
                        out.write(splitted[i] + ";");
                    }
                }
            }
        }
    }

    public static void teachersApproach() throws IOException {
        String filename = "src/school/streams/wetterdaten_csv/wetterdaten_feldberg.txt";
        String csvfilename = "src/school/streams/wetterdaten_csv/wetterdaten_feldberg.csv";
        char delimiter = ';';
        try (BufferedReader in = new BufferedReader(new FileReader(filename));
             PrintWriter out = new PrintWriter(csvfilename);) {
            String line;
            String monat = in.readLine();
            while ((line = in.readLine()) != null) {
                if (line.startsWith("#")) {
                    // Kommentare ignorieren
                } else if (line.startsWith("Datum")) {
                    // Kopfzeile
                    out.print(monat);
                    String[] word = line.split(" +");
                    for (int i = 1; i < word.length; i++) {
                        out.print(delimiter);
                        out.print(word[i]);
                    }
                    out.println();
                } else {
                    // Datenzeilen
                    String[] word = line.split(" +");
                    out.print(word[0].substring(0, 2));
                    for (int i = 1; i < word.length; i++) {
                        out.print(delimiter);
                        out.print(word[i].replace('.', ','));
                    }
                    out.println();
                }
            }
            System.out.println("Konvertierung nach " + csvfilename + " erfolgreich");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}