package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        // seuraavassa osoitteessa 27.11.2019 päivitetyt tilastot
        String url = "https://nhl27112019.herokuapp.com/players.txt";
        // ajan tasalla olevat tilastot osoitteessa
        // "https://nhlstatisticsforohtu.herokuapp.com/players.txt"

        Statistics stats = new Statistics(new PlayerReaderImpl(url));
          
//        Matcher m = new And( new HasAtLeast(5, "goals"),
//                             new HasAtLeast(5, "assists"),
//                             new PlaysIn("PHI")
//        );
        
          // The new classes are pretty much copy paste from the already existing classes
//        Matcher m = new And(
//        		new Not( new HasAtLeast(1, "goals") ),
//        		new PlaysIn("NYR")
//        );
        
//        Matcher m = new And(
//        		new HasFewerThan(1, "goals"),
//        		new PlaysIn("NYR")
//        );
        
        Matcher m = new All(new HasAtLeast(6, "goals"));
        
        
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
