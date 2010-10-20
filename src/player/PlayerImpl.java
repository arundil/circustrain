package player;

import game.Talent;

import java.util.HashSet;
import java.util.Set;


import tab.ShowTab;


public class PlayerImpl implements Player {
	private Integer playernumber, money, reputation, victorypoints, showpoints, talentpoints;
	private Set<Talent> talents;
	private Set<ShowTab> shows;
	
	public PlayerImpl(Integer pn){
		playernumber = pn;
		money = 0;
		reputation = 0;
		victorypoints = 0;
		showpoints = 0;
		talents = new HashSet<Talent>();
		talentpoints = 0;
		shows = new HashSet<ShowTab>();
		}
	
	public Integer getPlayerNumber(){
		return playernumber;
	}
	public Integer getMoney(){
		return money;
	}
	public Integer getReputation(){
		return reputation;
	}
	public Integer getVictoryPoints(){
		return victorypoints;
	}
	public Integer getShowPoints(){
		return showpoints;
	}
	public Integer getTalentPoints(){
		return talentpoints;
	}
	public Set<Talent> getTalents(){
		return talents;
	}
	public Set<ShowTab> getShows(){
		return shows;
	}
	
	public Integer sumMoney(Integer m){
		money = money + m;
		return money;
	}
	public Integer sumReputation(Integer r){
		reputation = reputation + r;
		return reputation;
	}
	public Integer sumVictoryPoints(Integer vp){
		victorypoints = victorypoints + vp;
		return victorypoints;
	}
	
	public void addTalent(Talent t){
		//TODO comparar con reputacion en avanzado.
		talents.add(t);
	}
	
	public Integer addShow(ShowTab act){
		shows.add(act);
		//TODO no es verdad hacerlo verdad.
		showpoints = showpoints + act.getPoints();
		return showpoints;
	}
	
	public String toString(){
		return "This players is "+playernumber.toString()+" with money " + money+ "with victory points " + 
		victorypoints;
	}
}
