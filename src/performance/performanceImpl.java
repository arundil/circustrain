package performance;

import java.awt.Color;

public class performanceImpl implements Performance {
	
	public performanceImpl(Color cardColor, String description, String name) {
		super();
		this.cardColor = cardColor;
		this.description = description;
		this.name = name;
	}

	private Color cardColor;
	private String description,name;
	@Override
	
	
	public Color getColor() {
		// TODO Auto-generated method stub
		return cardColor;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
