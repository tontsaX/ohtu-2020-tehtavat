package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KiviPaperiSakset {

    public KPSTekoaly(IO io) {
		super(io);
	}

	@Override
    public void pelaa() {
        Tekoaly tekoaly = new Tekoaly();
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