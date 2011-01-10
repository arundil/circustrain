package actionCards;

import game.CircusTrainGame;
import java.util.List;

import player.Player;
import board.City;
import talent.Acrobat;
import talent.AcrobatImpl;
import talent.Clown;
import talent.ClownImpl;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import card.CardImpl;

public class RestImpl extends CardImpl  implements ActionCard  {
	CircusTrainGame ctg;
	public RestImpl(CircusTrainGame ctg, Player player) {
		super("DESCANSO","Si estas en Canada (Winnipeg, Montreal or Toronto), " +
				"puedes coger un payaso, un acrobata o incrementar tu reputación en un nivel",player);
		this.ctg = ctg;
	}

	public void execute() {
		//cambiado player por getPlayer()
		City city = getPlayer().getCity();
		
		System.out.println(getPlayer().getName()+" ha usado ==> DESCANSO <== \n" );
		System.out.print("You city now is "+getPlayer().getCity());
		
		if(city.isCanada()){
			List<Talent> listtalent = CollectionsFactory.createListFactory().createList();
			Clown clown = new ClownImpl();
			Acrobat acrobat = new AcrobatImpl();
			Integer answer;
			
			System.out.println(" ¡¡¡Estás en Canada!!! Puedes contratar \n " +
					"[1] un payaso \n " +
					"[2] un acrobata \n " +
					"[3] incrementar un nivel tu reputación");
			
			answer= readDataFromKeyBoard.takeParametersToIntegerRestricted("Opciones:", "1,2,3");
			
			if(answer == 1){
				if(ctg.getTalentBag().getNumTypeTalent(clown)>0){
					listtalent.add(ctg.getTalentBag().removeTalent(clown));
					getPlayer().addTalent(listtalent);
				}else{
					System.out.println("No quedan payasos");
					execute();
				}
			}
			if(answer == 2){
				if(ctg.getTalentBag().getNumTypeTalent(acrobat)>0){
					listtalent.add(ctg.getTalentBag().removeTalent(acrobat));
					getPlayer().addTalent(listtalent);
				}else{
					System.out.println("No quedan acrobatas");
					execute();
				}
				
			}
			if(answer == 3){
				if(!getPlayer().addReputation(1)){
					System.out.println("Ya tienes la mejor reputación. No es posible subirla más.");
					execute();
				}
			}
		}else{
			System.out.println("No estás en Canada. Descansa.");
		}
	}
}
