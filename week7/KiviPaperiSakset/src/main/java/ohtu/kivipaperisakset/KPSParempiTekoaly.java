package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends KPSVaikeusaste {

	public KPSParempiTekoaly(IO io) {
		super(io);
		tekoaly = new ParannettuTekoaly(20);
	}

}
