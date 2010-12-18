package game;

import game.factory.GameFactory;

import java.util.List;

import player.Player;

import actionCards.ActionCard;

import talent.Talent;
import utiles.factoria.CollectionsFactory;

public class TestGame {
	public static void main (String[] args){
		
		TwoPlayersGame game=GameFactory.createCircusTrainGame();
		game.runGame();
		
	}
}
