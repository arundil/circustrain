package game;

import game.factory.GameFactory;

import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import player.Player;
import talent.Talent;
import utiles.factoria.CollectionsFactory;

public class CommandToPay extends AbstractCommand{
	
	private Player player;
	private CircusTrainGame game;
	
	public CommandToPay (Player player,CircusTrainGame game){
		this.player=player;
		this.game=game;
	}
	
	private Integer talentsNumber;
	private Integer totalMoneyToPay;
	private void showTalents(){
	Set<Entry<Talent,Integer>> playerTalents=player.getTalents().entrySet();
	List<Entry<Talent,Integer>> playerTalentList=CollectionsFactory.createListFactory().createList();
	
	for(Entry<Talent,Integer> entry:playerTalents){
		talentsNumber=talentsNumber+entry.getValue();
	}
	
	
	
	public void execute(){
			
	}

}
