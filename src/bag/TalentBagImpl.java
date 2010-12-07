package bag;

import java.util.Map;
import java.util.Set;

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

	private Map<Talent, Integer> talents = CollectionsFactory
			.createMapFactory().createMap();

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

	// Devuelve el número de talentos totales.
	public Integer getNumTalents(Talent t) {
		Set<Talent> s = talents.keySet();
		Integer n = 0;
		for (Talent ta : s) {
			n = n + talents.get(ta);
		}
		return n;

	}

	public Map<Talent, Integer> getTalentBag() {
		return talents;

	}

	/*
	 * Quita el talento pasado por parámetro de la bolsa de talentos y lo
	 * devuelve para posible tratamiento de él (mostrar mensaje por pantalla al
	 * usuario).
	 */
	public Talent removeTalent(Talent t) {

		Talent aux = t;
		Integer n = getNumTypeTalent(t);
		if (n > 0) {
			n--;
			talents.put(t, n);

		}
		if (n == 0) {
			System.out.println("No hay más talentos de este tipo");
		}
		return aux;
	}

	public Talent addTalent(Talent t) {

		// if(talents.containsKey(t)){
		// talents.put(t, +1);
		// }
		// solo por curiosidad de si funcionaría así.

		if (talents.containsKey(t)) {
			talents.put(t, talents.get(t) + 1);
		} else {
			talents.put(t, 1);
		}
		return t;
	}

	// Devuelve el número de talentos que hay de este tipo
	public Integer getNumTypeTalent(Talent t) {
		return talents.get(t);
	}

	public String toString() {
		String s = "En la bolsa de talentos hay actualmente:\n\n";
		int n = talents.size();
		// esto es para meter la "...y..." final cuando vaya a mostrarse
		// el último elemento. Poyadita prescindible.
		for (Talent t : talents.keySet()) {
			if (n == 1)
				s += "y ";
			s += talents.get(t) + " " + t.getName() + "s\n";
			// la s final es porque el getInterfaces del toString me lo devuelve
			// en singular
			n--;
		}
		return s;
	}

}
