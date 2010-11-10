package bag;

import java.util.List;

import card.TalentCard;

public interface TalentBag extends TalentCard{
	
	public List<TalentCard> createTalentBag(); 
	// A discutir si creamos factorías para muchas de las bolsas.
	
	
	/*
	 * Todos devuelven TalentCard por si resulta útil mostrar por pantalla
	 * cada vez que se modifica (añade, sustrae) la bolsa de talentos.
	 */
	public List<TalentCard> getTalentBag();
	public TalentCard removeTalentCard(TalentCard t);
	public TalentCard addTalentCard(TalentCard t); // si se hace al azar, sería sin param.

}