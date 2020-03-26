package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class LaskuToimitus extends Komento {
	
	//protected int arvo;
	//protected int tulos;

	public LaskuToimitus(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa,
			Button undo) {
		super(tuloskentta, syotekentta, plus, miinus, nollaa, undo);
	}
	
	@Override
	public void suorita() {
		int arvo = 0;
		try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
		
		int tulos = Komento.TULOS;
		Komento.TULOS = laske(tulos, arvo);
		syotekentta.setText("");
        tuloskentta.setText("" + Komento.TULOS);
	}
	
	public abstract int laske(int arvo1, int arvo2);
}
