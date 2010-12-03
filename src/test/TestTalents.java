package test;

import java.util.Map;

import talent.Talent;
import bag.TalentBagImpl;

public class TestTalents extends Test{
	
	public static void main(String[] args) {
Map<Talent, Integer> t = TalentBagImpl.createInitialTalentBag();
		
		System.out.println(t.toString());
	}

}
