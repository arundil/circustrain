package card;

public class CardImpl {
	private String name, description;
	
	public CardImpl(String name, String des){
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
