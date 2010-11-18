package card;

public class TypeTalentCardImpl extends CardImpl implements TypeTalentCard{
	
	private Integer wage;
	
	public TypeTalentCardImpl(String name, String description, Integer wage){
		super(name,description);
		this.wage=wage;
		
	}
	
	@Override
	public String getDescription() {
		
		return super.getDescription();
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public Integer getWage() {
		return this.wage;
	}

}
