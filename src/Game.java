public class Game {
	
	private Player player1;
	private Player player2;
	private static Player nullPlayer = new Player("nullPlayer");
	private Player[] winners;
	private Player[] losers;
	private int nWinsPlayer1 = 0;
	private int nWinsPlayer2 = 0;
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void play(int nRounds){
		this.winners = new Player[nRounds];
		this.losers = new Player[nRounds];
		nWinsPlayer1 = 0;
		nWinsPlayer2 = 0;
		for (int iRound = 0; iRound < nRounds; iRound++){
			player2.playHand();
			player1.playHand();
			this.winners[iRound] = Game.getHandWinner(player1,player2);
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
			printLastHand(iRound);
			printScore(iRound);
		}
	}
	
	public static Player getHandWinner(Player player1, Player player2){

		if (player1.getHand().beats(player2.getHand())){
			return player1;
		}
		else if (player2.getHand().beats(player1.getHand())){
			return player2;
		}
		else {
			return nullPlayer;
		}
	}
	
	void printLastHand(int iRound){
		if (!this.winners[iRound].equals(nullPlayer)) {
			System.out.println(this.winners[iRound].getName() + " won the hand! (" + this.winners[iRound].getHand() + " vs " + this.losers[iRound].getHand() + ")");
		}
		else {
			System.out.println("Tied hand, both players played " + this.player1.getHand());
		}
	}
	
	void printScore(int nRound){
		System.out.println("Cumulative score in this game:");
		System.out.println(player1.getName() + ": " + nWinsPlayer1);
		System.out.println(player2.getName() + ": " + nWinsPlayer2);
	}

}
