package game;

import game.factory.GameFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import actionCards.ActionCard;
import actionCards.WagesImpl;

import player.Player;
import talent.AcrobatImpl;
import talent.Clown;
import talent.Talent;
import tipos.Cadenas;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;

public abstract class TwoPlayersGame extends CircusTrainGame{

	protected Integer numberOfPlayers=2;
	public abstract void finalMonth();
	public abstract void addRestActionCard();
	
	public TwoPlayersGame(){
		super();
		setPlayersNames();
	}
	
	public void comparePlayersAndAddVictoryPoints() {
		compareTalentsCountAndAddVictoryPoints();
		//Puntos de victoria segun actuacion maxima
		int comparatorPerformancePoints =playerList.get(0).getPerformanceMax().compareTo(playerList.get(1).getPerformanceMax());
		if(comparatorPerformancePoints>0)
			playerList.get(0).addVictoryPoints(4);
		if(comparatorPerformancePoints<0)
			playerList.get(1).addVictoryPoints(4);
	}
	
	@Override
	public void gameOver() {
		finalWage();
		higherClownNumber();
		higherMoneyAmount();
		higherPerformancesNumber();
		noClownsNoAnimals();
	}
	
	
	
	//====================================== X =====================================

	@Override
	public void rotatePlayers(){
		
		List<Player> newPlayerList=CollectionsFactory.createListFactory().createList();
		for(int i=1;i<playerList.size();i++){
			newPlayerList.add(playerList.get(i));	
		}
		newPlayerList.add(playerList.get(0));
		playerList.clear();
		playerList.addAll(newPlayerList);	
	}
	
	public void compareTalentsCountAndAddVictoryPoints(){
		Player player1=playerList.get(0);
		Player player2=playerList.get(1);
		Integer player1talentNumber;
		Integer player2talentNumber;
		Talent AC=GameFactory.createTalent("ACROBAT");
		Talent H=GameFactory.createTalent("HORSE");
		Talent HC=GameFactory.createTalent("HUMAN CANNON BALL");
		Talent BC=GameFactory.createTalent("BIG CAT");
		Talent C=GameFactory.createTalent("CLOWN");
		Talent E=GameFactory.createTalent("ELEPHANT");
		Talent FS=GameFactory.createTalent("FREAK SHOW");
		Set<Talent> allTalents=CollectionsFactory.createSetFactory().createSet();
		allTalents.add(AC);allTalents.add(H);allTalents.add(HC);allTalents.add(BC);
		allTalents.add(C);allTalents.add(E);allTalents.add(FS);
		for(Talent talent:allTalents){
			player1talentNumber=0;
			player2talentNumber=0;
			if(player2.getTalents().containsKey(talent)){
				player2talentNumber=player2.getTalents().get(talent);				
			}
			if(player1.getTalents().containsKey(talent)){
				player1talentNumber=player1.getTalents().get(talent);				
			}			
			if(player1talentNumber.compareTo(player2talentNumber)>0){
				player1.addVictoryPoints(player1talentNumber);
			}
			if(player1talentNumber.compareTo(player2talentNumber)<0){
				player2.addVictoryPoints(player2talentNumber);
			}
		}
	}

	@Override
	protected void finalWage() {
		for(Player player: playerList){
			WagesImpl wageCard=new WagesImpl(this, player);
			if(player.getActionCards().contains(wageCard)){
				toPay(player,2);
				if(player.getVictoryPoints()<3){
					player.addVictoryPoints(player.getVictoryPoints());
				}else{
					player.addVictoryPoints(-3);
				}
			}			
		}		
	}
	
	public void higherClownNumber(){
		Integer clownPlayer1=0,clownPlayer2=0;
		Talent clown=GameFactory.createTalent("CLOWN");
		if(playerList.get(0).getTalents().containsKey(clown)){
			clownPlayer1=playerList.get(0).getTalents().get(clown);
		}
		
		
		if(playerList.get(1).getTalents().containsKey(clown)){
			clownPlayer2=playerList.get(1).getTalents().get(clown);
		}
		
		if(clownPlayer1.compareTo(clownPlayer2)>0){
			playerList.get(0).addVictoryPoints(3);
		}
		if(clownPlayer1.compareTo(clownPlayer2)<0){
			playerList.get(1).addVictoryPoints(3);
		}
	}
	
	public void higherMoneyAmount(){
		List<Integer> playersMoney=CollectionsFactory.createListFactory().createList();
		Integer sameMoneyTimes=0;
		Integer maximumMoney=-1;
		Integer previousMoney=0;
		for(int i=0;i<playerList.size();i++){
			if(i>0){
				previousMoney=playerList.get(i-1).getMoney();
			}
			Player thisPlayer=playerList.get(i);
			playersMoney.add(thisPlayer.getMoney());
			if(maximumMoney<thisPlayer.getMoney()){
				maximumMoney=thisPlayer.getMoney();
			}
			if(previousMoney==thisPlayer.getMoney()){
				sameMoneyTimes++;
			}
		}
		if(sameMoneyTimes==0){
			Integer playerIndex=playersMoney.indexOf(maximumMoney);
			playerList.get(playerIndex).addVictoryPoints(3);
		}
	}
	
	public void higherPerformancesNumber(){
				
		Player player1=playerList.get(0);
		Player player2=playerList.get(1);
		
		Integer player1Usedperformances=player1.getPerfomancesUsed().size();
		Integer player2Usedperformances=player2.getPerfomancesUsed().size();
		
		Integer comparation=player1Usedperformances-player2Usedperformances;
		if(comparation>0){
			player1.addVictoryPoints(3);
		}
		if(comparation<0){
			player2.addVictoryPoints(3);
		}
		
		
	}
	

	@Override
	protected void results(){
		// TODO DOCUMENTAR CAMBIO
		String winner="";
		Integer maxVictoryPoints=0;
		Integer maxPerformancePoints=0;
		Integer victoryPointsDrawGame=0;
		Integer performancePointsDrawGame=0;
		Integer previousPlayerVictoryPoints=0;
		Integer previousPlayerPerformancePoints=0;
		List<Integer> playerVictoryPoints=CollectionsFactory.createListFactory().createList();
		List<Integer> playerPerformancePoints=CollectionsFactory.createListFactory().createList();
		for(int i=0;i<playerList.size();i++){
			Player player=playerList.get(i);
			if(i>0){
				previousPlayerVictoryPoints=playerList.get(i-1).getVictoryPoints();
				previousPlayerPerformancePoints=playerList.get(i-1).getPerformanceMax();
			}
			playerVictoryPoints.add(player.getVictoryPoints());
			playerPerformancePoints.add(player.getPerformanceMax());
			if(maxVictoryPoints<player.getVictoryPoints()){
				maxVictoryPoints=player.getVictoryPoints();				
			}
			if(maxPerformancePoints<player.getPerformanceMax()){
				maxPerformancePoints=player.getPerformanceMax();
			}
			if(player.getVictoryPoints()==previousPlayerVictoryPoints){
				victoryPointsDrawGame=1;
			}
			if(player.getPerformanceMax()==previousPlayerPerformancePoints){
				performancePointsDrawGame=1;
			}
			
		}
		
		if(victoryPointsDrawGame==1){
			if(performancePointsDrawGame==1){
				winner="No hay ganador."+"\n"+"============= ¡EMPATE! =============";
			}else{
				Integer winnerIndex=playerPerformancePoints.indexOf(maxPerformancePoints);
				Player winnerPlayer=playerList.get(winnerIndex);
				winner="¡Tenemos un ganador!"+"\n"+"============= "+winnerPlayer.getName()+" =============";
			}
		}else{
			Integer winnerIndex=playerVictoryPoints.indexOf(maxVictoryPoints);
			Player winnerPlayer=playerList.get(winnerIndex);
			winner="¡Tenemos un ganador!"+"\n"+"============= "+winnerPlayer.getName()+" =============";
		}
		System.out.println(winner+"\n"+"\n"+"---=== Gracias por jugar a Train Circus! ===---");
	}
	
	@Override
	public void noClownsNoAnimals(){
		Talent clown=GameFactory.createTalent("CLOWN");
		Talent elephant=GameFactory.createTalent("ELEPHANT");
		Talent horse=GameFactory.createTalent("HORSE");
		Talent bigCat=GameFactory.createTalent("BIG CAT");
		for(Player thisPlayer:playerList){
			Map<Talent,Integer> thisPlayerTalents = thisPlayer.getTalents();
			if(!thisPlayerTalents.containsKey(clown)){
				thisPlayer.addVictoryPoints(-3);
			}			
			Boolean cats=thisPlayerTalents.containsKey(bigCat);
			Boolean elephants=thisPlayerTalents.containsKey(elephant);
			Boolean horses=thisPlayerTalents.containsKey(horse);
			Boolean animals=cats && elephants && horses;
			if(!animals){
				if(thisPlayer.getVictoryPoints()<3){
					thisPlayer.addVictoryPoints(-thisPlayer.getVictoryPoints());
				}else{
					thisPlayer.addVictoryPoints(-3);					
				}
			}			
		}
	}



	protected void setPlayersNames() {
		for(int i=0;i<2;i++){
			String name=readDataFromKeyBoard.takeParametersToString("Player name: ");
			Player player=GameFactory.createPlayer(name);
			player.addTalent(theClown);
			talentBag.removeTalent(clown);
			player.addActionCards(inicializateActionCards(this, player));
			playerList.add(player);
		}
	}	
	
	@Override
	public void stealTalent(Player player){
		List<Player> playerList=getPlayerList();
		Player otherPlayer=null;
		for(Player thisPlayer:playerList){
			if(!player.equals(thisPlayer)){
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
			options1=options1+"["+i+"] "+talent.getName()+"\n";
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
	
	@Override
	public void stealTalentSelector() {
		if(playerList.get(0).getReputation()>playerList.get(1).getReputation()){
			stealTalent(playerList.get(0));
		}
		if(playerList.get(1).getReputation()>playerList.get(0).getReputation()){
			stealTalent(playerList.get(1));
		}
	}

	public Integer selectCard(List<ActionCard> actionCardsList) {
		String question="Seleccione una carta:\n";
		String restriction="";
		
		
		for(int i=0;i<actionCardsList.size();i++){
			question=question+"["+i+"]"+ actionCardsList.get(i).toString();
			restriction=restriction+i;
			if(i!=actionCardsList.size()-1){
				restriction=restriction+",";
			}
		}
		
		String answer=readDataFromKeyBoard.takeParametersToStringRestricted(question, restriction);
		Integer cardSelector=new Integer(answer);
		ActionCard actionCardToBeUsed=actionCardsList.get(cardSelector);
		
		actionCardToBeUsed.execute(gameState);
		//NO se debe dejar utilizar la carta de descanso en la primera ronda de juego
		//Creo que esto deberia estar en la clase del juego y no aqui para referenciar las semanas
		
		return cardSelector;
	}
	
	protected void pointsConversor(Player player){
		//Vacio. Con dos jugadores no hace falta convertir puntos.
	}
	

}
