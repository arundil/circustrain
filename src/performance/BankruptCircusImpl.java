package performance;


import game.CircusTrainGame;
import game.factory.GameFactory;
import gameState.GameState;

import java.util.List;

import player.Player;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;

public class BankruptCircusImpl extends performanceImpl implements BankruptCircus {
	
	
	private List<Talent> talentCircus; //talentos asociados a la carta de bancarrota
	public BankruptCircusImpl(String cardColor, String description, 
			List<Talent> talentCircus) {
		super(cardColor, description);
		this.talentCircus = talentCircus;
	}
	public List<Talent> getTalentCircus() {
		return talentCircus;
	}
	
	@Override
	public String toString(){
		String stringToReturn=super.toString();
		for(Talent t:this.getTalentCircus()){
			stringToReturn=stringToReturn+" "+t.toString()+"("+t.getWage()+")";
		}
		return stringToReturn;
	}
	
	public void execute(Player player,GameState gamestate) {
		List<Talent> newtalents=CollectionsFactory.createListFactory().createList();
		for(Talent t:getTalentCircus()){
			String answers="\n" + "[1] SI" + "\n" + "[2] NO";
			String question="El talento  "+t.toString()+" está sin empleo. ¿Quieres contratarlo?"+answers;
			String condition="1,2";
			String election= readDataFromKeyBoard.takeParametersToStringRestricted(question, condition);

			if(!election.equals("2")){
				Integer dice=GameFactory.throwDice();
				System.out.println("Al tirar el dado ha salido: "+dice);
				Integer repMaxValue=player.getHigherDiceScore();
				if((1<=dice) && (dice<=repMaxValue)){
					System.out.println("\nHas contratado el talento "+t.toString()+"\n");
					newtalents.add(t);
				}else{
					System.out.println("\nNo has conseguido contratar el talento "+t.toString()+"\n");
					if(!((player.getMoney())<10)){	
						String answers1="\n" + "[1] SI" + "\n" + "[2] NO";
						String message1="Tu tirada no es suficiente para contratar gratis al talento,¿Quieres pagar?"+answers1;
						String condition1="1,2";
						String failure=readDataFromKeyBoard.takeParametersToStringRestricted(message1, condition1);
						if(!failure.equals("2")){
							newtalents.add(t);
							player.addMoney(-10);							
						}						
					}
				}
			}
		}
		player.addTalent(newtalents);
		this.getTalentCircus().removeAll(newtalents);
		if (getTalentCircus().size()==0){
			player.getCity().removePerformance();
			}	
	}
	
	public void land(Player p){
		
	}
	public void put(CircusTrainGame game){
		for(Talent t: getTalentCircus()){
			if(game.getTalentBag().getNumTypeTalent(t)>0){
				
				game.getTalentBag().removeTalent(t);
			}else{
				getTalentCircus().remove(t);
			}
		}
		game.getBoard().addPerfomanceInRandomCity(this);
	}
}
