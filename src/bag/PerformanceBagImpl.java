package bag;

import java.awt.Color;
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
//		this.createGreenBag();
//		this.createYellowBag();
//		this.createRedBag();
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
				   Color color=null;
				   String []readedString=fileLine.split(",");
				   if(readedString[1]=="g"){
						   color=Color.green;
				   }
				   if(readedString[1]=="y"){
					   color=Color.yellow;
				   }
				   if(readedString[1]=="r"){
					   color=Color.red;
				   }
				   if(readedString[0].equals("D")){
					   String description="Performance Demand";
					   Integer basicPoints=new Integer(readedString[4]);
					   Boolean twoWeeks=new Boolean(readedString[3]);
					   Map<Talent,Integer> demandedTalents=CollectionsFactory.createMapFactory().createMap();
					   if(!readedString[4].equals("0")){
						   demandedTalents.put(new ClownImpl(), new Integer(readedString[4]));
					   }
					   if(!readedString[5].equals("0")){
						   demandedTalents.put(new AcrobatImpl(), new Integer(readedString[5]));
					   }
					   if(!readedString[6].equals("0")){
						   demandedTalents.put(new BigCatImpl(), new Integer(readedString[6]));
					   }
					   if(!readedString[7].equals("0")){
						   demandedTalents.put(new ElephantImpl(), new Integer(readedString[7]));
					   }
					   if(!readedString[8].equals("0")){
						   demandedTalents.put(new FreakShowImpl(), new Integer(readedString[8]));
					   }
					   if(!readedString[9].equals("0")){
						   demandedTalents.put(new HorseImpl(), new Integer(readedString[9]));
					   }
					   if(!readedString[10].equals("0")){
						   demandedTalents.put(new HumanCannonballImpl(), new Integer(readedString[10]));
					   }
					   Performance performanceToAdd=new PerformanceDemandImpl(color, description, basicPoints, demandedTalents, twoWeeks);
					   addPerformance(performanceToAdd);					   
				   }

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}

	
	@Override

	
	public Performance addPerformance(Performance e) {
		if(e.getColor() == Color.red){
			redBag.add(e);}
		else if (e.getColor() == Color.yellow){
			yellowBag.add(e);}
		else if (e.getColor() == Color.green){
			greenBag.add(e);}
		return e;
	}

	@Override
	public List<Performance> createGreenBag() {
		//esto es a modo de prueba, realmente debera hacerlo desde fichero
		
		List<Talent> listatalentos= CollectionsFactory.createListFactory().createList();
		listatalentos.add(new ClownImpl());
		listatalentos.add(new AcrobatImpl());
		Performance bancarrota = new BankruptCircusImpl(Color.green,"circo en bancarrota" , listatalentos);
		Map<Talent, Integer> talents = CollectionsFactory.createMapFactory().createMap();
		talents.put(new ClownImpl(), 10);
		talents.put(new BigCatImpl(), 6);
		Performance demandaActuacion = new PerformanceDemandImpl(Color.green,"actuacion",10,talents,true);
		Performance puntosDeVictoria = new VictoryPointsImpl(Color.green,"Puntos",2);
		greenBag.add(bancarrota);
		greenBag.add(demandaActuacion);
		greenBag.add(puntosDeVictoria);
		return greenBag;
	}

	@Override

	public List<Performance> createRedBag() {
		// Aunque sea el mismo codigo que el anterior y el siguiente, realmente cambiara
		List<Talent> listatalentos= CollectionsFactory.createListFactory().createList();
		listatalentos.add(new ClownImpl());
		listatalentos.add(new AcrobatImpl());
		Performance bancarrota = new BankruptCircusImpl(Color.red,"circo en bancarrota" , listatalentos);
		Map<Talent, Integer> talents = CollectionsFactory.createMapFactory().createMap();
		talents.put(new ClownImpl(), 10);
		talents.put(new BigCatImpl(), 6);
		Performance demandaActuacion = new PerformanceDemandImpl(Color.red,"actuacion",10,talents,true);
		Performance puntosDeVictoria = new VictoryPointsImpl(Color.red,"Puntos",2);
		redBag.add(bancarrota);
		redBag.add(demandaActuacion);
		redBag.add(puntosDeVictoria);
		return 	redBag;
	}

	@Override
	public List<Performance> createYellowBag() {
		List<Talent> listatalentos= CollectionsFactory.createListFactory().createList();
		listatalentos.add(new ClownImpl());
		listatalentos.add(new AcrobatImpl());
		Performance bancarrota = new BankruptCircusImpl(Color.yellow,"circo en bancarrota" , listatalentos);
		Map<Talent, Integer> talents = CollectionsFactory.createMapFactory().createMap();
		talents.put(new ClownImpl(), 10);
		talents.put(new BigCatImpl(), 6);
		Performance demandaActuacion = new PerformanceDemandImpl(Color.yellow,"actuacion",10,talents,true);
		Performance puntosDeVictoria = new VictoryPointsImpl(Color.yellow,"Puntos",2);
		yellowBag.add(bancarrota);
		yellowBag.add(demandaActuacion);
		yellowBag.add(puntosDeVictoria);
		return yellowBag;
	}

	@Override

	public List<Performance> getGreenBag() {
		// TODO Auto-generated method stub
		return greenBag;
	}

	@Override
	public Performance getPerformance(Color color) {
		// TODO Auto-generated method stub
		Performance r= new performanceImpl(null,null);
		if(color == Color.red){
			Collections.shuffle(redBag);
			r = redBag.get(1);
			redBag.remove(1);}
		else if (color == Color.yellow){
			Collections.shuffle(yellowBag);
			r = yellowBag.get(1);
			yellowBag.remove(1);}
		
		else if (color == Color.green){
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

}
