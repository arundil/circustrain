package test;

import talent.Clown;
import talent.ClownImpl;
import bag.TalentBag;
import bag.TalentBagImpl;

public class TestTalents extends Test {

	public static void main(String[] args) {
		TalentBag t = new TalentBagImpl();

		Clown cw = new ClownImpl();
		Clown cw1 = new ClownImpl();
		boolean res = cw.equals(cw1);
		System.out.println(cw);
		System.out.println(t);
		
	}

}
