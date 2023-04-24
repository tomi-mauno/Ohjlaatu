package kivipaperisakset;
import java.util.Scanner;

/**
 * 
 * T�m� luokka sis�lt�� kps-peliin liittyv�t tiedot, ja metodit
 *
 */
public class Kps {
	
	/**
	 * pelin pelaajat
	 */
	private Pelaaja p1;
    private Pelaaja p2;
    
    /**
     *  boolean-muuttuja, joka pit�� pelin k�ynniss�
     */
    private boolean peliKaynnissa = true;	
    /**
     *  Er�n numero
     */
    private int eraLkm = 0;          
    /**
     * Tasapelien lkm	
     */
    private int tasapelit = 0;              
	
    /**
     * konstruktorissa annetaan pelin pelaajat
     * @param pelaaja1
     * @param pelaaja2
     */
    public Kps (Pelaaja pelaaja1, Pelaaja pelaaja2) {
    	this.p1 = pelaaja1;
    	this.p2 = pelaaja2;
    }
    
    /**
     * k�ynnist�� pelin
     */
    public void kaynnistaPeli() {
    	while (peliKaynnissa) {
    		//tee vallinnat
    		p1.setValinta(teeValinta(p1));    	
    		p2.setValinta(teeValinta(p2));
    		
            //pelataan er�    		
    		pelaaEra();

    		//tulostetaan pelin tila
    		pelinTila();
    		   		
    		//katsotaan onko jompikumpi voittanut 3 kerta, jos on lopetetaan peli
            if (lopetusEhto()) peliKaynnissa = false;
        } 
        System.out.println("KOLME VOITTOA - PELI P��TTYY");
    }
    
    /**
     * tulostaa pelin tilan
     */
    public void pelinTila() {
    	System.out.println("Er�: " + eraLkm + " =====================\n");
        System.out.println("Tasapelien lukum��r�: "+ tasapelit + "\n");
        System.out.println("Pelaaja 1: " + p1.getValinta() + "\n\t Pelaaja 1:ll� koossa " + p1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2: " + p2.getValinta() + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");
    }
    
    /**
     * pelaa yhden er�n, ja tulostaa er�n voittajan/tasapelin
     */
    public void pelaaEra () {
    	//otetaan valinnat yl�s
        String v1 = p1.getValinta();
        String v2 = p2.getValinta();
        
        //alustetaan voittaja null-arvolla
        Pelaaja voittaja = null;
        
        //tasapeli jos samat valinnat
    	if(v1.equals(v2)) { 
    		tasapelit++;
    		System.out.println("\nTasapeli\n");
    	}
    	//katsotaan ensin ensimm�isen valinnan arvo, t�m�n j�lkeen toisen valinnan arvo m��ritt�� voittajan
    	else if (v1.equals("kivi")) {
    		if(v2.equals("sakset")) {
    			p1.setVoitot();
    			voittaja = p1;
    		}else {
				p2.setVoitot();
				voittaja = p2;
    		}
    	}else if(v1.equals("sakset")) {
    		if(v2.equals("paperi")) {
    			p1.setVoitot();
    			voittaja = p1;
    		}else {
    			p2.setVoitot();
    			voittaja = p2;
    		}
    	}else {
    		if(v2.equals("kivi")) {
    			p1.setVoitot();
    			voittaja = p1;
    		}else {
    			p2.setVoitot();
				voittaja = p2;
    		}
    	}
    	
    	//julistetaan er�n voittaja, jos ei ollut tasapeli
    	if (voittaja != null) System.out.println("\nPelaaja "+voittaja.getNum() +" voittaa!\n");
    	
    	//kasvatetaan pelattujen pelien m��r��
    	eraLkm++;
    }    
    
    /**
     * lopetusehto pelille
     * @return boolean-arvo, joka on false, niin kauan kuin jommallakummalla pelaajista on v�hemm�n kuin 3 voittoa 
     */
    public boolean lopetusEhto() {
    	return (p1.getVoitot() >= 3) || (p2.getVoitot() >= 3) ? true : false;
    }
    
    /**
     * tekee valinnan
     * @param pelaaja joka tekee valinnan
     * @return tehty valinta
     */
    public String teeValinta(Pelaaja pelaaja) {
    	Scanner myObj = new Scanner(System.in);  
   	    String valinta = "";
   	    
    	//kyst��n pelaajalta sy�tett� kunnes se on validi
    	while(validoiSyote(valinta) != true) {
    		System.out.println("Pelaaja num. "+pelaaja.getNum()+", valitse kivi, sakset tai paperi");
    		valinta = myObj.nextLine();
		}
    	return valinta;
    }
    
    /**
     * validoi sy�tteen
     * @param pelaajaValinta pelaajan tekem� valinta
     * @return boolean-arvo joka on true, jos valinta on validi
     */
    public boolean validoiSyote(String pelaajaValinta) {
    	String[] aseet = {"kivi","sakset","paperi"};
    	
    	for(String x : aseet) {
    		if(x.equals(pelaajaValinta)) {
    			return true;
    		}
    	}
    	return false;
    }
}
