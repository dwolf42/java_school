package school.streams;

import java.io.*;

public class XanaduCopy {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("xanadu.txt");

        try(BufferedReader in = new BufferedReader(new FileReader("xanadu.txt"));
            PrintWriter out = new PrintWriter(new FileWriter("xanadu_kopie.txt"));) {
            String line;
            while ((line = in.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
