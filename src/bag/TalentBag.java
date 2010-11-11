package bag;

import java.util.Map;

import card.TypeTalentCard;

public interface TalentBag extends TypeTalentCard{
	
	public Map<TypeTalentCard,Integer> createTalentBag(); 
	// Se inicializar� la bolsa completa, "game" se encargara de quitar los talentos
	// necesarios para empezar.
	
	
	/*
	 * Todos devuelven TypeTalentCard por si resulta útil mostrar por pantalla
	 * cada vez que se modifica (añade, sustrae) la bolsa de talentos.
	 */
	public Integer getNumTypeTalentCard(TypeTalentCard t);
	public Map<TypeTalentCard,Integer> getTalentBag();
	public TypeTalentCard removeTypeTalentCard(TypeTalentCard t);
	public TypeTalentCard addTypeTalentCard(TypeTalentCard t); // si se hace al azar, sería sin param.

}