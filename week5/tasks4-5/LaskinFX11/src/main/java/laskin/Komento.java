package laskin;

import java.util.HashMap;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
	protected TextField tuloskentta; 
    protected TextField syotekentta; 
    protected Button plus;
    protected Button miinus;
    protected Button nollaa;
    protected Button undo;
    
    protected int tulos;

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
