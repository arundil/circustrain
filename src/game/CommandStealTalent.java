package game;

import game.factory.GameFactory;

import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import player.Player;
import talent.Talent;

public class CommandStealTalent extends AbstractCommand{
	//SOLO DOS JUGADORES
	private CircusTrainGame game;
	
	public CommandStealTalent(CircusTrainGame game){
		this.game=game;
	}
	
	public void execute(){
		List<Player> playerList=game.getPlayerList();
		Player player1=playerList.get(0);
		Player player2=playerList.get(1);
		
		Integer compareVictoryPoints=player1.getVictoryPoints().compareTo(player2.getVictoryPoints());
		if(compareVictoryPoints>0);
			
		Set<Entry<Talent,Integer>> talentsDetailedTalents=player1.getTalents().entrySet();
		String options="";
		String conditions="";
		for(Entry<Talent,Integer> entry:talentsDetailedTalents){
			Integer index=1;
			options=options+index+" : "+entry.getKey().toString()+"\n";
			conditions=conditions+index+",";
			index++;
		}
		String askTalentToBeStolen=player1.getName()+" has the following talents: "+"\n"+player1.getTalents().toString()+
									"Wich talent are you go to steal: "+"\n"+options;
		String talentToBeStolen=GameFactory.takeParametersToStringRestricted(askTalentToBeStolen, conditions);
		
		
		
		
		
	}
	
	
	

}
