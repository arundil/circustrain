package game;

import game.factory.GameFactory;

import java.util.List;

import performance.BankruptCircus;
import player.Player;
import talent.Talent;
import utiles.factoria.CollectionsFactory;

import counter.BankruptCircusCounter;

import card.TypeTalentCard;

public class CommandToHire extends AbstractCommand{
	private BankruptCircus circus;
	private Player player;
	
	public CommandToHire (BankruptCircus circus, Player player){
		this.circus=circus;
		this.player=player;
	}
	
	public void execute(){
		List<Talent> newtalents=CollectionsFactory.createListFactory().createList();
		for(Talent t: circus.getTalents()){
//			String election = GameFactory.takeParametersToString("Here is an unemployed talent: "+
//					t.toString()+". Do you want to hire him?: YES, NO");
			String message="Here is an unemployed talent: "+t.toString()+". Do you want to hire him?: YES, NO";
			String condition="YES,NO";
			String election= GameFactory.takeParametersToStringRestricted(message, condition);

			if(!election.equals("NO")){
				Integer dice=GameFactory.throwDice();
				System.out.println("The dice has been thrown: "+dice);
				repMaxValue=player.getHigherDiceScore();
				if((1<=dice) && (dice<=repMaxValue)){
					newtalents.add(t);
				}else{
//					String failure=GameFactory.takeParametersToString("You fail hiring a talent," +
//							"do you want to pay?: YES,NO");
					String message1="You fail hiring a talent,"+"do you want to pay?: YES,NO";
					String condition1="YES,NO";
					String failure=GameFactory.takeParametersToStringRestricted(message1, condition1);
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

