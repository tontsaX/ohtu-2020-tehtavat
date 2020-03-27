package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Sovellus extends Komento {

	protected int tulos;

	public Sovellus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Muisti muisti) {
		super(tuloskentta, syotekentta, nollaa, undo, muisti);
	}
	
	@Override
	public void suorita() {
		
		toimi();
		//tulos = muisti.getTulos();
		
		syotekentta.setText("");
        tuloskentta.setText("" + tulos);
        
        System.out.println(muisti.toString());
        System.out.println(muisti.getIndex());
        
        asetaNollausJaUndo();
        
	}
	
	public abstract void toimi();
	
	private void asetaNollausJaUndo() {
		
		if(muisti.getTulokset().size() > 1) {
			
			nollaa.disableProperty().set(false);
			undo.disableProperty().set(false);
			
		} else {
			
			undo.disableProperty().set(true);
			nollaa.disableProperty().set(true);
			
		}
		
	}
	
}
