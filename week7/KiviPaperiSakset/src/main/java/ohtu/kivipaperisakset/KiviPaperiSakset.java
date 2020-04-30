package ohtu.kivipaperisakset;

public abstract class KiviPaperiSakset implements Pelattava {
	
	protected boolean kaynnissa;
	protected IO konsoli;
	protected Tuomari tuomari;
	protected String pelaaja;
	
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
    		
	        konsoli.print("Ensimmäisen pelaajan siirto: ");
	        ekanSiirto = konsoli.nextLine();
	        
	        toisenPelaajanSiirto();
	        
	        tarkistaTaiKirjaaSiirrot();

	        tulostaPistetilanne();
    	}
	};
	
	protected abstract void toisenPelaajanSiirto();
	
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
	
	protected void tarkistaTaiKirjaaSiirrot() {
		if(!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) {
        	kaynnissa = false;
        } else {
        	tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
        }
	}

}
