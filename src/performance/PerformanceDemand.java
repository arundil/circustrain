package performance;

import java.util.Map;

import talent.Talent;




public interface PerformanceDemand extends Performance {
		public Map<Talent, Integer> getTalentPoints(); /*Devuelve un Map con los talentos y los valores asociaados a una carta*/
		// he cambiado el tipo de typeTalentCard a String, porque como ha cambiado la clase Talent esta tambien tiene que cambiar
		public Boolean isTwoWeeks();
		public Integer getBasicPoints();
}
