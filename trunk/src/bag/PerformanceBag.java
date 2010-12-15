package bag;

import java.util.List;
import performance.Performance;

public interface PerformanceBag {

	public Performance getPerformance(String color);//This method will be random, over a concrete color
	public Performance removePerformance(Performance p);
	public Performance addPerformance(Performance e);
	
	public List<Performance> getGreenBag();
	public List<Performance> getYellowBag();
	public List<Performance> getRedBag();
}
