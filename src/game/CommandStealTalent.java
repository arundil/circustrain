package game;

import game.factory.GameFactory;

import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import player.Player;
import talent.Talent;
import tipos.Cadenas;
import utiles.factoria.CollectionsFactory;

public class CommandStealTalent extends AbstractCommand{
	//SOLO DOS JUGADORES
	private CircusTrainGame game;
	private Player player;
	
	public CommandStealTalent(Player player,CircusTrainGame game){
		this.player=player;
		this.game=game;
	}
	
	public void execute(){
		List<Player> playerList=game.getPlayerList();
		Player otherPlayer=null;
		for(Player thisPlayer:playerList){
			if(!this.player.equals(thisPlayer)){
				otherPlayer=thisPlayer;
				break;
			}
		}
		Set<Entry<Talent,Integer>> playerDetailedTalents=otherPlayer.getTalents().entrySet();
		List<Entry<Talent,Integer>> playerDetailedTalentList=CollectionsFactory.createListFactory().createList();
		playerDetailedTalentList.addAll(playerDetailedTalents);
		String options="";
		String conditions="";
		Integer index=1;
		for(Entry<Talent,Integer> entry:playerDetailedTalents){
			options=options+index+" : "+entry.getKey().toString()+"\n";
			conditions=conditions+index+",";
			index++;
		}		
		String askTalentToBeStolen=player.getName()+" has the following talents: "+"\n"+otherPlayer.getTalents().toString()+
									"Wich talent are you go to steal: "+"\n"+options;
		String talentToBeStolen=GameFactory.takeParametersToStringRestricted(askTalentToBeStolen,conditions);
		List<String> l=Cadenas.separaElementos(conditions,",");
		for(int i=0;i<playerDetailedTalentList.size();i++){
			if(l.get(i).equals(talentToBeStolen)){
				Talent talent=playerDetailedTalentList.get(i).getKey();
				otherPlayer.discardTalent(talent);
				List<Talent> talentToBeAdded=CollectionsFactory.createListFactory().createList();
				talentToBeAdded.add(talent);
				player.addTalent(talentToBeAdded);
				break;
			}
		}		
	}
}
