import java.util.Scanner;
import java.util.Random;

class Player {
	
	private String name = "";
	private Hand hand;
	private RoundResult formerResult = RoundResult.NULL;
	private Hand formerHand = Hand.ROCK;
	
	// Constructor
	public Player(String name){
		this.setName(name);
	}
	
	// Setters
	public void setName(String name){
		this.name = name;
	}
	
	public void setFormerResult(RoundResult result){
		this.formerResult = result;
		this.formerHand = this.hand;
	}
	
	public void setHand(Hand hand){
		this.hand = hand;
	}
	
	// Getters
	public Hand getHand(){
		return this.hand;
	}
	
	public String getName(){
		return this.name;
	}
	
	public RoundResult getFormerResult(){
		return this.formerResult;
	}
	
	public Hand getFormerHand(){
		return this.formerHand;
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
			this.setHand(Hand.ROCK);
			return 0;
		case 2: 
			this.setHand(Hand.PAPER);
			return 0;
		case 3: 
			this.setHand(Hand.SCISSORS);
			return 0;
		default:
			return -1;
		}
	}
	
}

class ComputerPlayer extends Player{
	
	private Random rand;
	private boolean playSmart = false;
	private double smartThreshold = 0.75;
	
	// Constructors
	public ComputerPlayer(){
		super("Computer");
		initialize(false);
	}
	
	public ComputerPlayer(boolean playSmart){
		super("Computer");
		initialize(playSmart);
	}
	
	public ComputerPlayer(String name){
		super(name);
		initialize(false);
	}
	
	public ComputerPlayer(String name, boolean playSmart){
		super(name);
		initialize(playSmart);
	}
	
	// Initialize
	private void initialize(boolean playSmart){
		this.playSmart = playSmart;
		rand = new Random();
	}
	
	// Play hand
	public void playHand(){
		
		// Play random hand
		if (!this.playSmart) {
			int handId = rand.nextInt(3) + 1;
			int handError = setHandFromId(handId);
		}
		// Play smart hand
		else {
			
			// Play smart only X% of time to preserve some randomness
			double smartNumber = rand.nextDouble(); // Random number between 0.0 and 1.0
			if (smartNumber < smartThreshold) {
				if (this.getFormerResult().equals(RoundResult.WIN)) {
					if (this.getFormerHand().equals(Hand.ROCK)){
						this.setHand(Hand.SCISSORS);
					}
					else if (this.getFormerHand().equals(Hand.PAPER)){
						this.setHand(Hand.ROCK);
					}
					else if (this.getFormerHand().equals(Hand.SCISSORS)){
						this.setHand(Hand.PAPER);
					}
				}
				else if (this.getFormerResult().equals(RoundResult.LOSS)) {
					if (this.getFormerHand().equals(Hand.ROCK)){
						this.setHand(Hand.SCISSORS);
					}
					else if (this.getFormerHand().equals(Hand.PAPER)){
						this.setHand(Hand.ROCK);
					}
					else if (this.getFormerHand().equals(Hand.SCISSORS)){
						this.setHand(Hand.PAPER);
					}
				}
				else {
					int handId = rand.nextInt(3) + 1;
					int handError = setHandFromId(handId);
				}
			}
			else {
				int handId = rand.nextInt(3) + 1;
				int handError = setHandFromId(handId);
			}
		}
	}
}