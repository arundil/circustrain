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
		return victoryPoints;
	}
	
	@Override


	public String toString(){
		String stringToReturn=super.toString()+": "+this.getVictoryPoints();
		return stringToReturn;
	}

}
