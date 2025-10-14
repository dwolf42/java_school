package school.streams.wetterdaten_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class LsgAuswertung {
    public static void main(String[] args) throws IOException {
        generateSummary("src/school/streams/wetterdaten_csv/wetterdaten_feldberg.txt",
                "src/school/streams/wetterdaten_csv/wetterdaten_auswertung_lsg.txt");
    }

    public static void generateSummary(String filename, String resultname) {
        ArrayList<float[]> mwList = new ArrayList<float[]>();
        try (BufferedReader in = new BufferedReader(new FileReader(filename));
             PrintWriter out = new PrintWriter(resultname);) {
            String line;
// Kopfzeile uebernehmen
            out.println(in.readLine());
            while ((line = in.readLine()) != null) {
                if (line.startsWith("#")) {
// Kommentare direkt wieder schreiben
                    out.println(line);
                } else if (line.startsWith("Datum")) {
// Ueberschriftszeile ohne Datum mit Spaltenbreite 8 schreiben
                    String[] word = line.split(" +");
                    out.printf("%8s", "");
                    for (int i = 1; i < word.length; i++) {
                        out.printf("%8s", word[i]);
                    }
                    out.println();
                } else {
// Datenzeile in Array von float umwandeln und mwList speichern
                    String[] word = line.split(" +");
                    float[] messreihe = new float[word.length - 1];
                    for (int i = 1; i < word.length; i++) {
                        messreihe[i - 1] = Float.parseFloat(word[i]);
                    }
                    mwList.add(messreihe);
                }
            }
            calculateAndPrint(mwList, out);
            System.out.println("Zusammenfassung " + resultname + " erfolgreich erzeugt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculateAndPrint(ArrayList<float[]> messw, PrintWriter out) {
// erste Messreihe holen und in Hilfsarrays anlegen/initialisieren
        float[] first = messw.get(0);
        float[] min = Arrays.copyOf(first, first.length);
        float[] max = Arrays.copyOf(first, first.length);
        float[] avg = new float[first.length];
// eigentliche Auswertung
        for (float[] reihe : messw) {
            for (int i = 0; i < reihe.length; i++) {
                if (reihe[i] < min[i]) {
                    min[i] = reihe[i];
                }
                if (reihe[i] > max[i]) {
                    max[i] = reihe[i];
                }
                avg[i] += reihe[i];
            }
        }
// und ausgeben
        out.printf("%n%8s", "Minimum");
        for (int i = 0; i < min.length; i++) {
            out.printf("%8.1f", min[i]);
        }
        out.printf("%n%8s", "Mittel");
        for (int i = 0; i < avg.length; i++) {
            avg[i] = avg[i] / messw.size(); // Mittelwert berechnen
            out.printf("%8.1f", avg[i]);
        }
        out.printf("%n%8s", "Maximum");
        for (int i = 0; i < max.length; i++) {
            out.printf("%8.1f", max[i]);
        }
    }
}