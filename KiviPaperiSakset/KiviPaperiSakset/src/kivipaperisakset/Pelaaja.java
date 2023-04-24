
package kivipaperisakset;

/**
 * 
 * T‰m‰ luokka sis‰lt‰‰ pelaajiin liittyv‰t tiedot, ja metodit
 *
 */
public class Pelaaja {

	/**
	 * Pelaajan voitot
	 */
    int voitot;
    /**
     * Pelaajan numero
     */
    int pelaajaNum;
    
    /**
     * Pelaajan konstruktori, jossa annetaan parametrija pelaajanumero
     * @param num Pelaajan numero
     */
    public Pelaaja (int num) {
    	this.pelaajaNum = num;
    }
    
    /**
     * Pelaajan valinta
     */
    String valinta;

    /**
     * Kasvattaa voittoja yhdell‰, ja asettaa sen voittojen uudeksi arvoksi
     * @return
     */
    public int setVoitot() {
        voitot++;
        return voitot;
    }
    
    /**
     * palauttaa voitot
     * @return pelaajan voitot
     */
    public int getVoitot() {
        return (voitot);
    }
    
    /**
     * asettaa valinnan pelaajalle, ja palauttaa sen
     * @param valinta annettu valinta
     * @return pelaajan uusi valinta
     */
    public String setValinta(String valinta) {
    	this.valinta = valinta;
    	return getValinta();
    }
    
    /**
     * palauttaa valinnan
     * @return pelaajan valinta
     */
    public String getValinta() {
    	return valinta;
    }
    
    /**
     * palauttaa pelaajan numeron
     * @return pelaajan numero
     */
    public int getNum() {
    	return pelaajaNum;
    }
}
