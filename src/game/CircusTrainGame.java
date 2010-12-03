package game;

import java.util.List;

import board.Board;

import player.Player;

public interface CircusTrainGame {
	
	public void startGame();
	public void runGame();
	public void gameOver();
	public String getMonth();
	public void finalMonth();
	public String getFollowingAction();
	public void setFollowingAction(String action);
	public List<Player> getPlayerList();
	public Board getBoard();

}
