package card;


public class CardImpl implements Card{



	private String name;
	private String description;
	
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

	@Override
	public String toString() {
		return "CardImpl [description=" + description + ", name=" + name + "]";
	}
}
