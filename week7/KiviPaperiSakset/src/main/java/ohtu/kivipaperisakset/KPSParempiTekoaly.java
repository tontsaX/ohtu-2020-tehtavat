package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {


	public KPSParempiTekoaly(IO io) {
		super(io);
	}

	@Override
    public void pelaa() {
        TekoalyParannettu tekoaly = new TekoalyParannettu(20);
        kaynnissa = true;
        
        while(kaynnissa) {
        	tulostaOhjeet();
	        konsoli.print("Ensimmäisen pelaajan siirto: ");
	        String ekanSiirto = konsoli.nextLine();
	
	        String tokanSiirto = tekoaly.annaSiirto();
	        konsoli.println("Tietokone valitsi: " + tokanSiirto);
	
	        tekoaly.asetaSiirto(ekanSiirto);
        
	        if(!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) {
	        	kaynnissa = false;
	        } else {
	        	tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
	        	
	        }
	
	        tulostaPistetilanne();
        }
    }

}
