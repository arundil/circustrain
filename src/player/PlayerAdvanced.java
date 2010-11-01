package player;

public interface PlayerAdvanced extends SinglePlayer {
	
	public Integer getReputationAdvanced();
	
	public boolean addVictoryPoints(Integer vp);
	public boolean addReputation(Integer rp);
}
