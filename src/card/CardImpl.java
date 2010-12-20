package card;

import player.Player;


public class CardImpl implements Card{

//Añadido player como atributo a la carta con su getter
	private Player player;
	private String name;
	private String description;
	
	public CardImpl(String name, String description,Player player){
		this.name = name;
		this.description = description;
		this.player=player;
		
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	public Player getPlayer(){
		return player;
	}
	@Override
	public String toString() {
		return name + " :" + description +"\n";
	}
}
