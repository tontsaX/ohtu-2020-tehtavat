package ohtu.kivipaperisakset;

public abstract class KiviPaperiSakset implements Pelattava {
	
	protected boolean kaynnissa;
	protected IO konsoli;
	protected Tuomari tuomari;
	protected String pelaaja;
	
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
	
	public void pelaa() {
		
	};
	
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
	

}
