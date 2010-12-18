package actionCards;

import player.Player;
import utiles.factoria.readDataFromKeyBoard;


public class BasicMoveImpl extends ActionCardImpl implements ActionCard {

	private Integer id;
	Player player;

	public BasicMoveImpl(Integer n, Player p) {
		super("Basic Move", "You can move towards 1 city or perform/contract");
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
		
		System.out.println(player.getName()+" has used ==> BASIC MOVE <== \n");
		
		if (player.getCity().hasPerfomance()){
			System.out.println("What do you want to do, move[0] or perform/contract[1]");
			answer=readDataFromKeyBoard.takeParametersToIntegerRestricted("Option:","0,1");
		}else{
			System.out.println(player.getCity()+" has no Performance. Where do you want to travel?");
			answer=0;
		}

		if (answer ==0){
			super.movePlayer(player,1);
		}else if(answer==1){ 	
			super.performPlayer(player);
		}
	}


	public String toString() {
		return "[" + id + "]" + super.toString();
	}
	
}