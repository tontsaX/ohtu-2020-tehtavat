package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class LaskuToimitus extends Komento {
	
	protected int arvo;
	//protected int tulos;

	public LaskuToimitus(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa,
			Button undo) {
		super(tuloskentta, syotekentta, plus, miinus, nollaa, undo);
	}
	
	@Override
	public void suorita() {
		try {
            this.arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
		
		tulos = laske();
		syotekentta.setText("");
        tuloskentta.setText("" + tulos);
	}
	
	public abstract int laske();
}
