package actionCards;

import player.Player;
import utiles.factoria.readDataFromKeyBoard;


public class BasicMoveImpl extends ActionCardImpl implements ActionCard {

	private Integer id;
//borrado atributo player
	public BasicMoveImpl(Integer n,Player player) {
		super("MOVIMIENTO BÁSICO", "Puedes moverte hacia una ciudad adyacente o Actuar/Contratar",player);
		id=n;
	}

	@Override
	public Integer getIdCard() {
		return id;
	}

	@Override
	public void execute() {
		Integer answer;
//sustituido player por getPlayer()
		System.out.println(getPlayer().getName()+" ha usado la carta ==> MOVIMIENTO BÁSICO <== \n");
		
		if (getPlayer().getCity().hasPerfomance()){
			String mens="¿Que quieres hacer, Viajar[1] o Actuar/Contratar[2]";
			answer=readDataFromKeyBoard.takeParametersToIntegerRestricted(mens+"\nOption:","1,2");
		}else{
			System.out.println(getPlayer().getCity()+" no tiene Performance");
			answer=1;
		}
//borrado atributo player
		if (answer ==1){
			super.movePlayer(1);
		}else if(answer==2){ 	
			super.performPlayer();
		}
	}



	
}