package laskin;

import java.util.HashMap;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
	/*
    private TextField tuloskentta; 
    private TextField syotekentta; 
    private Button plus;
    private Button miinus;
    private Button nollaa;
    private Button undo;
    */
	private HashMap<Button, Komento> komennot;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button ynnaa, Button vahenna, Button nollaa, Button undo) {
    	komennot.put(ynnaa, new Summa(tuloskentta, syotekentta, ynnaa, vahenna, nollaa, undo));
    	komennot.put(vahenna, new Erotus(tuloskentta, syotekentta, ynnaa, vahenna, nollaa, undo));
    	komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, ynnaa, vahenna, nollaa, undo));
    	komennot.put(undo, new Undo(tuloskentta, syotekentta, ynnaa, vahenna, nollaa, undo));
    }
    
    @Override
    public void handle(Event event) {
        //int arvo = 0;
 
        /*
        try { // tulee komento-luokkiin
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        */
    	komennot.get(event.getTarget());
 
        // eka arvo annetaan ja se sijoitetaan Sovelluslogiikan tulos muuttujaan
    	/*
        if (event.getTarget() == plus) {
            sovellus.plus(arvo);
        } else if (event.getTarget() == miinus) {
            sovellus.miinus(arvo);
        } else if (event.getTarget() == nollaa) {
            sovellus.nollaa();
        } else {
            System.out.println("undo pressed");
        }
        */
        
        // haetaan tulos Sovelluslogiikka-oliosta
        /*
        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        */
        
        // laskun tulos on nolla, Z-nappi on harmaa
    	/*
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true); 
        } else {
            nollaa.disableProperty().set(false);
        }
        */
        
        //undo.disableProperty().set(false); // undo-nappi on näyvillä, mutta sillä ei ole toiminnallisuutta
    }

}
