
package ohtu;

import java.util.Comparator;

public class Player {
    private String name, team, nationality, birthdate;
    private int goals, assists, penalties;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}
	
	public int points() {
		return this.goals + this.assists;
	}
    
    @Override
    public String toString() {
        return name + " "
        		+ team + " "
        		+ goals + " + "
        		+ assists + " = "
        		+ points();
    }
    
    // sorts a collection of players by their points
    // Comparator käytössä, koska näin voidaan lisätä enemmän tapoja, joilla lajitella pelaajakokoelma
    public static Comparator<Player> PlayerPoints = new Comparator<Player>() {
    	public int compare(Player p1, Player p2) {
    		
    		// kasvava järjestys
    		//return p1.points()-p2.points();
    		
    		// laskeva järjestys
    		return p2.points()-p1.points();
    	}
    };
}
