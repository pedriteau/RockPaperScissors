public class Game {
	
	private Player player1;
	private Player player2;
	private static Player nullPlayer = new Player("nullPlayer");
	private Player[] winners;
	private Player[] losers;
	private int nWinsPlayer1 = 0;
	private int nWinsPlayer2 = 0;
	
	// Constructor
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	// Play game
	public void play(int nRounds){
		
		// Define winners and losers arrays
		this.winners = new Player[nRounds];
		this.losers = new Player[nRounds];
		
		// Initialize number of wins
		nWinsPlayer1 = 0;
		nWinsPlayer2 = 0;
		
		// Loop over rounds
		for (int iRound = 0; iRound < nRounds; iRound++){
			// Play hands for both players
			player2.playHand();
			player1.playHand();
			
			// Record round winner
			this.winners[iRound] = Game.setHandWinner(player1,player2);
			
			// Increment number of wins
			if (!this.winners[iRound].equals(nullPlayer)) {
				if (this.winners[iRound].equals(player1)){
					this.losers[iRound] = player2;
				}
				else if (this.winners[iRound].equals(player2)){
					this.losers[iRound] = player1;
				}
				if (this.winners[iRound].equals(player1)){
					nWinsPlayer1++;
				}
				else if (this.winners[iRound].equals(player2)){
					nWinsPlayer2++;
				}
			}
			else {
				this.losers[iRound] = nullPlayer;
			}
			
			// Print results of last hand
			printLastHand(iRound);
		}
	}
	
	// Get hand winner
	public static Player setHandWinner(Player player1, Player player2){

		if (player1.getHand().beats(player2.getHand())){
			player1.setFormerResult(RoundResult.WIN);
			player2.setFormerResult(RoundResult.LOSS);
			return player1;
		}
		else if (player2.getHand().beats(player1.getHand())){
			player1.setFormerResult(RoundResult.LOSS);
			player2.setFormerResult(RoundResult.WIN);
			return player2;
		}
		else {
			player1.setFormerResult(RoundResult.TIE);
			player2.setFormerResult(RoundResult.TIE);
			return nullPlayer;
		}
	}
	
	// Print last hand
	void printLastHand(int iRound){
		if (!this.winners[iRound].equals(nullPlayer)) {
			System.out.println(this.winners[iRound].getName() + " won the hand! (" + this.winners[iRound].getHand() + " vs " + this.losers[iRound].getHand() + ")");
		}
		else {
			System.out.println("Tied hand, both players played " + this.player1.getHand());
		}
	}
	
	// Print score up until now
	void printScore(){
		System.out.println("Cumulative score in this game:");
		System.out.println(player1.getName() + ": " + nWinsPlayer1);
		System.out.println(player2.getName() + ": " + nWinsPlayer2);
	}

}

enum RoundResult {
	WIN,
	LOSS,
	TIE;
}
