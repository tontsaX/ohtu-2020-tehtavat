package laskin;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Sovelluslogiikka extends Komento {

	protected int tulos;
	protected int arvo;
	
	protected static ArrayList<Integer> TULOKSET;

	public Sovelluslogiikka(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
		super(tuloskentta, syotekentta, nollaa, undo);
		TULOKSET = new ArrayList<>();
	}
	
	@Override
	public void suorita() {
		//undo.disableProperty().set(false);
		try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
		
		toimita();
		syotekentta.setText("");
        tuloskentta.setText("" + tulos);

        tarkistaNollaus();
        
	}
	
	public abstract void toimita();
	
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
