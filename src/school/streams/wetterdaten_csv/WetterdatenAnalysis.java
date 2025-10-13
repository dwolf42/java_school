package school.streams.wetterdaten_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WetterdatenAnalysis {
    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(
                new FileReader("src/school/streams/wetterdaten_csv/wetterdaten_feldberg.txt"));
             PrintWriter out = new PrintWriter(
                     new FileWriter("src/school/streams/wetterdaten_csv/wetterdaten_auswertung.txt"));) {
            String line = null;

            // As the first 3 lines don't contain numeric values, and the string "Datum" has to be replaced by
            // whitespaces, these lines are handled in this loop
            for (int i = 0; i < 3; i++) {
                line = in.readLine();
                line = line.replace("Datum", "     ");
                out.write(line + "\n");
            }

            // Initialized where it's actually needed
            String[] splitted = null;
            double[][] wValues = new double[34][8];

            int wValuesRow = 0;
            while ((line = in.readLine()) != null) {
                splitted = line.split(" +");

                // Iterate over the read line which has been split to an array.
                // If the index is parseable to Double, it gets written to the row.
                for (int splittedIterator = 1; splittedIterator < splitted.length; splittedIterator++) {
                    try {
                        wValues[wValuesRow][splittedIterator] = Double.parseDouble(splitted[splittedIterator]);
                    } catch (NumberFormatException e) {
                        // Nothing here
                    }
                }
                wValuesRow++;

            }

            for (int i = 0; i < wValues.length; i++) {
                for (int j = 0; j < wValues[i].length; j++) {
                    System.out.print(wValues[i][j] + " ");
                }
                System.out.println("");
            }
            // Calculation

            Double temp;



        }
    }
}


