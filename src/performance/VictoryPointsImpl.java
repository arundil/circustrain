package performance;

import game.CircusTrainGame;
import player.Player;



public class VictoryPointsImpl extends performanceImpl implements VictoryPoints {
	private Integer victoryPoints;
	public VictoryPointsImpl(String cardColor, String description, 
			Integer victoryPoints) {
		super(cardColor, description);
		this.victoryPoints = victoryPoints;
	}

	@Override
	public Integer getVictoryPoints() {
		return victoryPoints;
	}
	
	@Override


	public String toString(){
		String stringToReturn=super.toString()+": "+this.getVictoryPoints();
		return stringToReturn;
	}

	@Override
	public void execute(Player player) {

	}
	
	public void land(Player player){
		player.addVictoryPoints(victoryPoints);
		player.getCity().removePerformance();
	}
public void put(CircusTrainGame game){
		game.getBoard().addPerfomanceInRandomCity(this);
	}

}
