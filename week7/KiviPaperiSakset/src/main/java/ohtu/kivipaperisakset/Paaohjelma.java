package ohtu.kivipaperisakset;

public class Paaohjelma {

    public static void main(String[] args) {
    	IO konsoli = new KonsoliIO();
    	
    	konsoli.print("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla peli lopetetaan"
                + "\nSyötä valinta: ");
    	
    	KiviPaperiSakset kpsPeli = KiviPaperiSakset.uusiPeli(konsoli.nextLine(), konsoli);
    	
    	if(kpsPeli != null) {
    		kpsPeli.pelaa();
    	}
    	
    	konsoli.println("Peli päättyi.");
    	konsoli.println("Kiitos pelaamisesta!");
    }
    
}
