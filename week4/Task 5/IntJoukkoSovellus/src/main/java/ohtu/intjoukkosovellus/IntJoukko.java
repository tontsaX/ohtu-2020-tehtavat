
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, 	 // aloitustaulukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    											 // näin paljon isompi kuin vanha
    
    private int kasvatuskoko; // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm; // Tyhjässä joukossa alkioiden_määrä on nolla. 
    
    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        
        ljono = new int[kapasiteetti];
        
        alkioidenLkm = 0;
        
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }

        ljono = new int[kapasiteetti];
        
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            ljono[0] = luku;
            alkioidenLkm++;
            return true;
        } 
        if(!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            vertaaAlkioidenMaaraaJaLukuJononPituutta();
            return true;
        }
        return false;
    }
    
    private void vertaaAlkioidenMaaraaJaLukuJononPituutta() {
    	if (alkioidenLkm % ljono.length == 0) {
            int[] taulukkoOld = new int[ljono.length];
            taulukkoOld = ljono;
            kopioiTaulukko(ljono, taulukkoOld);
            ljono = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoOld, ljono);
        }
    }

    public boolean kuuluu(int luku) {
    	for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
    	return false;
    }

    public boolean poista(int luku) {

        if(kuuluu(luku)) {
        	int index = getIndexOf(luku);

        	lyhennaLukuJonoa(index);
            
            return true;
        }

        return false;
    }

    private int getIndexOf(int luku) {
    	
    	for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
            	return i;
            }
        }
    	
    	return 0;
    }
    
    private void lyhennaLukuJonoa(int index) {
    	for (int j = index; j < alkioidenLkm - 1; j++) {
            int apu = ljono[j];
            ljono[j] = ljono[j + 1];
            ljono[j + 1] = apu;
        }
    	
    	alkioidenLkm--;
    }
    
    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } 
        else {
        	return muodostaLJonostaString();
        }
    }
    
    private String muodostaLJonostaString() {
    	String tuotos = "{";
    	for (int i = 0; i < alkioidenLkm -1; i++) {
            tuotos += ljono[i];
            if(alkioidenLkm > 1) {
            	tuotos += ", ";
            }
        }
    	tuotos += ljono[alkioidenLkm - 1];
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdistelma = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        lisaaTaulukkoJoukkoon(yhdistelma, aTaulu);
        lisaaTaulukkoJoukkoon(yhdistelma, bTaulu);
        
        return yhdistelma;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
    	IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        
        for(int i = 0; i < aTaulu.length; i++) {
            for(int j = 0; j < bTaulu.length; j++) {
        	    if(aTaulu[i] == bTaulu[j]) {
                    leikkaus.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkaus;
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        IntJoukko uusiJoukko = yhdiste(a, b);
        
        int[] bTaulu = b.toIntArray();
        
        for (int i = 0; i < bTaulu.length; i++) {
        	uusiJoukko.poista(bTaulu[i]);
        }
        
        return uusiJoukko;
    }
        
    private static void lisaaTaulukkoJoukkoon(IntJoukko joukko, int[] lisaa) {
    	for (int i = 0; i < lisaa.length; i++) {
        	joukko.lisaa(lisaa[i]);
        }
    }
    
    private static IntJoukko uusiJoukko(int[]... taulukoista) {
    	IntJoukko uusiJoukko = new IntJoukko();
    	
    	for(int[] taulukko: taulukoista) {
    		lisaaTaulukkoJoukkoon(uusiJoukko, taulukko);
    	}
    	
    	return uusiJoukko;
    }
}
