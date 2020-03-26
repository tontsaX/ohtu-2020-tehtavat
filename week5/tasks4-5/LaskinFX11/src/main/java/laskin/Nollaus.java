package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaus extends Komento {

	public Nollaus(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa,
			Button undo) {
		super(tuloskentta, syotekentta, plus, miinus, nollaa, undo);
	}

	@Override
	public void suorita() {
		/*
		int arvo = 0;
		
		try {
            arvo = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }
		
		if (arvo == 0) {
            nollaa.disableProperty().set(true); 
        } else {
            nollaa.disableProperty().set(false);
        }
        */
		TULOS = 0;
		syotekentta.setText("");
		tuloskentta.setText("" + TULOS);
	}

}
