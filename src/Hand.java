public enum Hand {
	ROCK("rock","scissors"),
	PAPER("paper","rock"),
	SCISSORS("scissors","paper");
	
	private final String value;
	private final String beatsHand;
	
	Hand(String value, String beatsHand){
		this.value = value;
		this.beatsHand = beatsHand;
	}
	
	public String toString(){
		return value;
	}
	
	public String getValue(){
		return value;
	}
	
	public String getBeats(){
		return beatsHand;
	}
	
	public boolean beats(Hand hand){
		if (hand.getValue().equals(this.beatsHand)) {
			return true;
		}
		else {
			return false;
		}
	}
}