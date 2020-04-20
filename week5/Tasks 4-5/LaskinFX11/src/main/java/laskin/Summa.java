package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Laskenta {

	public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Muisti muisti) {
		super(tuloskentta, syotekentta, nollaa, undo, muisti);
	}

	@Override
	public int laske() {
		return tulos += arvo;
	}
}
