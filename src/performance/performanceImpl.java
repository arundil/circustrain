package performance;

import player.Player;



public abstract class performanceImpl{
	
	public performanceImpl(String cardColor, String description) {
		super();
		this.cardColor = cardColor;
		this.description = description;
	}

	private String cardColor;
	private String description;
	
	public String getColor() {
		return cardColor;
	}

	public String getDescription() {
		return description;
	}


	public String toString(){
		return this.getDescription();
	}
	
	public abstract void execute(Player player);
	

}
