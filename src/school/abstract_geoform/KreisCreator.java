package school.abstract_geoform;

import java.util.Scanner;

public class KreisCreator extends GeoFormCreator {

    public KreisCreator(String typ) {
        super(typ);
    }

    @Override
    public GeoForm create() {
        double radius = 0;
        Scanner ein = new Scanner(System.in);
        System.out.println("Bitte geben Sie den Radius ein:");
        radius = ein.nextDouble();
        return new Kreis(radius);
    }

}
