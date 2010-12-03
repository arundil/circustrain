package bag;

import java.util.Map;

import talent.Talent;
import talent.TalentImpl;

public interface TalentBag {

	public Map<Talent, Integer> createInitialTalentBag();

	// Se inicializará la bolsa completa, "game" se encargara de quitar los
	// talentos
	// necesarios para empezar.

	/*
	 * Todos devuelven TypeTalentCard por si resulta útil mostrar por pantalla
	 * cada vez que se modifica (añade, sustrae) la bolsa de talentos.
	 */
	public Integer getNumTalents(Talent t);

	public Map<Talent, Integer> getTalentBag();

	public Talent removeTalent(Talent t);

	public Talent addTalent(Talent t); // si se hace al azar, sería sin param.

	public Integer getNumTypeTalent(Talent t);

}