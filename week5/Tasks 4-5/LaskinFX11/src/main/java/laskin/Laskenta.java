package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Laskenta extends Sovellus {
	
	protected int arvo;
	
	public Laskenta(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Muisti muisti) {
		super(tuloskentta, syotekentta, nollaa, undo, muisti);
	}

	@Override
	public void toimi() {
		arvo = 0;
		
		try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
		
		tulos = muisti.getTulos();
		
		if(arvo != 0) {
			muisti.addTulos(laske());
		}
	}
	
	public abstract int laske();
}
