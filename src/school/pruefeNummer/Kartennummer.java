package school.pruefeNummer;

public class Kartennummer {
    public static void main(String[] args) {
        int[] kartennummer = {5, 1, 2, 4, 8, 9, 7, 2, 5, 3};
        System.out.println(pruefeNummer(kartennummer));
    }

    public static boolean pruefeNummer(int[] kartennummer) {
        int summe = 0;
        for (int i = 0; i < kartennummer.length - 1; i++) {
            summe += kartennummer[i] * (i + 1);
            System.out.println("summe: " + summe);
        }
        int pruefziffer = summe % 10;

        if (pruefziffer == kartennummer[kartennummer.length - 1]) {
            return true;
        }
        return false;
    }
}
