package ohtu.kivipaperisakset;

public class HelppoTekoaly extends Tekoaly {

    int siirto;

    public HelppoTekoaly() {
        siirto = 0;
    }

    @Override
    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;

        if (siirto == 0) {
            return "k";
        } else if (siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }
}
