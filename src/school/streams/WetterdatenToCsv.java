package school.streams;

import java.io.*;
import java.util.Arrays;

public class WetterdatenToCsv {
    public static void main(String[] args) throws IOException {

        try(BufferedReader in = new BufferedReader(new FileReader("wetterdaten_feldberg.txt"));
            PrintWriter out = new PrintWriter(new FileWriter("wetterdaten_feldberg.csv"));) {
            String line;

            String[] splitted = null;
            /*
            * not to write:
            * line starts with #
            * string = Datum
            * .mm.yyyy
            * */

            while ((line = in.readLine()) != null) {
                if(line.charAt(0) == '#') {
                    continue;
                }

                splitted = line.split(" +");

                for (int i = 0; i < splitted.length; i++) {
                    if(splitted[i].equalsIgnoreCase("Datum")) {
                        continue;
                    }
                    out.write(splitted[i]);
                    System.out.println(Arrays.toString(splitted));
                }

            }

        }
    }
}
