package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class LaskuToimitus extends Komento {
	
	//protected int arvo;
	//protected int tulos;
	protected static int ARVO;

	public LaskuToimitus(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa,
			Button undo) {
		super(tuloskentta, syotekentta, plus, miinus, nollaa, undo);
	}
	
	@Override
	public void suorita() {
		//int arvo = 0;
		try {
            ARVO = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
		
		//TULOS = laske(TULOS, arvo);
		syotekentta.setText("");
        tuloskentta.setText("" + laske());
        
        if(TULOS == 0) {
        	nollaa.disableProperty().set(true);
        } else {
        	nollaa.disableProperty().set(false);
        }
	}
	
	public abstract int laske();
}
