package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class KauppaTest {
	
	private Pankki pankki;
	private Viitegeneraattori viite;
	private Varasto varasto;
	private Kauppa kauppa;
	
	@Before
	public void setUp() {
		pankki = mock(Pankki.class);

        viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);
        varasto = mock(Varasto.class);
        
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(5);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "kama", 2));
        
		kauppa = new Kauppa(varasto, pankki, viite);
	}
	
	@Test
	public void varmistetaanEttaAloitaAsiointiNollaaOstokset() {
		// tehdään ostokset
		asioiKaupassa(true, 1); // ostetaan maitoa ja suoritetaan tilimaksu
		verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
		
		kauppa.aloitaAsiointi();
		kauppa.tilimaksu("pekka", "12345");
		verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 0);
	}
	
	@Test
    public void ostoksenPaaytyttyaTilisiirtoKutsutaanOikeillaArvoilla() {
		asioiKaupassa(true, 1);
		verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }
	
	@Test
	public void ostostenPaatyttyaTilisiirtoKutsutaanOikeallaSummalla() {
        asioiKaupassa(true, 1, 2); // ostetaan maitoa ja jotain muuta ja suoritetaan tilimaksu

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 7);
	}
	
	@Test
	public void ostetaanKaksiSamaaTuotettaJaLaskutetaanOikein() {
        asioiKaupassa(true, 1, 1);
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 10);
	}
	
	@Test
	public void ostetaanTuoteJotaOnVarastossaJaTuoteJotaEiOleVarastossa() {
		when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "kama", 4));

        asioiKaupassa(true, 1, 3);

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
	}
	
	@Test
	public void KauppaPyytaaUudenViitenumeron() {
		when(viite.uusi()).
        thenReturn(1).
        thenReturn(2);

		asioiKaupassa(true, 1);
        
        verify(pankki).tilisiirto("pekka", 1, "12345", "33333-44455", 5);

        asioiKaupassa(true, 1);        

        verify(pankki).tilisiirto("pekka", 1, "12345", "33333-44455", 5);
	}
	
	@Test
	public void varmistaEttaPoistettuaTuotettaEiVeloiteta() {
		asioiKaupassa(false, 1, 2);
		kauppa.poistaKorista(2);
		kauppa.tilimaksu("pekka", "12345");
		
		verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
	}
	
	private void asioiKaupassa(boolean tilimaksu, int... idt) {		
		kauppa.aloitaAsiointi();
		
		// lisää tuotteet
		for(int id: idt) {
			kauppa.lisaaKoriin(id);
		}
		
		// suorita tilimaksu täällä
		if(tilimaksu) {
			kauppa.tilimaksu("pekka", "12345");
		}
	}
}
