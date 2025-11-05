package school.colletions.hashmaps.woerterbuch;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Woerterbuch extends Frame {

    private TextField tfEnglish;
    private TextField tfDeutsch;
    private Map<String, String> woerterbuchMap;

    public Woerterbuch() throws IOException {
        super("Wörterbuch");
        // TODO
        // Woerterbuchdatei "dict_unicode_e-d.txt" oeffnen und einlesen
        // und Collection fuellen
        woerterbuchMap = new HashMap<String, String>();

        try (BufferedReader in = new BufferedReader(
                new FileReader("src/school/colletions/hashmaps/woerterbuch/dict_unicode_e-d.txt"))) {
            String line;
            String[] splitted;

            while ((line = in.readLine()) != null) {
                line = line.trim();
                if (!line.startsWith("#") || !line.isEmpty()) {
                    continue;
                }
               // TODO: handle double occurrences
                splitted = line.split("\\t");
                woerterbuchMap.put(splitted[0], splitted[1]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // GUI initialisieren
        initializeGUI();
    }

    private void initializeGUI() {
        Panel labelPanel = new Panel(new GridLayout(2, 1));
        labelPanel.add(new Label("English"));
        labelPanel.add(new Label("Deutsch"));
        add(labelPanel, BorderLayout.WEST);

        Panel textPanel = new Panel(new GridLayout(2, 1));
        tfEnglish = new TextField("");
        textPanel.add(tfEnglish);
        tfDeutsch = new TextField("");
        textPanel.add(tfDeutsch);
        add(textPanel);

        Button btnSearch = new Button("Suchen");
        add(btnSearch, BorderLayout.EAST);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = tfEnglish.getText();

                // TODO
                // Ermitteln der deutschen Bedeutung aus der Collection
                // und Anzeige im Textfeld:

                if (woerterbuchMap.containsKey(text)) {
                    tfDeutsch.setText(text);
                } else {
                    tfDeutsch.setText("kein Eintrag gefunden");
                }
            }
        });
        // Bearbeitung Fenster-Close-Button
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }

        });
        setSize(500, 100);
        setVisible(true);

    }

    public static void main(String[] args) throws IOException {

        Woerterbuch thisClass = new Woerterbuch();
    }


}
