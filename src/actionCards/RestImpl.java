package actionCards;

import game.TwoPlayersGame;

import java.util.List;

import board.City;
import player.Player;
import talent.Acrobat;
import talent.AcrobatImpl;
import talent.Clown;
import talent.ClownImpl;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import card.CardImpl;

public class RestImpl extends CardImpl  implements ActionCard  {
	Integer id;
	Player player;
	TwoPlayersGame ctg;
	
	public RestImpl(Player player, TwoPlayersGame ctg) {
		super("DESCANSO","Si estas en Canada (Winnipeg, Montreal or Toronto), " +
				"puedes coger un payaso, un acrobata o incrementar tu reputación en un nivel" );
		this.id = 8;
		this.player = player;
		this.ctg = ctg;
	}

	public void execute() {
		City city = player.getCity();
		
		System.out.println(player.getName()+" ha usado ==> DESCANSO <== \n" );
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
			
			answer= readDataFromKeyBoard.takeParametersToIntegerRestricted("Option:", "1,2,3");
			
			if(answer == 1){
				if(ctg.getTalentBag().getNumTalents(clown)>0){
					listtalent.add(ctg.getTalentBag().removeTalent(clown));
					player.addTalent(listtalent);
				}else{
					System.out.println("Clowns are not available");
					execute();
				}
			}
			if(answer == 2){
				if(ctg.getTalentBag().getNumTypeTalent(acrobat)>0){
					listtalent.add(ctg.getTalentBag().removeTalent(acrobat));
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
	
	
	
	public String toString() {
		return "[" + id + "]" + super.toString();
	}

}