package game;

import game.factory.GameFactory;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import performance.Performance;
import performance.PerformanceDemand;
import performance.PerformanceDemandImpl;
import player.Player;
import talent.AcrobatImpl;
import talent.BigCatImpl;
import talent.ClownImpl;
import talent.ElephantImpl;
import talent.FreakShowImpl;
import talent.HumanCannonballImpl;
import talent.Talent;
import utiles.factoria.CollectionsFactory;

public class TestGame {
	public static void main (String[] args){
		
		CircusTrainGame game=GameFactory.createCircusTrainGame();
		
		game.startGame();
		game.runGame();
		
	}
}
