package player;

import java.util.List;
import java.util.Map;

import performance.Performance;
import card.ActionCard;
import card.TypeTalentCard;

public class PlayerImpl implements Player {

	@Override
	public boolean addActionCard(ActionCard ac) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMoney(Integer m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPerfomanceUsed(Performance p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPerformance(Integer p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addReputation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTalent(List<TypeTalentCard> t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addVictoryPoints(Integer vp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean discardActionCard(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ActionCard> getActionCards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMoney() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Performance> getPerfomancesUsed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getPerformanceMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getReputation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<TypeTalentCard, Integer> getTalents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getVictoryPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActionCard> getdiscartpile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFirstPlayer() {
		// TODO Auto-generated method stub
		return false;
	}

}
