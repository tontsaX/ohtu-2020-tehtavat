package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Undo extends Komento {

	public Undo(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
		super(tuloskentta, syotekentta, nollaa, undo);
	}

	@Override
	public void suorita() {
		System.out.println("undo pressed");
	}

}
