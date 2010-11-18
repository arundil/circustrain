package bag;

import java.util.Map;

import card.TypeTalentCard;
import card.TypeTalentCardImpl;
import utiles.factoria.CollectionsFactory;

public class TalentBagImpl implements TalentBag{

	private Map<TypeTalentCard,Integer> map = CollectionsFactory.createMapFactory().createMap();
	
	TypeTalentCard t = new TypeTalentCardImpl(PY, description, wage) {
		
		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Integer getWage() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getWage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<TypeTalentCard, Integer> createTalentBag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getNumTypeTalentCard(TypeTalentCard t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<TypeTalentCard, Integer> getTalentBag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeTalentCard removeTypeTalentCard(TypeTalentCard t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeTalentCard addTypeTalentCard(TypeTalentCard t) {
		// TODO Auto-generated method stub
		return null;
	}

}
