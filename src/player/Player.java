package player;

public interface Player {
	public Integer getMoney();
	public Integer getReputation();
	public Integer getVictoryPoints();
	public Integer getShowPoints();
	
	public Integer sumMoney(Integer m);
	public Integer sumReputation(Integer r);
	public Integer sumVictoryPoints(Integer vp);
	
	public String toString();
}
