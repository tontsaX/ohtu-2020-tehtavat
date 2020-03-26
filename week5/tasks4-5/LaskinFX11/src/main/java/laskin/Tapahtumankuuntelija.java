package laskin;

import java.util.HashMap;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
    
	private HashMap<Button, Komento> komennot = new HashMap<>();

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button ynnaa, Button vahenna, Button nollaa, Button undo) {
    	undo.disableProperty().set(false);
    	komennot.put(ynnaa, new Summa(tuloskentta, syotekentta, ynnaa, vahenna, nollaa, undo));
    	komennot.put(vahenna, new Erotus(tuloskentta, syotekentta, ynnaa, vahenna, nollaa, undo));
    	komennot.put(nollaa, new Nollaus(tuloskentta, syotekentta, ynnaa, vahenna, nollaa, undo));
    	komennot.put(undo, new Undo(tuloskentta, syotekentta, ynnaa, vahenna, nollaa, undo));
    }
    
    @Override
    public void handle(Event event) {
    	
        komennot.get(event.getTarget()).suorita();
    }

}
