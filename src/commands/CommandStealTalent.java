package commands;

import game.TwoPlayersGame;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import player.Player;
import talent.Talent;
import tipos.Cadenas;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;

public class CommandStealTalent implements Command{
	//SOLO DOS JUGADORES
	private TwoPlayersGame game;
	private Player player;
	
	public CommandStealTalent(Player player,TwoPlayersGame game){
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
		Map<Talent,Integer> otherPlayerTalents=otherPlayer.getTalents();
		Set<Talent> otherPlayerTalentsSet1=otherPlayerTalents.keySet();
		List<Talent> talentsToStealList=CollectionsFactory.createListFactory().createList();
		talentsToStealList.addAll(otherPlayerTalentsSet1);
		String options1="";
		String conditions1="";
		Iterator<Talent> talentSetIterator=otherPlayerTalentsSet1.iterator();
		for(int i=0;i<otherPlayerTalentsSet1.size();i++){			
			Talent talent= talentSetIterator.next();
			options1=options1+"["+ i+1 +"] "+talent.getName()+"\n";
			conditions1=conditions1+i+",";
		}
			
		String askTalentToBeStolen=otherPlayer.getName()+" tiene los siguientes talentos: "+"\n"+otherPlayer.getTalents().toString()+
									"¿Qué talentos vas a robarle?: "+"\n"+options1;
		String talentToBeStolen=readDataFromKeyBoard.takeParametersToStringRestricted(askTalentToBeStolen,conditions1);
		List<String> talentToBeSteloneSelectionNumbers=Cadenas.separaElementos(conditions1,",");
		
		//Recorre la lista de los talentos a robar
		for(int i=0;i<talentsToStealList.size();i++){
			//Si el talento que hemos querido robar coincide con el de la posicion en la lista
			if(talentToBeSteloneSelectionNumbers.get(i).equals(talentToBeStolen)){
				//El otro jugador descarta al talento y se le añade al jugador que quiere robar
				Talent talent=talentsToStealList.get(i);
				otherPlayer.discardTalent(talent);
				List<Talent> talentToBeAdded=CollectionsFactory.createListFactory().createList();
				talentToBeAdded.add(talent);
				player.addTalent(talentToBeAdded);
				break;
			}
		}		
	}
}
