package test;

import game.CircusTrainGame;
import game.factory.GameFactory;

public class TestGame {
	public static void main (String[] args){		
		CircusTrainGame game= GameFactory.createCircusTrainGame();
		game.runGame();
	}
}
