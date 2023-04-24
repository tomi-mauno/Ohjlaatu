package kivipaperisakset;

/**
 *
 * Main-luokka
 */
public class Peli {

    public static void main(String args[]) {
        Kps kps = new Kps(new Pelaaja(1),new Pelaaja(2));
        kps.kaynnistaPeli();
    }
}
