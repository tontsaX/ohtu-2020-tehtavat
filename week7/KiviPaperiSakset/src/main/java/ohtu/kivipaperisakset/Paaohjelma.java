package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	uusiOhjelma();
//        while (true) {
//            System.out.println("\nValitse pelataanko"
//                    + "\n (a) ihmistä vastaan "
//                    + "\n (b) tekoälyä vastaan"
//                    + "\n (c) parannettua tekoälyä vastaan"
//                    + "\nmuilla valinnoilla lopetataan");
//
//            String vastaus = scanner.nextLine();
//            if (vastaus.endsWith("a")) {
//                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
//                KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
//                kaksinpeli.pelaa();
//            } else if (vastaus.endsWith("b")) {
//                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
//                KPSTekoaly yksinpeli = new KPSTekoaly();
//                yksinpeli.pelaa();
//            } else if (vastaus.endsWith("c")) {
//                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
//                KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly();
//                pahaYksinpeli.pelaa();
//            } else {
//                break;
//            }
//
//        }

    }
    
    public static void uusiOhjelma() {
    	IO konsoli = new KonsoliIO();
    	
    	konsoli.print("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla peli lopetetaan"
                + "Syötä valinta: ");
    	
    	Pelattava kpsPeli = KiviPaperiSakset.uusiPeli(konsoli.nextLine(), konsoli);
    	
    	if(kpsPeli != null) {
    		kpsPeli.pelaa();
    	}
    	
    	konsoli.println("Peli päättyi.");
    	konsoli.println("Kiitos pelaamisesta!");
    }
}
