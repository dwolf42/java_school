package school.streams.wetterdaten_csv;

import java.io.*;
import java.util.ArrayList;

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

            // Initialized where it's acutally needed
            String[] splitted = null;
            ArrayList<ArrayList<Double>> wValues = new ArrayList<ArrayList<Double>>();

            while ((line = in.readLine()) != null) {
                splitted = line.split(" +");
                ArrayList<Double> row = new ArrayList<>();

                // Iterate over the read line which has been split to an array.
                // If the index is parseable to Double, it gets written to the row.
                for (int i = 0; i < splitted.length; i++) {
                    try {
                        row.add(Double.parseDouble(splitted[i]));
                    } catch (NumberFormatException e) {
                        // Nothing here
                    }

                }

                // At the end of each iterated line, the row it put into the 2d ArrayList
                wValues.add(row);
            }

            // Calculation
            ArrayList<Double> minimum = new ArrayList<Double>();
            ArrayList<Double> mittel = new ArrayList<Double>();
            ArrayList<Double> maxmimum = new ArrayList<Double>();

            Double temp;

//            for (int i = 0; i < wValues.get())

                /*
                wValues.size 0000000
                wValues.size 0000000
                wValues.size 0000000
                 */
//            for (int i = 0; i < wValues.size(); i++) {
//                for (int j = 0; j < wValues.get(i).size(); j++) {
//                    out.write(wValues.get(i).get(j) + " ");
//                }
//                out.write("\n");
//            }

// Find the maximum number of columns
            int maxCols = 0;
            for (ArrayList<Double> row : wValues) {
                if (row.size() > maxCols) {
                    maxCols = row.size();
                }
            }

// Iterate vertically (column by column)
            for (int j = 0; j < maxCols; j++) {
                for (int i = 0; i < wValues.size(); i++) {
                    if (j < wValues.get(i).size()) {
                        out.write(wValues.get(i).get(j) + " ");
                    } else {
                        out.write("  "); // or skip, or write a placeholder
                    }
                }
                out.write("\n");
            }


        }
    }
}


