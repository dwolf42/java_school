package school.threads.printxxx;

import java.util.ArrayList;
import java.util.Random;

class MyThread extends Thread {
    private String text;
    private int runden;
    private int warteZeit;

    public MyThread(String text, int runden, int warteZeit) {
        this.text = text; // anzuzeigender Text
        this.runden = runden; // wie viele Runden solls laufen
        this.warteZeit = warteZeit; // wie lang zwischen den Runden soll gewartet werden
    }

    public void run() {
        try { // wegen sleep() nötig
            for (int i = 0; i < runden; i++) {
                Thread.sleep(warteZeit);
                System.out.println(text);
            }
            System.out.println("Fertig: " + text + "\n");
        } catch (InterruptedException e) {
        }
    }
}

class ThreadBasics {
    public static void main(String[] args) {
        ArrayList<MyThread> myThreads = new ArrayList<>();
            myThreads.add(new MyThread("Biep", 10, new Random().nextInt(3000 - 1000 + 1) + 1000));
            myThreads.getLast().start();
            myThreads.add(new MyThread("Boop", 10, new Random().nextInt(3000 - 1000 + 1) + 1000));
            myThreads.getLast().start();
            myThreads.add(new MyThread("Buup", 10, new Random().nextInt(3000 - 1000 + 1) + 1000));
            myThreads.getLast().start();
        }
    }
