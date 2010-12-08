package bag;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PerformanceBag pb=new PerformanceBagImpl("/data/performancecfg.txt");
		
		System.out.println(pb);

	}

}
