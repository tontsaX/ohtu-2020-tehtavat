package ohtu.kivipaperisakset;

public class KPSVaikeusaste extends KiviPaperiSakset {
	
	protected Tekoaly tekoaly;

	protected KPSVaikeusaste(IO io) {
		super(io);
	}

	@Override
	protected void toisenPelaajanSiirto() {
		tokanSiirto = tekoaly.annaSiirto();
        konsoli.println("Tietokone valitsi: " + tokanSiirto);
	}
}
