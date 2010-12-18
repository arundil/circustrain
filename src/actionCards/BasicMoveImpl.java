package actionCards;

import player.Player;
import utiles.factoria.readDataFromKeyBoard;


public class BasicMoveImpl extends ActionCardImpl implements ActionCard {

	private Integer id;
	Player player;

	public BasicMoveImpl(Integer n, Player p) {
		super("MOVIMIENTO BÁSICO", "Puedes moverte hacia una ciudad adyacente o Actuar/Contratar");
		id=n;
		player = p;
	}

	@Override
	public Integer getIdCard() {
		return id;
	}

	@Override
	public void execute() {
		Integer answer;
		
		System.out.println(player.getName()+" ha usado la carta ==> MOVIMIENTO BÁSICO <== \n");
		
		if (player.getCity().hasPerfomance()){
			System.out.println("¿Que quieres hacer, Viajar[1] o Actuar/Contratar[2]");
			answer=readDataFromKeyBoard.takeParametersToIntegerRestricted("Option:","1,2");
		}else{
			System.out.println(player.getCity()+" no tiene Performance");
			answer=1;
		}

		if (answer ==1){
			super.movePlayer(player,1,false);
		}else if(answer==2){ 	
			super.performPlayer(player);
		}
	}


	public String toString() {
		return "[" + id + "]" + super.toString();
	}
	
}