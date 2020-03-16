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
    public void ostoksenPaaytyttyaTilisiirtoKutsutaanOikeillaArvoilla() {
        // tehdään ostokset
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        kauppa.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        // oikeilla parametreilla
        // asiakas, viitegeneraattorin viitenro, as.tili, kaupan tili, summa
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);   
    }
	
	@Test
	public void ostostenPaatyttyaTilisiirtoKutsutaanOikeallaSummalla() {
        // tehdään ostokset
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 7);
	}
	
	@Test
	public void ostetaanKaksiSamaaTuotettaJaLaskutetaanOikein() {
		
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 10);
	}
	
	@Test
	public void ostetaanTuoteJotaOnVarastossaJaTuoteJotaEiOleVarastossa() {
		when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "kama", 4));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        kauppa.lisaaKoriin(3);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
	}
	
}
