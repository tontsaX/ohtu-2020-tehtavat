package laskin;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Sovellus extends Komento {

	protected int tulos;
	protected int arvo;

	public Sovellus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Muisti muisti) {
		super(tuloskentta, syotekentta, nollaa, undo, muisti);
	}
	
	@Override
	public void suorita() {
		tarkistaUndo();
		
		toimi();
		//tulos = muisti.getTulos();
		
		syotekentta.setText("");
        tuloskentta.setText("" + tulos);
        
        System.out.println(muisti.toString());

        tarkistaNollaus();
	}
	
	public abstract void toimi();
	
	private void tarkistaNollaus() {
		if(tulos == 0) {
        	nollaa.disableProperty().set(true);
        } else {
        	nollaa.disableProperty().set(false);
        }
	}

	private void tarkistaUndo() {
	
	}
	
}
