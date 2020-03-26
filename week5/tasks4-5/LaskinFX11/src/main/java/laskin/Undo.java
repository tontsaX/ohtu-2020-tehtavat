package laskin;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Undo extends Sovelluslogiikka {
	
	private ArrayList<Integer> tulokset = new ArrayList<>();

	public Undo(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
		super(tuloskentta, syotekentta, nollaa, undo);
	}

	@Override
	public void suorita() {
		System.out.println("undo pressed");
	}

	@Override
	public int laske() {
		// TODO Auto-generated method stub
		return 0;
	}

}
