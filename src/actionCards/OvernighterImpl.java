package actionCards;


import player.Player;
import utiles.factoria.readDataFromKeyBoard;

public class OvernighterImpl extends ActionCardImpl implements ActionCard {
	private Player player;
	private Integer id;
	
	public OvernighterImpl(Player p) {
		super("DE NOCHE", "Puedes moverte hasta 2 ciudades y/o actuar/contratar");
		player=p;
		id = 6;
	}

	public void execute() {
		Integer answer;
		
		System.out.println(player.getName()+" ha usado la carta ==> DE NOCHE <== \n");
		
		if (player.getCity().hasPerfomance()){
			System.out.print("¿Que quieres hacer?, Viajar[1],Viajar Primero y luego Actuar/Contratar[2] o Actuar/Contratar[3]");
			answer = readDataFromKeyBoard.takeParametersToIntegerRestricted("Option:","1,2,3");
		}
		else{
			System.out.println(player.getCity()+" no tiene Performance. ¿Qué quieres hacer? Viajar[1] o ViViajar Primero y luego Actuar/Contratar[2]");
			answer=0;
		}
		
		if (answer == 1){
			super.movePlayer(player, 2,false);
		}
		
		if (answer == 2){
			System.out.println("Estas son las ciudades que poseen actuación. ¿A qué ciudad quieres viajar?");
			super.movePlayer(player,2,true);
		}
		
		if ((answer == 2 || answer ==3)){
			super.performPlayer(player);
		}
	}
	
	public Integer getIdCard() {
		return id;
	}
	
	public String toString() {
		return "[" + id + "]" + super.toString();
	}

}
