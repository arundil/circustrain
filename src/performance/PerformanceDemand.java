package performance;

import java.util.Map;

import card.TypeTalentCard;



public interface PerformanceDemand extends Performance {
		public Map<TypeTalentCard,Integer> getTalentPoints(); /*Devuelve un Map con los talentos y los valores asociaados a una carta*/
		public Boolean isTwoWeeks();
		public Integer getBasicPoints();
}
