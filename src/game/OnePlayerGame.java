package game;

import game.factory.GameFactory;
import player.Player;
import utiles.factoria.readDataFromKeyBoard;

//Quitado efinalMounth() puesto en sus hijos;
//Añadido parte de los constructores de los hijos por ser iguales.

public abstract class OnePlayerGame extends CircusTrainGame{
	protected Player player;

//	protected Integer numberOfPlayers=1;
	
	public OnePlayerGame(){
		super();
		setPlayersNames();
		basicMoneyMultiplicator=2;
	}
	

	@Override
	public void gameOver() {
		finalWage();
		noClownsNoAnimals();
		results();
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
		Integer playerFinalMoney=player.getMoney();
		System.out.println("Tu dinero al final de la temporada es: "+playerFinalMoney+ "$");
		if(playerFinalMoney<100){
			System.out.println("============= Derrota ============= \nTu circo no" +
					"sobrevive al invierno y pronto será repartido\n" +
					"entre otros trenes del circo más exitosos.\n" +
					"Tú suplicarás ser contratado como trabajador en" +
					"otro circo.");
		}
		if(playerFinalMoney>=100 && playerFinalMoney<=140){
			System.out.println("============= Derrota menor ============= \nHas fracasado" +
					"en crear un circo con éxito y dentro del año\n" +
					"acabas en bancarrota. Tu odisea del tren del\n" +
					"circo se ha terminado, pero quizás tendrás más \n" +
					"éxito comenzando con otro circo o en" +
					"otra aventura financiera.");
		}
		if(playerFinalMoney>140 && playerFinalMoney<=180){
			System.out.println("============= Empate ============= \nha sido una lucha," +
					"pero has conseguido sobrevivir a la temporada del\n" +
					"circo donde muchos otros han" +
					"fracasado. ¿Qué te deparará el futuro?\n" +
					"Puedes preguntar al mimo, pero no puede hablar.");
		}
		if(playerFinalMoney>180 && playerFinalMoney<=220){
			System.out.println("============= ¡Victoria! ============= \nhas impulsado un" +
					"negocio próspero con tu tren del circo." +
					"Con trabajo duro prolongado, tu circo se convierte\n" +
					"en popular y es bienvenido por" +
					"toda América, y los niños esperan con\n" +
					"impaciencia el día que tu tren para en la ciudad.");
		}
		if(playerFinalMoney>220){
			System.out.println("============= ¡Gran Victoria! ============= \nhas creado el" +
					"mayor espectáculo del mundo y pasarás a la\n" +
					"Historia como uno de los más grandes entre\n" +
					"los emprendedores y empresarios.¡Felicitaciones!.");
		}
	}

	@Override
	public void noClownsNoAnimals() {
		//Vacio, puesto que no se especifica nada en las normas
	}


	@Override
	public void finalMonth() {
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
	
	@Override
	protected void rotatePlayers(){
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

//	protected void pointsConversor(Player player){
//		Integer playerUselessVictorypoints=player.getVictoryPoints();
//		player.addMoney(playerUselessVictorypoints);
//		player.addVictoryPoints(-playerUselessVictorypoints);
//		Integer 
//	}
}
