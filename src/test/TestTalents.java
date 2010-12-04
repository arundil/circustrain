package test;

import bag.TalentBag;
import bag.TalentBagImpl;

public class TestTalents extends Test {

	public static void main(String[] args) {
		TalentBag t = new TalentBagImpl();

		System.out.println(t.toString());
	}

}
