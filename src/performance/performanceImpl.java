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
		return description;
	}


	public String toString(){
		return this.getDescription();
	}
}
