package bag;

import java.util.Map;

import talent.AcrobatImpl;
import talent.BigCatImpl;
import talent.ClownImpl;
import talent.ElephantImpl;
import talent.FreakShowImpl;
import talent.HorseImpl;
import talent.HumanCannonballImpl;
import talent.Talent;
import utiles.factoria.CollectionsFactory;

public class TalentBagImpl implements TalentBag {

	private Map<Talent, Integer> talents = CollectionsFactory.createMapFactory().createMap();

	Talent cw = new ClownImpl();
	Talent ac = new AcrobatImpl();
	Talent fk = new FreakShowImpl();
	Talent hc = new HumanCannonballImpl();
	Talent h = new HorseImpl();
	Talent e = new ElephantImpl();
	Talent bc = new BigCatImpl();

	public TalentBagImpl() {

		talents.put(cw, 6);
		talents.put(ac, 6);
		talents.put(h, 6);
		talents.put(fk, 5);
		talents.put(hc, 5);
		talents.put(bc, 5);
		talents.put(e, 5);
	}

	public Integer getNumTalents(Talent t) {
		return talents.get(t);

	}

	public Map<Talent, Integer> getTalentBag() {
		return talents;
		
	}

	/*
	 * Quita el talento pasado por parámetro de la bolsa de talentos y lo devuelve
	 * para posible tratamiento de él (mostrar mensaje por pantalla al usuario).
	 */
	public Talent removeTalent(Talent t) {
		
		Talent aux = t;
		talents.remove(t);
		return aux;
	}

	public Talent addTalent(Talent t) {

//		if(talents.containsKey(t)){
//			talents.put(t, +1);
//		}
// 	solo por curiosidad de si funcionaría así.
		
		if(talents.containsKey(t)){
			talents.put(t, talents.get(t)+1);			
		}else{
			talents.put(t,1);
		}
		return t;
	}

	public Integer getNumTypeTalent(Talent t) {
		return talents.get(t);
	}
	

}
