package actionCards;


import player.Player;
import utiles.factoria.readDataFromKeyBoard;

public class OvernighterImpl extends ActionCardImpl implements ActionCard {
	private Player player;
	private Integer id;
	
	public OvernighterImpl(Player p) {
		super("Overnighter", "You can move toward 2 cities and/or perform/contract");
		player=p;
		id = 6;
	}

	@Override
	public void execute() {
		Integer answer;
		
		System.out.println(player.getName()+" has used ==> OVERNIGHTER <== \n");
		
		if (player.getCity().hasPerfomance()){
			System.out.print("What do you want to do?, move[0], perform/contract[1] or both[2]");
			answer = readDataFromKeyBoard.takeParametersToIntegerRestricted("Option:","0,1,2");
		}
		else{
			System.out.println(player.getCity()+" has no Performance. Where do you want to travel?");
			answer=0;
		}
		
		if (answer == 0 || answer ==2){
			super.movePlayer(player, 2);
		}
		
		if (answer == 1 || answer ==2){
			super.performPlayer(player);
		}
	}
	@Override
	public Integer getIdCard() {
		return id;
	}
	
	public String toString() {
		return "[" + id + "]" + super.toString();
	}

}
