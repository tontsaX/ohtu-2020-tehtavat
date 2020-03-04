package ohtu.verkkokauppa;

public class Viitegeneraattori implements IViitegen {

    private static IViitegen instanssi;

    public static IViitegen getInstance() {
        if (instanssi == null) {
            instanssi = new Viitegeneraattori();
        }

        return instanssi;
    }
    
    private int seuraava;
    
    private Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
	public int uusi(){
        return seuraava++;
    }
}
