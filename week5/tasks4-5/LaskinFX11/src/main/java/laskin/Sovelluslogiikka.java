package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Sovelluslogiikka extends Komento {
	
	//protected int arvo;
	//protected int tulos;
	protected static int TULOS;
	protected static int ARVO;

	public Sovelluslogiikka(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
		super(tuloskentta, syotekentta, nollaa, undo);
	}
	
	@Override
	public void suorita() {
		
		try {
            ARVO = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
		
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
