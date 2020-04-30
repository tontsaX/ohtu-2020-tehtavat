package ohtu.kivipaperisakset;

public abstract class KiviPaperiSakset implements Pelattava {
	
	protected IO konsoli;
	protected Tuomari tuomari;
	
	protected boolean kaynnissa;
	protected String ekanSiirto, tokanSiirto;
	
	protected KiviPaperiSakset(IO io) {
		konsoli = io;
		tuomari = new Tuomari();
	}

	public static KiviPaperiSakset uusiPeli(String peliMoodi, IO io) {
		KiviPaperiSakset peli = null;
		
		if(peliMoodi.equals("a")) {
			return Pelitehdas.kaksinpeli(io);
		}
		else if(peliMoodi.equals("b")) {
			return Pelitehdas.yksinpeliHelppo(io);
		}
		else if(peliMoodi.equals("c")) {
			return Pelitehdas.yksinpeliVaikea(io);
		}
		
		return peli;
	}
	
	@Override
	public void pelaa() {
		kaynnissa = true;
    	
    	while(kaynnissa) {
    		tulostaOhjeet();
    		
	        ensimmainenSiirto();
	        
	        toinenSiirto();
	        
	        tarkistaJaKirjaaSiirrot();

	        tulostaPistetilanne();
    	}
	};
	
	protected abstract void toinenSiirto();
	
	protected void ensimmainenSiirto() {
		konsoli.print("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = konsoli.nextLine();
	}
	
	protected void tulostaOhjeet() {
		konsoli.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
	}
	
	protected void tulostaPistetilanne() {
		konsoli.print("\n");
        konsoli.println(tuomari.toString());
        konsoli.print("\n");
	}
	
	protected boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
	
	protected void tarkistaJaKirjaaSiirrot() {
		if(!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) {
        	kaynnissa = false;
        } else {
        	tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
        }
	}

}
