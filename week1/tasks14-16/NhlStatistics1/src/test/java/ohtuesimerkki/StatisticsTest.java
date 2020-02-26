package ohtuesimerkki;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
	Reader readerStub = new Reader() {
		 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  

    // Statistics-luokka
    
    // konstruktoritestit
    @Test
    public void konstruktoriLuoOikeanTilaston() {
    	assertThat(stats.getPlayers().toString(), is(readerStub.getPlayers().toString()));
    }
    
    @Test
    public void haePelaajaTuottaaOikeanTuloksen() {
    	List<Player> players = readerStub.getPlayers();
    	assertThat(stats.search("Semenko").toString(), is(players.get(0).toString()));
    }
    
    @Test
    public void pelaajaEiLoydyPalauttaaNull() {
    	Player notExists = null;
    	assertThat(stats.search("Koivula"), is(notExists));
    }
    
    @Test
    public void teamPalauttaaOikeanJoukkueen() {
    	List<Player> players = new ArrayList<>();
    	players.add(new Player("Semenko", "EDM", 4, 12));
    	players.add(new Player("Kurri",   "EDM", 37, 53));
    	players.add(new Player("Gretzky", "EDM", 35, 89));
    	
    	assertThat(stats.team("EDM").toString(), is(players.toString()));
    }
    
    // topScorers() test
    @Test
    public void topPisteetJarjestysOikein() {
    	List<Player> topScorers = readerStub.getPlayers();
    	Collections.sort(topScorers);
    	
    	assertThat(stats.topScorers(4).toString(), is(topScorers.toString()));
    }
    
    // Player-luokka
    @Test
    public void asetaSyotot() {
    	stats.getPlayers().get(0).setAssists(10);
    	assertThat(stats.getPlayers().get(0).getAssists(), is(10));
    }
    
    @Test
    public void asetaMaalit() {
    	stats.getPlayers().get(0).setGoals(5);
    	assertThat(stats.getPlayers().get(0).getGoals(), is(5));
    }
    
    @Test
    public void asetaPelaajanNimi() {
    	stats.getPlayers().get(0).setName("Tallervo");
    	assertThat(stats.getPlayers().get(0).getName(), is("Tallervo"));
    }
    
    @Test
    public void asetaJoukkeenNimi() {
    	stats.getPlayers().get(0).setTeam("TAMPA");
    	assertThat(stats.getPlayers().get(0).getTeam(), is("TAMPA"));
    }
    
}
