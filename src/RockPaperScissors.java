import java.util.Scanner;

public class RockPaperScissors {
	
	public static int nGames = 10;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// User inputs
		System.out.println("Welcome to the Rock-Paper-Scissors game!");
		System.out.print("Please enter your player name:");
		String playerName = sc.nextLine();
		
		// Create players
		Player player1 = new Player(playerName);
		Player player2 = new ComputerPlayer("ComputerSmart",true);
		Player player3 = new ComputerPlayer("Computer");
		
		// Create game
		Game game = new Game(player1,player2);
		
		// Play game
		game.play(nGames);
		
		// Display results
		game.printScore();
		
		System.out.println("End of game!");
		
	}

}
