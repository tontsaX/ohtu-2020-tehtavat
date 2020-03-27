package laskin;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Undo extends Sovellus {

	public Undo(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Muisti muisti) {
		super(tuloskentta, syotekentta, nollaa, undo, muisti);
	}

	@Override
	public void toimi() {
		System.out.println("Undo pressed");
		palaaEdelliseenTulokseen();
	}
	
	private void palaaEdelliseenTulokseen() {
		int index = muisti.getIndex();
		ArrayList<Integer> tulokset = muisti.getTulokset();
		
		tulokset.remove(index);
		
		muisti.setTulokset(tulokset);
		muisti.setIndex(--index);
		
		tulos = muisti.getTulos();
	}

}
