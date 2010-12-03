package performance;

import java.awt.Color;

public class VictoryPointsImpl extends performanceImpl implements VictoryPoints {
	private Integer victoryPoints;
	public VictoryPointsImpl(Color cardColor, String description, String name,
			Integer victoryPoints) {
		super(cardColor, description, name);
		this.victoryPoints = victoryPoints;
	}

	@Override
	public Integer getVictoryPoints() {
		// TODO Auto-generated method stub
		return victoryPoints;
	}
	
	@Override
	//Añadido por jenkin90
	public String toString(){
		return "esto es"+ this.getName() +"con descripcion" + this.getDescription() +"de color "+ this.getColor().toString() +"y con los siguientes puntos de victoria : "+ this.getVictoryPoints().toString();
	}

}
