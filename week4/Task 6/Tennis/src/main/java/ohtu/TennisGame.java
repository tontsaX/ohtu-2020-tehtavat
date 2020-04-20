package ohtu;

public class TennisGame {
	
    private int p1_score = Score.LOVE;
    private int p2_score = Score.LOVE;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            p1_score += Score.FIFTEEN;
        else
            p2_score += Score.FIFTEEN;
    }

    public String getScore() {
        String scoreTxt = "";

        if (evenScore()) {
        	scoreTxt = even();
        }
        else if (scoreOverForty()) {
        	scoreTxt = getAdvantageTxt();
        }
        else {
        	scoreTxt += getPlayerScore(p1_score);
        	scoreTxt += "-";
        	scoreTxt += getPlayerScore(p2_score);
        }
        
        return scoreTxt;
    }
    
    private void checkScore() {
    	
    }
    
    private String getPlayerScore(int playerScore) {
    	String scoreTxt = "";
    	
    	switch(playerScore) {
	        case Score.LOVE:
	            scoreTxt = "Love";
	            break;
	        case Score.FIFTEEN:
	            scoreTxt = "Fifteen";
	            break;
	        case Score.THIRTY:
	            scoreTxt = "Thirty";
	            break;
	        case Score.FORTY:
	            scoreTxt = "Forty";
	            break;
	        default:
	        	break;
    	}
    	
    	return scoreTxt;
    }
    
    private boolean evenScore() {
    	return p1_score == p2_score;
    }
    
    private String even() {
    	String returnTxt = "";
    	
    	switch (p1_score) {
	        case Score.LOVE:
	            returnTxt = "Love-All";
	            break;
	        case Score.FIFTEEN:
	            returnTxt = "Fifteen-All";
	            break;
	        case Score.THIRTY:
	            returnTxt = "Thirty-All";
	            break;
	        case Score.FORTY:
	            returnTxt = "Forty-All";
	            break;
	        default:
	            returnTxt = "Deuce";
	            break;     
    	}
    	
    	return returnTxt;
    }
    
    private boolean scoreOverForty() {
    	return p1_score >= Score.OVER_FORTY || p2_score >= Score.OVER_FORTY;
    }
    
    private String getAdvantageTxt() {
    	String scoreTxt = "";
    	int scoreDifference = p1_score - p2_score;
        
    	if(advantage(scoreDifference)) {
    		scoreTxt = getAdvantage(scoreDifference);
        }
        else if (winner(scoreDifference)) {
         	scoreTxt = getWinner(scoreDifference);
        }

        return scoreTxt;
    }
    
    private boolean advantage(int scoreDifference) {
    	return scoreDifference == 1 || scoreDifference == -1;
    }
    
    private String getAdvantage(int scoreDifference) {
    	if(scoreDifference == 1) {
        	return "Advantage " + player1Name;
        }
        else {
        	return "Advantage " + player2Name;
        }    	
    }
    
    private boolean winner(int scoreDifference) {
    	return scoreDifference == 0 || scoreDifference < -1 || scoreDifference >=2;
    }
    
    private String getWinner(int scoreDifference) {
    	if(scoreDifference == 0 || scoreDifference < -1) {
    		return "Win for " + player2Name;
    	}
    	else {
    		return "Win for " + player1Name;
    	}
    }
    
    private static class Score {
		public static final int LOVE = 0;
		public static final int FIFTEEN = 1;
		public static final int THIRTY = 2;
		public static final int FORTY = 3;
		public static final int OVER_FORTY = 4;
	}
}