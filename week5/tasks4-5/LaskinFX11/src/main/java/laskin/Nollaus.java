package laskin;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaus extends Sovellus {

	public Nollaus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Muisti muisti) {
		super(tuloskentta, syotekentta, nollaa, undo, muisti);
	}
	
	@Override
	public void toimi() {
		nollaaLaskin();
	}
	
	private void nollaaLaskin() {
		ArrayList<Integer> tulokset = new ArrayList<>();
		tulokset.add(0);
		muisti.setTulokset(tulokset);
		muisti.setIndex(0);
	}
}
