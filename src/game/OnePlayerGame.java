package game;

import game.factory.GameFactory;

import java.util.List;

import player.Player;
import utiles.factoria.readDataFromKeyBoard;
import actionCards.ActionCard;

//Quitado efinalMounth() puesto en sus hijos;
//Añadido parte de los constructores de los hijos por ser iguales.

public abstract class OnePlayerGame extends CircusTrainGame{

//	protected Integer numberOfPlayers=1;
	public abstract void addRestActionCard();
	
	public OnePlayerGame(){
		super();
		setPlayersNames();
		basicMoneyMultiplicator=2;
	}
	

	@Override
	public void gameOver() {
		finalWage();
		noClownsNoAnimals();
	}
	
	

	//====================================== X =====================================


	

	@Override
	protected void finalWage() {
		for(Player player:playerList){
			toPay(player,2);
		}
	}

	@Override
	protected void results(){
		Integer playerFinalMoney=playerList.get(0).getMoney();
		System.out.println("Tu dinero al final de la temporada es: "+playerFinalMoney+ "$");
		if(playerFinalMoney<100){
			System.out.println("============= Derrota ============= \nTu circo no" +
					"sobrevive al invierno y pronto sera repartido\n" +
					"entre otros trenes del circo mas exitosos.\n" +
					"Tu suplicaras ser contratado como trabajador en" +
					"otro circo.");
		}
		if(playerFinalMoney>=100 && playerFinalMoney<=140){
			System.out.println("============= Derrota menor ============= \nHas fracasado" +
					"en crear un circo con exito y dentro del anno\n" +
					"acabas en bancarrota. Tu odisea del tren del\n" +
					"circo se ha terminado, pero quizas tendras mas \n" +
					"exito comenzando con otro circo o en" +
					"otra aventura financiera.");
		}
		if(playerFinalMoney>140 && playerFinalMoney<=180){
			System.out.println("============= Empate ============= \nha sido una lucha," +
					"pero has conseguido sobrevivir a la temporada del\n" +
					"circo donde muchos otros han" +
					"fracasado. Que te deparara el futuro\n" +
					"Puedes preguntar al mimo, pero no puede hablar.");
		}
		if(playerFinalMoney>180 && playerFinalMoney<=220){
			System.out.println("============= Victoria ============= \nhas impulsado un" +
					"negocio prospero con tu tren del circo." +
					"Con trabajo duro prolongado, tu circo se convierte\n" +
					"en popular y es bienvenido por" +
					"toda America, y los ninos esperan con\n" +
					"impaciencia el dia que tu tren para en la ciudad.");
		}
		if(playerFinalMoney>220){
			System.out.println("============= Gran Victoria ============= \nhas creado el" +
					"mayor espectaculo del mundo y pasaras a la\n" +
					"Historia como uno de los mas grandes entre\n" +
					"los emprendedores y empresarios.Felicitaciones.");
		}
	}

	@Override
	public void noClownsNoAnimals() {
		//Vacio, puesto que no se especifica nada en las normas
	}


	@Override
	public void finalMonth() {
		//No hace en un jugador		
	}


	protected void setPlayersNames() {

		String name=readDataFromKeyBoard.takeParametersToString("Nombre del jugador: ");
		Player player=GameFactory.createPlayer(name);

		player.addActionCards(inicializateActionCards(this, player));
		playerList.add(player);
	}
	
	@Override
	public void rotatePlayers(){
		//Vacio porque no se hace nada
	}
	
	protected void collectMoney(Player player){
		//Vacio porque no se hace nada
	}
	
	@Override
	public void stealTalentSelector() {
		//No puedes robarte a ti mismo
	}
	
	@Override
	public void stealTalent(Player player){
		//No puedes robarte a ti mismo   
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
		Integer playerUselessVictorypoints=player.getVictoryPoints();
		player.addMoney(playerUselessVictorypoints*5);
		player.addVictoryPoints(-playerUselessVictorypoints);
//		
//		Integer playerUselessPerformacePoints=player.getPerformanceMax();
//		
//		if(playerUselessPerformacePoints !=0){
//			player.addMoney(playerUselessPerformacePoints);
//			player.addPerformance(-playerUselessPerformacePoints);
//			player.addMoney(-10);
//		}
		
	}
}
