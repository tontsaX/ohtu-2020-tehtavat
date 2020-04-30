package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    public KPSPelaajaVsPelaaja(IO io) {
		super(io);
	}

	@Override
	protected void toinenSiirto() {
		konsoli.print("Toisen pelaajan siirto: ");
		tokanSiirto = konsoli.nextLine();
	}

}