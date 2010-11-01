package player;

public interface PlayerBasic extends SinglePlayer {
	
	public Integer getReputation();
	public Integer getVictoryPoints();
	
	public boolean addVictoryPoints(Integer vp);
	
}
