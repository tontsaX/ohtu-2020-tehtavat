package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Sovelluslogiikka {

	public Erotus(TextField tuloskentta, TextField syotekentta,  Button nollaa, Button undo) {
		super(tuloskentta, syotekentta, nollaa, undo);
	}

	@Override
	public int laske() {
		return tulos -= arvo;
	}

}
