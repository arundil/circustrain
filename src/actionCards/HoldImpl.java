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

public class HoldImpl extends CardImpl implements ActionCard {
	Integer id;
	Player player;
	TalentBag talentbag;
	
	public HoldImpl(Player player, TalentBag talentbag) {
		super("HoldImpl","If you are in Canada (Winnipeg, Montreal or Toronto), " +
				"you can take one clown, one acrobat or rise your reputation in one level" );
		this.id = 8;
		this.player = player;
		this.talentbag = talentbag;
	}

	public void execute() {
		City city = player.getCity();
		
		if(city.isCanada()){
			String mess = "Do you want? \n 1: clown \n 2: acrobat \n 3: rise your reputation in one level";
			String cond="1,2,3";
			String resp= GameFactory.takeParametersToStringRestricted(mess, cond);
			Integer respuesta = new Integer(resp);
			List<Talent> listtalent = CollectionsFactory.createListFactory().createList();
			Clown clown = new ClownImpl();
			Acrobat acrobat = new AcrobatImpl();
			
			if(respuesta == 1){
				if(talentbag.getNumTalents(clown)>0){
					listtalent.add(talentbag.removeTalent(clown));
					player.addTalent(listtalent);
				}else{
					System.out.println("Clowns are not available");
					execute();
				}
			}
			if(respuesta == 2){
				if(talentbag.getNumTypeTalent(acrobat)>0){
					listtalent.add(talentbag.removeTalent(acrobat));
					player.addTalent(listtalent);
				}else{
					System.out.println("Acrobat are not available");
					execute();
				}
				
			}
			if(respuesta == 3){
				if(!player.addReputation(1)){
					System.out.println("Rise reputation are not available");
					execute();
				}
			}
		}
	}

	public Integer getIdCard() {
		return id;
	}

}
