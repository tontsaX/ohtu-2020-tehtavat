package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends LaskuToimitus {

	public Erotus(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa,
			Button undo) {
		
		super(tuloskentta, syotekentta, plus, miinus, nollaa, undo);
	}

	@Override
	public int laske() {
		return tulos -= arvo;
	}

}
