import java.util.Scanner;
import java.util.Random;

class Player {
	
	private String name = "";
	private Hand hand;
	
	// Constructor
	public Player(String name){
		this.setName(name);
	}
	
	// Setters
	public void setName(String name){
		this.name = name;
	}
	
	// Getters
	public Hand getHand(){
		return this.hand;
	}
	
	public String getName(){
		return this.name;
	}
	
	// Play hand
	public void playHand(){
		boolean restart = true;
		Scanner sc = new Scanner(System.in);
		
		// User selection
		while (restart == true){
			System.out.println("Select hand to play:");
			System.out.println("1 - Rock");
			System.out.println("2 - Paper");
			System.out.println("3 - Scissors");
			restart = false;
			int handId = sc.nextInt();
			int handError = setHandFromId(handId);
			if (handError != 0){
				restart = true;
				System.out.println("Invalid selection. Please try again.");
			}
		}
	}

	// Set hand from ID
	protected int setHandFromId(int handId){
		switch (handId) {
		case 1: 
			this.hand = Hand.ROCK;
			return 0;
		case 2: 
			this.hand = Hand.PAPER;
			return 0;
		case 3: 
			this.hand = Hand.SCISSORS;
			return 0;
		default:
			return -1;
		}
	}
	
}

class ComputerPlayer extends Player{
	
	private Random rand;
	
	// Constructors
	public ComputerPlayer(){
		super("Computer");
		rand = new Random();
	}
	
	public ComputerPlayer(String name){
		super(name);
		rand = new Random();
	}
	
	// Play hand
	public void playHand(){
		int handId = rand.nextInt(3) + 1;
		int handError = setHandFromId(handId);
		if (handError != 0){
			System.out.println("This should be an exception!");
		}
	}
}