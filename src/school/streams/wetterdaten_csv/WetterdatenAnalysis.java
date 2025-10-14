package school.streams.wetterdaten_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

            String[] splitted = null;
            List<ArrayList> valueRows = new ArrayList<>();

            while ((line = in.readLine()) != null) {
                splitted = line.split(" +");
                ArrayList<Double> values = new ArrayList<Double>();

                // starts at 1 to skip date in first column of data
                for (int i = 1; i < splitted.length; i++) {
                    try {
                       values.add(Double.parseDouble(splitted[i]));
                    } catch (NumberFormatException e) {
                        // Nothing here
                    }
                }

                valueRows.add(values);
            }

           for (int i = 0; i < valueRows.size(); i++) {
              for (int j = 0; j < valueRows.get(i))
            valueRows.get(i).get(j);

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


