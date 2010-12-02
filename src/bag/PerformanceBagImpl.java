package bag;

import java.awt.Color;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import performance.*;
import talent.*;
import utiles.factoria.CollectionsFactory;

public class PerformanceBagImpl implements PerformanceBag {
	private List<Performance> greenBag = CollectionsFactory.createListFactory().createList();;
	private List<Performance> redBag = CollectionsFactory.createListFactory().createList();;
	private List<Performance> yellowBag= CollectionsFactory.createListFactory().createList();;
	@Override
	public Performance addPerformance(Performance e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Performance> createGreenBag() {
		//esto es a modo de prueba, realmente debera hacerlo desde fichero
		
		List<Talent> listatalentos= CollectionsFactory.createListFactory().createList();
		listatalentos.add(new ClownImpl());
		listatalentos.add(new AcrobatImpl());
		Performance bancarrota = new BankruptCircusImpl(Color.green,"circo en bancarrota" , null, listatalentos);
		Map<Talent, Integer> talents = CollectionsFactory.createMapFactory().createMap();
		talents.put(new ClownImpl(), 10);
		talents.put(new BigCatImpl(), 6);
		Performance demandaActuacion = new PerformanceDemandImpl(Color.green,"a","actuacion",10,talents,true);
		Performance puntosDeVictoria = new VictoryPointsImpl(Color.green,"Puntos","Puntos",2);
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
		Performance bancarrota = new BankruptCircusImpl(Color.red,"circo en bancarrota" , null, listatalentos);
		Map<Talent, Integer> talents = CollectionsFactory.createMapFactory().createMap();
		talents.put(new ClownImpl(), 10);
		talents.put(new BigCatImpl(), 6);
		Performance demandaActuacion = new PerformanceDemandImpl(Color.red,"a","actuacion",10,talents,true);
		Performance puntosDeVictoria = new VictoryPointsImpl(Color.red,"Puntos","Puntos",2);
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
		Performance bancarrota = new BankruptCircusImpl(Color.yellow,"circo en bancarrota" , null, listatalentos);
		Map<Talent, Integer> talents = CollectionsFactory.createMapFactory().createMap();
		talents.put(new ClownImpl(), 10);
		talents.put(new BigCatImpl(), 6);
		Performance demandaActuacion = new PerformanceDemandImpl(Color.yellow,"a","actuacion",10,talents,true);
		Performance puntosDeVictoria = new VictoryPointsImpl(Color.yellow,"Puntos","Puntos",2);
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
		Performance r= new performanceImpl(null,null,null);
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
