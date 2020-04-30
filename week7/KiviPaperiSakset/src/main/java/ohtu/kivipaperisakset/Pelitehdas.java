package ohtu.kivipaperisakset;

public class Pelitehdas {

	public static KiviPaperiSakset kaksinpeli(IO io) {
		return new KPSPelaajaVsPelaaja(io);
	}
	
	public static KiviPaperiSakset yksinpeliHelppo(IO io) {
		return new KPSTekoaly(io);
	}
	
	public static KiviPaperiSakset yksinpeliVaikea(IO io) {
		return new KPSParempiTekoaly(io);
	}
}
