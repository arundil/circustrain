package test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.text.html.Option;

import gameInterface.*;

import game.CircusTrainGame;
import game.factory.GameFactory;

public class TestGame {
	public static void main (String[] args){
		
		
		CircusTrainGame game= GameFactory.createCircusTrainGame();
		game.runGame();
	}
}
