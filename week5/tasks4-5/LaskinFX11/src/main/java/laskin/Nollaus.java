package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaus extends Sovelluslogiikka {

	public Nollaus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
		super(tuloskentta, syotekentta, nollaa, undo);
	}

	@Override
	public void suorita() {
		TULOS = 0;
		syotekentta.setText("");
		tuloskentta.setText("" + TULOS);
		nollaa.disableProperty().set(true);
	}

	@Override
	public int laske() {
		return 0;
	}

}
