package laskin;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Laskenta extends Sovellus {
	
	public Laskenta(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Muisti muisti) {
		super(tuloskentta, syotekentta, nollaa, undo, muisti);
	}

	@Override
	public void toimi() {
		try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
		
		tulos = muisti.getTulos();
		
		muisti.addTulos(laske());
		
		arvo = 0;
	}
	
	public abstract int laske();
}
