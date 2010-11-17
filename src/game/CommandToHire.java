package game;

import game.factory.GameFactory;

import java.util.List;
import player.Player;
import utiles.factoria.CollectionsFactory;

import counter.BankruptCircusCounter;

import card.TypeTalentCard;

public class CommandToHire extends AbstractCommand{
	//Se podria cambiar TypeTalentCard pTypeTalentCard
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
				//**Habria que pensar como hacer que segun la reputacion haya un rango de tiradas
				//para poder contratar
				if(!(dice<5)){
					newtalents.add(t);
				}
			}
		}
		player.addTalent(newtalents);
	}

}
