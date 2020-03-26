package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Sovelluslogiikka {

	public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
		super(tuloskentta, syotekentta, nollaa, undo);
	}

	@Override
	public int laske() {
		return TULOS += ARVO;
	}
}
