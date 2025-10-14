package school.streams.wetterdaten_csv;

import java.io.*;
import java.util.Arrays;

public class WetterdatenToCsv {
    public static void main(String[] args) throws IOException {
//        String csvfilename = filename.substring(0, filename.lastindexOf('.')) + ".csv";
        try (BufferedReader in = new BufferedReader(new FileReader("src/school/streams/wetterdaten_csv/wetterdaten_feldberg.txt"));
             PrintWriter out = new PrintWriter(new FileWriter("src/school/streams/wetterdaten_csv/wetterdaten_feldberg.csv"));) {
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
// out.print or out.println lets you write into the file sequentially

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
                        splitted[i] = splitted[i].replaceAll("\\.",",");
                        out.write(splitted[i] + ";");
                    }
                }
            }
        }
    }
}
