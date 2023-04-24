package kivipaperisakset;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Testi {
	
	Kps testattava = new Kps(new Pelaaja(1),new Pelaaja(2));
	Pelaaja testiPelaaja = new Pelaaja(1);
	
	//validointi-testit

	@ParameterizedTest
	@ValueSource(strings = ("baskdjb09((()U"))
	public void vaaraSyote(String vaara) {		
		assertTrue(testattava.validoiSyote(vaara));
	}
	
	@ParameterizedTest
	@ValueSource(strings = ("kivi"))
	public void kiviSyote(String kivi) {		
		System.out.print(kivi);
		assertTrue(testattava.validoiSyote(kivi));
	}
	
	@ParameterizedTest
	@ValueSource(strings = ("paperi"))
	public void paperiSyote(String paperi) {		
		System.out.print(paperi);
		assertTrue(testattava.validoiSyote(paperi));
	}
	
	@ParameterizedTest
	@ValueSource(strings = ("sakset"))
	public void saksetSyote(String sakset) {		
		System.out.print(sakset);
		assertTrue(testattava.validoiSyote(sakset));
	}
	
	//valinta-testi
	
	@ParameterizedTest
	@ValueSource(strings = ("sakset"))
	public void valintaTesti1(String sakset) {		
		testiPelaaja.setValinta(sakset);
		
		if(testiPelaaja.getValinta().equals(sakset)) {
			
		}else {
			fail();
		}
	}
	
}
