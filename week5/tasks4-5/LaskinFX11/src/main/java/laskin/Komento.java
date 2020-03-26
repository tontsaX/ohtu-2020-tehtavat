package laskin;

import java.util.HashMap;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
	private TextField tuloskentta; 
    private TextField syotekentta; 
    private Button plus;
    private Button miinus;
    private Button nollaa;
    private Button undo;

    public Komento(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
    }
    
    public abstract void suorita();
}
