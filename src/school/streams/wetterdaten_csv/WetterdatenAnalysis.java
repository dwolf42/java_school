package school.streams.wetterdaten_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WetterdatenAnalysis {
    public static void main(String[] args) throws IOException {

//        double sum = 0;
//        double[] ba = {7.7,1.6,0.0,2.4,5.3,3.5,2.9,7.0,4.0,3.8,4.6,9.3,9.7,9.8,3.8,3.4,6.9,6.0,6.3,6.5,7.9,7.0,8.5,7.6,5.9,7.5,7.2,4.4,0.4,0.5,2.6};
//        for (double d : ba) {
//            sum += d;
//        }
//
//        System.out.println(sum / ba.length );

        try (BufferedReader in = new BufferedReader(
                new FileReader("src/school/streams/wetterdaten_csv/wetterdaten_feldberg.txt"));
             PrintWriter out = new PrintWriter(
                     new FileWriter("src/school/streams/wetterdaten_csv/wetterdaten_auswertung.txt"));) {
            String line = null;

            // As the first 3 lines don't contain numeric values, and the string "Datum" has to be replaced by
            // whitespaces, these lines are handled in this loop
            for (int row = 0; row < 3; row++) {
                line = in.readLine();
                out.println(line.replace("Datum", "     "));
            }

            String[] splitted = null;
            // the ArrayList contains ArrayLists, which contain Double values,
            // so the type the outer ArrayList must have, and thus the called constructor, must be of type ArrayList
            ArrayList<ArrayList<Double>> valueRows = new ArrayList<>();

            // Transfer read lines to array lists, stored in an array list
            // That way it's possible to vertically iterate through the lists for processing
            while ((line = in.readLine()) != null) {
                splitted = line.split(" +");
                ArrayList<Double> values = new ArrayList<Double>();

                // starts at 1 to skip date in first column of data
                for (int row = 1; row < splitted.length; row++) {
                    try {
                        values.add(Double.parseDouble(splitted[row]));
                    } catch (NumberFormatException e) {
                        // Nothing here
                    }
                }
                valueRows.add(values);
            }

            // Required to know how many times we must iterate to cover the indexes of all items in the list
            // Dem Programm ist nicht bekannt, ob die inneren ArrayList<Double> alle die gleiche Länge haben,
            // daher dient dieser Algorhithmus dazu, die größe der längsten ArrayList<Double> zu bestimmen.
            // Dadruch wird sichergestellt, dass über alle Werte in allen ArrayList iteriert wird.
            //
            int numOfRows = valueRows.size();

            // Find maximum number of columns in each row
            int maxCols = 0;
            for (int row = 0; row < valueRows.size(); row++) {
                for (int col = 0; col < valueRows.get(row).size(); col++) {
                    if (valueRows.get(row).size() > maxCols) {
                        maxCols = valueRows.get(row).size();
                    }
                }
            }

//            double minCol = 0.0;
//            double maxCol = 0.0;
//            double avgCol = 0.0;
//            ArrayList<Double> toCountAmountOfValues = new ArrayList<Double>();

            ArrayList<Double> tMin = new ArrayList<Double>();
            ArrayList<Double> tMit = new ArrayList<Double>();
            ArrayList<Double> tMax = new ArrayList<Double>();
            ArrayList<Double> sGes = new ArrayList<Double>();
            ArrayList<Double> rGes = new ArrayList<Double>();
            ArrayList<Double> rFmit = new ArrayList<Double>();
            ArrayList<Double> wMit = new ArrayList<Double>();
            ArrayList<Double> wBmax = new ArrayList<Double>();

            double[] mins = new double[8];
            double[] avgs = new double[8];
            double[] maxs = new double[8];

            // Iterate vertically column-wise, checking boundaries to avoid IndexOutOfBounds and handle missing elements
            for (int col = 0; col < maxCols; col++) {
                for (int row = 0; row < valueRows.size(); row++) {
                    ArrayList<Double> currentRow = valueRows.get(row);
                    if (col < currentRow.size()) {

                        // less expensive
                        Double value = currentRow.get(col);


//                   if (valueRows.get(row).get(col) > minCol) {
//                       minCol = valueRows.get(row).get(col);
//                   }
//                   if (valueRows.get(row).get(col) > maxCol) {
//                       maxCol = valueRows.get(row).get(col);
//                   }
//                  toCountAmountOfValues.add(valueRows.get(row).get(col));
                    }
                }
            }
        }
    }
}
/*

double ba = {7.7,1.6,0.0,2.4,5.3,3.5,2.9,7.0,4.0,3.8,4.6,9.3,9.7,9.8,3.8,3.4,6.9,6.0,6.3,6.5,7.9,7.0,8.5,7.6,5.9,7.5,7.2,4.4,0.4,0.5,2.6};
 */