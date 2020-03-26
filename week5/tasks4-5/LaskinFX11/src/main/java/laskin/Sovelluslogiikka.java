package laskin;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Sovelluslogiikka extends Komento {

	protected int tulos;
	protected int arvo;

	public Sovelluslogiikka(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
		super(tuloskentta, syotekentta, nollaa, undo);
	}
	
	@Override
	public void suorita() {
		
		try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
		
		syotekentta.setText("");
        tuloskentta.setText("" + laske());

        if(tulos == 0) {
        	nollaa.disableProperty().set(true);
        } else {
        	nollaa.disableProperty().set(false);
        }
        
	}
	
	public abstract int laske();
}
