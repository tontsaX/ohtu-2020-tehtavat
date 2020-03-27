package laskin;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
    
	private HashMap<Button, Komento> komennot;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button ynnaa, Button vahenna, Button nollaa, Button undo) {
    	//undo.disableProperty().set(false);
    	Muisti muisti = Muisti.alusta();
    	komennot = new HashMap<>();
    	komennot.put(ynnaa, new Summa(tuloskentta, syotekentta, nollaa, undo, muisti));
    	komennot.put(vahenna, new Erotus(tuloskentta, syotekentta, nollaa, undo, muisti));
    	komennot.put(nollaa, new Nollaus(tuloskentta, syotekentta, nollaa, undo, muisti));
    	komennot.put(undo, new Undo(tuloskentta, syotekentta, nollaa, undo, muisti));
    }
    
    @Override
    public void handle(Event event) {
        komennot.get(event.getTarget()).suorita();
    }

}
