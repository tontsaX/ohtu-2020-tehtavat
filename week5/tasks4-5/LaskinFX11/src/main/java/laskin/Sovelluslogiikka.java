package laskin;

public class Sovelluslogiikka {
 
    private int tulos;
 
    public void plus(int arvo) {
        tulos += arvo;
    }
     
    public void miinus(int arvo) {
        tulos -= arvo;
    }
 
    public void nollaa() {
        tulos = 0;
    }
 
    public int tulos() {
        return tulos;
    }
}