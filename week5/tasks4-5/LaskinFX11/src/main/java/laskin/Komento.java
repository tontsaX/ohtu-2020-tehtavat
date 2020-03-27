package laskin;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
	protected TextField tuloskentta; 
    protected TextField syotekentta; 
    protected Button nollaa;
    protected Button undo;
    protected Muisti muisti;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Muisti muisti) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.muisti = muisti;
    }
    
    public abstract void suorita();
}
