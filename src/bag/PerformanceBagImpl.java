package bag;

import game.factory.GameFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import performance.*;
import talent.*;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.ReadFile;

public class PerformanceBagImpl implements PerformanceBag {
	private List<Performance> greenBag = CollectionsFactory.createListFactory().createList();
	private List<Performance> redBag = CollectionsFactory.createListFactory().createList();
	private List<Performance> yellowBag= CollectionsFactory.createListFactory().createList();
	
	
	public PerformanceBagImpl() {
		super();
	}
	
	public PerformanceBagImpl(String file){
		this();
		String fileLine=null;
		BufferedReader fileReader = null;
		try {
			//Soluciona el problema cuando movemos el trabajo de un ordenador a otro.
			fileReader = ReadFile.readTextFile(System.getProperty("user.dir")+file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while ((fileLine = fileReader.readLine())!=null) {
				   String color=null;
				   String []readedString=fileLine.split(",");
				   Performance performanceToAdd=null;
				   if(readedString[1].equals("G")){
						   color="green";
				   }
				   if(readedString[1].equals("Y")){
					   color="yellow";
				   }
				   if(readedString[1].equals("R")){
					   color="red";
				   }
				   if(readedString[0].equals("D")){
					   String description="Performance Demand";
					   
					   Integer basicPoints=new Integer(readedString[3]);
					   Boolean twoWeeks=new Boolean(readedString[2]);
					   Map<Talent,Integer> demandedTalents=CollectionsFactory.createMapFactory().createMap();
					   if(!readedString[6].equals("0")){
						   demandedTalents.put(GameFactory.createTalent("clown"), new Integer(readedString[6]));
					   }
					   if(!readedString[4].equals("0")){
						   demandedTalents.put(GameFactory.createTalent("acrobat"), new Integer(readedString[4]));
					   }
					   if(!readedString[7].equals("0")){
						   demandedTalents.put(GameFactory.createTalent("big cat"), new Integer(readedString[7]));
					   }
					   if(!readedString[8].equals("0")){
						   demandedTalents.put(GameFactory.createTalent("elephant"), new Integer(readedString[8]));
					   }
					   if(!readedString[10].equals("0")){
						   demandedTalents.put(GameFactory.createTalent("freak show"), new Integer(readedString[10]));
					   }
					   if(!readedString[5].equals("0")){
						   demandedTalents.put(GameFactory.createTalent("horse"), new Integer(readedString[5]));
					   }
					   if(!readedString[9].equals("0")){
						   demandedTalents.put(GameFactory.createTalent("human cannon ball"), new Integer(readedString[9]));
					   }
					   performanceToAdd=new PerformanceDemandImpl(color, description, basicPoints, demandedTalents, twoWeeks);
			
				   }
				   if(readedString[0].equals("V")){
					   String description="Victory points";
					   Integer victoryPoints=new Integer(readedString[2]);
					   performanceToAdd=new VictoryPointsImpl(color, description, victoryPoints);
				   }
				   if(readedString[0].equals("B")){
					   String description="Bankrupt circus";
					   List<Talent> talentList=CollectionsFactory.createListFactory().createList();
					   for(String talentString:readedString){
						   Talent talentToAdd=GameFactory.createTalent(talentString);
						   if(talentToAdd!=null){
							   talentList.add(talentToAdd);
						   }
					   }
					   performanceToAdd=new BankruptCircusImpl(color, description, talentList);
				   }
				   addPerformance(performanceToAdd);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}

	
	@Override

	
	public Performance addPerformance(Performance e) {
		if(e.getColor().equals("green")){
			greenBag.add(e);}
		else if (e.getColor().equals("yellow")){
			yellowBag.add(e);}
		else if (e.getColor().equals("red")){
			redBag.add(e);}
		return e;
	}

	
	@Override

	public List<Performance> getGreenBag() {
		// TODO Auto-generated method stub
		return greenBag;
	}

	@Override
	public Performance getPerformance(String color) {
		color=color.toLowerCase();
		Performance r=null;
		if(color.equals("red")){
			Collections.shuffle(redBag);
			r = redBag.get(1);
			redBag.remove(1);}
		else if (color.equals("yellow")){
			Collections.shuffle(yellowBag);
			r = yellowBag.get(1);
			yellowBag.remove(1);}
		
		else if (color.equals("green")){
			Collections.shuffle(greenBag);
			r = greenBag.get(1);
			greenBag.get(1);
			greenBag.remove(1);}

		return r;
	}

	@Override
	public List<Performance> getRedBag() {
		// TODO Auto-generated method stub
		return redBag;
	}

	@Override
	public List<Performance> getYellowBag() {
		// TODO Auto-generated method stub
		return yellowBag;
	}

	@Override
	public Performance removePerformance(Performance p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString(){
		String cadena="";
		
		cadena=cadena+"VERDE______\r\n";
		for(Performance p:this.getGreenBag()){
			cadena=cadena+p.toString()+"\r\n";
		}
		
		cadena=cadena+"AMARILLO______\r\n";
		for(Performance p:this.getYellowBag()){
			cadena=cadena+p.toString()+"\r\n";
		}
		
		cadena=cadena+"ROJO______\r\n";
		for(Performance p:this.getRedBag()){
			cadena=cadena+p.toString()+"\r\n";
		}
		
		return cadena;
	}

}
