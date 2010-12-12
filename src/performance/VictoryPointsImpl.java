package performance;



public class VictoryPointsImpl extends performanceImpl implements VictoryPoints {
	private Integer victoryPoints;
	public VictoryPointsImpl(String cardColor, String description, 
			Integer victoryPoints) {
		super(cardColor, description);
		this.victoryPoints = victoryPoints;
	}

	@Override
	public Integer getVictoryPoints() {
		// TODO Auto-generated method stub
		return victoryPoints;
	}
	
	@Override

	public String toString(){
		return " Esto es " + this.getDescription() +" de color "+ this.getColor().toString() +"y con los siguientes puntos de victoria : "+ this.getVictoryPoints().toString();
	}

}
