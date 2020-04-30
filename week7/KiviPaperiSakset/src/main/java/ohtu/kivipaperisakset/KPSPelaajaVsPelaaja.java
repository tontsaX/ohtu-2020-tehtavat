package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    public KPSPelaajaVsPelaaja(IO io) {
		super(io);
	}

    @Override
    public void pelaa() {
    	kaynnissa = true;
    	
    	while(kaynnissa) {
    		tulostaOhjeet();
    		
	        konsoli.print("Ensimmäisen pelaajan siirto: ");
	        String ekanSiirto = konsoli.nextLine();
	        
	        konsoli.print("Toisen pelaajan siirto: ");
	        String tokanSiirto = konsoli.nextLine();
	        
	        if(!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) {
	        	kaynnissa = false;
	        } else {
	        	tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
	        }

	        tulostaPistetilanne();
    	}
    }

}