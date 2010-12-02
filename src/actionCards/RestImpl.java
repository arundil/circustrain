package actionCards;

import java.util.List;

import game.factory.GameFactory;
import bag.TalentBag;
import board.City;
import player.Player;
import talent.Acrobat;
import talent.AcrobatImpl;
import talent.Clown;
import talent.ClownImpl;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import card.CardImpl;

public class RestImpl extends CardImpl implements ActionCard {
	Integer id;
	Player player;
	TalentBag talentbag;
	
	public RestImpl(Player player, TalentBag talentbag) {
		super("Rest","If you are in Canada (Winnipeg, Montreal or Toronto), " +
				"you can take one clown, one acrobat or rise your reputation in one level" );
		this.id = 7;
		this.player = player;
		this.talentbag = talentbag;
	}

	public void execute() {
		City city = player.getCity();
		
		System.out.println(player.getName()+" has used ==> REST <== \n" );
		System.out.print("You city now is "+player.getCity());
		
		if(city.isCanada()){
			List<Talent> listtalent = CollectionsFactory.createListFactory().createList();
			Clown clown = new ClownImpl();
			Acrobat acrobat = new AcrobatImpl();
			Integer answer;
			
			System.out.println(" You are in Canada! You can take \n " +
					"[1]one clown \n " +
					"[2]one acrobat \n " +
					"[3]or rise your reputation in one level");
			
			answer= GameFactory.takeParametersToIntegerRestricted("Option:", "1,2,3");
			
			if(answer == 1){
				if(talentbag.getNumTalents(clown)>0){
					listtalent.add(talentbag.removeTalent(clown));
					player.addTalent(listtalent);
				}else{
					System.out.println("Clowns are not available");
					execute();
				}
			}
			if(answer == 2){
				if(talentbag.getNumTypeTalent(acrobat)>0){
					listtalent.add(talentbag.removeTalent(acrobat));
					player.addTalent(listtalent);
				}else{
					System.out.println("Acrobat are not available");
					execute();
				}
				
			}
			if(answer == 3){
				if(!player.addReputation(1)){
					System.out.println("Rise reputation are not available");
					execute();
				}
			}
		}else{
			System.out.println("so you are not in Canada. Now you rest");
		}
	}

	public Integer getIdCard() {
		return id;
	}

}
