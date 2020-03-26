package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Laskenta extends Sovelluslogiikka {
	
	public Laskenta(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
		super(tuloskentta, syotekentta, nollaa, undo);
	}

	@Override
	public void toimita() {
		tulos = laske();
	}
	
	public abstract int laske();
}
