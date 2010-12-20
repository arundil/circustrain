package game;

import game.factory.GameFactory;

import java.util.List;
import java.util.Map;
import player.Player;
import talent.Clown;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import commands.CommandPay;

//Quitado efinalMounth() puesto en sus hijos;
//Añadido parte de los constructores de los hijos por ser iguales.

public abstract class OnePlayerGame extends CircusTrainGame{
	protected Player player;

//	protected Integer numberOfPlayers=1;
	
	public OnePlayerGame(){
		super();
		String name=readDataFromKeyBoard.takeParametersToString("Nombre del jugador: ");
		player=GameFactory.createPlayer(name);
		player.addTalent(theClown);
		talentBag.removeTalent(clown);
		player.addActionCards(GameFactory.inicializateActionCards(this, player));
		playerList.add(player);	
	}
	

	public void gameOver() {
		finalWage();
		noClownsNoAnimals();
		results();
	}
	
	

	//====================================== X =====================================


	

	protected void finalWage() {
		CommandPay cmp = new CommandPay(playerList.get(0), this, 2);
		cmp.execute();	
	}
	
	protected void higherClownNumber(){
		Integer playerClownNumber=0;
		Integer maximumClownNumber=-1;
		Integer sameClownNumberTimes=0;
		Integer previousClownNumber=0;
		List<Integer> clownNumber=CollectionsFactory.createListFactory().createList();
		for(int i=0;i<playerList.size();i++){
			Player thisPlayer=playerList.get(i);
			Map<Talent,Integer> thisPlayerTalents = thisPlayer.getTalents();
			if(thisPlayerTalents.containsKey(Clown.class)){
				playerClownNumber=thisPlayer.getTalents().get(Clown.class);			
			}else{
				playerClownNumber=0;
			}
			clownNumber.add(playerClownNumber);
			if(maximumClownNumber<playerClownNumber){
				maximumClownNumber=playerClownNumber;
			}
			if(i>0){
				Player previousPlayer=playerList.get(i-1);
				if(previousPlayer.getTalents().containsKey(Clown.class)){
					previousClownNumber=thisPlayer.getTalents().get(Clown.class);			
				}else{
					previousClownNumber=0;
				}
			}
			if(maximumClownNumber==previousClownNumber){
				sameClownNumberTimes++;
			}
		}
		if(sameClownNumberTimes==0){
			Integer playerIndex= clownNumber.indexOf(maximumClownNumber);
			playerList.get(playerIndex).addVictoryPoints(3);
		}
	}
	
	protected void higherMoneyAmount(){
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
	
	protected void higherPerformancesNumber(){
		List<Integer> playersNumberOfPerformances=CollectionsFactory.createListFactory().createList();
		Integer sameNumberOfPerformancesTimes=0;
		Integer maximumNumberOfPerformances=-1;
		Integer previousNumberOfPerformances=0;
		for(int i=0;i<playerList.size();i++){
			if(i>0){
				previousNumberOfPerformances=playerList.get(i-1).getPerfomancesUsed().size();
			}
			Player thisPlayer=playerList.get(i);
			playersNumberOfPerformances.add(thisPlayer.getPerfomancesUsed().size());
			if(maximumNumberOfPerformances<thisPlayer.getPerfomancesUsed().size()){
				maximumNumberOfPerformances=thisPlayer.getPerfomancesUsed().size();
			}
			if(previousNumberOfPerformances==thisPlayer.getPerfomancesUsed().size()){
				sameNumberOfPerformancesTimes++;
			}
		}
		if(sameNumberOfPerformancesTimes==0){
			Integer playerIndex=playersNumberOfPerformances.indexOf(maximumNumberOfPerformances);
			playerList.get(playerIndex).addVictoryPoints(3);
		}
	}
	

	protected void results(){
		Integer playerFinalMoney=player.getMoney();
		System.out.println("Tu dinero al final de la temporada es: "+playerFinalMoney+ "$");
		if(playerFinalMoney<100){
			System.out.println("============= Derrota ============= \nTu circo no" +
					"sobrevive al invierno y pronto será repartido" +
					"entre otros trenes del circo más exitosos. Tú" +
					"suplicarás ser contratado como trabajador en" +
					"otro circo.");
		}
		if(playerFinalMoney>=100 && playerFinalMoney<=140){
			System.out.println("============= Derrota menor ============= \nHas fracasado" +
					"en crear un circo con éxito y dentro del año" +
					"acabas en bancarrota. Tu odisea del tren del" +
					"circo se ha terminado, pero quizás tendrás" +
					"más éxito comenzando con otro circo o en" +
					"otra aventura financiera.");
		}
		if(playerFinalMoney>140 && playerFinalMoney<=180){
			System.out.println("============= Empate ============= \nha sido una lucha," +
					"pero has conseguido sobrevivir a la" +
					"temporada del circo donde muchos otros han" +
					"fracasado. ¿Qué te deparará el futuro?" +
					"Puedes preguntar al mimo, pero no puede hablar.");
		}
		if(playerFinalMoney>180 && playerFinalMoney<=220){
			System.out.println("============= ¡Victoria! ============= \nhas impulsado un" +
					"negocio próspero con tu tren del circo. Con" +
					"trabajo duro prolongado, tu circo se" +
					"convierte en popular y es bienvenido por" +
					"toda América, y los niños esperan con" +
					"impaciencia el día que tu tren para en la ciudad.");
		}
		if(playerFinalMoney>220){
			System.out.println("============= ¡Gran Victoria! ============= \nhas creado el" +
					"mayor espectáculo del mundo y pasarás a la" +
					"Historia como uno de los más grandes entre" +
					"los emprendedores y empresarios.¡Felicitaciones!.");
		}
	}

	@Override
	public void noClownsNoAnimals() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void finalMonth() {
		// TODO Auto-generated method stub
		
	}


	protected void setPlayersNames() {

		String name=readDataFromKeyBoard.takeParametersToString("Nombre del jugador: ");
		Player player=GameFactory.createPlayer(name);
		player.addTalent(theClown);
		talentBag.removeTalent(clown);
		player.addActionCards(GameFactory.inicializateActionCards(this, player));
		playerList.add(player);

	}
}
