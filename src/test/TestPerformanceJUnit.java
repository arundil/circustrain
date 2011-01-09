package test;

import org.junit.Before;
import org.junit.Test;

import performance.Performance;

import performance.VictoryPointsImpl;
import bag.PerformanceBag;
import bag.PerformanceBagImpl;
	

public class TestPerformanceJUnit {
	PerformanceBag p1;
	@Before
	 public void setUp() throws Exception {
		p1 = new PerformanceBagImpl("/data/performancecfg.txt");
	}
	@Test
	public void testAddPerformance(){
		Performance e = null;
		e = new VictoryPointsImpl("red", "", 3);
		p1.addPerformance(e);
		assert p1.getRedBag().size() == 28 : "Numero de actuaciones incorrecto. Hay "+p1.getRedBag().size();
	}
	@Test
	public void testGetPerformanceRed(){
		assert p1.getPerformance("red").getColor() == "red";
	}
	@Test
	public void testGetPerformanceGreen(){
		assert p1.getPerformance("green").getColor() == "green";
	}
	@Test
	public void testGetPerformanceYellow(){
		assert p1.getPerformance("yellow").getColor() == "yellow";
	}
}
