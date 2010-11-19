package game;

import game.factory.GameFactory;

import java.util.List;
import player.Player;
import utiles.factoria.CollectionsFactory;

import counter.BankruptCircusCounter;

import card.TypeTalentCard;

public class CommandToHire extends AbstractCommand{
	private BankruptCircusCounter circus;
	private Player player;
	
	public CommandToHire (BankruptCircusCounter circus, Player player){
		this.circus=circus;
		this.player=player;
	}
	
	public void execute(){
		List<TypeTalentCard> newtalents=CollectionsFactory.createListFactory().createList();
		for(TypeTalentCard t: circus.getTalents()){
			String election = GameFactory.takeParametersToString("Here is an unemployed talent: "+
					t.getName().toString()+". Do you want to hire him?: YES, NO");
//			if((!election.equals("NO")) || (!election.equals("YES"))){
//				throw new IllegalArgumentException("Unknown answer");
//			}
			//Habria que ver si esto se puede meter en los metodos de la GameFactory
			if(!election.equals("NO")){
				Integer dice=GameFactory.throwDice();
				System.out.println("The dice has been thrown: "+dice);
				repMaxValue=player.getHigherDiceScore();
				if((1<=dice) && (dice<=repMaxValue)){
					newtalents.add(t);
				}else{
					String failure=GameFactory.takeParametersToString("You fail hiring a talent," +
							"do you want to pay?: YES,NO");
					if(!failure.equals("NO")){
						try{
							if(player.getMoney()>=10){
								newtalents.add(t);
								player.addMoney(-10);
							}
						}catch(Exception e){
							System.out.println("You don't have money enough");
						}
					}						
				}
			}
		}
		player.addTalent(newtalents);
	}
	

}

