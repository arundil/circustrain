package card;

public class Card {
	private String name, description;
	
	public Card(String name, String des){
		this.name = name;
		description = des;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}

}
