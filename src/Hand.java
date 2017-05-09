public class Hand {
	public static enum HandType {
		ROCK("rock"),
		PAPER("paper"),
		SCISSORS("scissors");
		
		private final String text;
		
		HandType(String text){
			this.text = text;
		}
		
		public String toString(){
			return text;
		}
	}
	
	private HandType value;
	private HandType beatsHand;
	
	public Hand(HandType handType){
		value = handType;
		switch (value){
		case ROCK:
			beatsHand = HandType.SCISSORS;
			break;
		case PAPER:
			beatsHand = HandType.ROCK;
			break;
		case SCISSORS:
			beatsHand = HandType.PAPER;
			break;
		}
	}
	
	public boolean beats(Hand otherHand){
		// System.out.println(this.beatsHand);
		// System.out.println(otherHand.getValue());
		if (otherHand.getValue().equals(this.beatsHand)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public HandType getValue(){
		return this.value;
	}
	
	public String toString(){
		return this.value.toString();
	}
}