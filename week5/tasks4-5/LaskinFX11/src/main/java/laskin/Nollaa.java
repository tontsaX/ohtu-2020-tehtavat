package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

	public Nollaa(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa,
			Button undo) {
		super(tuloskentta, syotekentta, plus, miinus, nollaa, undo);
	}

	@Override
	public void suorita() {
		if (tulos == 0) {
            nollaa.disableProperty().set(true); 
        } else {
            nollaa.disableProperty().set(false);
        }
	}

}
