package performance;



public class performanceImpl implements Performance {
	
	public performanceImpl(String cardColor, String description) {
		super();
		this.cardColor = cardColor;
		this.description = description;
	}

	private String cardColor;
	private String description;
	@Override
	
	
	public String getColor() {
		return cardColor;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}


	public String toString(){
		//TODO
		return "Hay una performaance NPI de cual es?¿";//"La carta con descripcion "+ this.getDescription()+" y color "+this.getColor().toString();
	}
}
