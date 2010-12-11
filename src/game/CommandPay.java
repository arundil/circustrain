package game;

import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import player.Player;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;

public class CommandPay extends AbstractCommand{
	
	private Player player;
	private CircusTrainGame game;
	private Integer wageMultiplicator;
	
	
	
	public CommandPay(Player player,CircusTrainGame game){
		this.player=player;
		this.game=game;
		this.wageMultiplicator=1;
		talentSet = player.getTalents().entrySet();
	}
	public CommandPay(Player player,CircusTrainGame game,Integer multiplicator){
		this.player=player;
		this.game=game;
		this.wageMultiplicator=multiplicator;
		talentSet = player.getTalents().entrySet();
	}
		
	Set<Entry<Talent,Integer>> talentSet; 
	List<Integer> options = CollectionsFactory.createListFactory().createList();
	String conditions="";
	String talents = "";
	
	List<Entry<Talent,Integer>> talentList=CollectionsFactory.createListFactory().createList();
	public void execute(){
		Integer totalTalents=0;
		assert talentSet!=null:"Set de talentos null";
		for(Entry<Talent,Integer> entry:talentSet){
			totalTalents=totalTalents+entry.getValue();
		}		
		for(int i=0;i<totalTalents;i++){
			showTalents();
			String selectAction="What do you want to do? "+"\n"+"1 : Pay talent's wage"+"\n"+"2 : Fire talent";
			String selectActionCondition="1,2";
			Integer choice=readDataFromKeyBoard.takeParametersToIntegerRestricted(selectAction, selectActionCondition);
			if(choice==1){
				Integer talentSelector=readDataFromKeyBoard.takeParametersToIntegerRestricted("Select a talent", conditions);
				Talent selectedTalent=talentList.get(talentSelector-1).getKey();
				int dineroInicial = player.getMoney();
				int cantidadInicial = player.getTalents().get(selectedTalent);
				if(!(player.getMoney()<selectedTalent.getWage()*wageMultiplicator)){
					player.addMoney(-selectedTalent.getWage()*wageMultiplicator);	
					int dineroProcesado = player.getMoney();
					int cantidadProcesada = player.getTalents().get(selectedTalent);
					assert dineroInicial > dineroProcesado:"El decremento del dinero no se hizo";
					assert cantidadInicial == cantidadProcesada:"Se han perdido talentos del tipo seleccionado";
				}else{
					System.out.println("You don't have money enough");
					i--;
				}
			}
			else{
				Integer talentSelector=readDataFromKeyBoard.takeParametersToIntegerRestricted("Select a talent", conditions);
				Talent selectedTalent=talentList.get(talentSelector-1).getKey();
				toFire(selectedTalent);
			}			
		}		
	}
	
	private void toFire(Talent talent){
		int numeroDeTalentosDelJugadorPrevio=player.getTalents().get(talent);
		int numeroDeTalentosEnBolsaPrevio=game.getTalentBag().getNumTalents(talent);
		
		player.discardTalent(talent);
		game.getTalentBag().addTalent(talent);
		
		assert !player.getTalents().containsKey(talent):"No se han borrado los talentos del jugador";
		//assert numeroDeTalentosEnBolsaPrevio<numeroDeTalentosEnBolsaProcesado:"No se ha devuelto el talento a la bolsa";
		
		if(game.getMonth().equals("AUGUST") || game.getMonth().equals("SEPTEMBER")){			
			if(player.getVictoryPoints()<3){
				player.addVictoryPoints(-player.getVictoryPoints());
				assert player.getVictoryPoints()!=0:"Puntos de victoria no son 0";
			}else{
				player.addVictoryPoints(-3);
				assert player.getVictoryPoints()>=0:"Puntos de victoria negativos";
			}
		}else{
			if(player.getReputation()<7){
				player.addReputation(1);
				assert player.getReputation()<7:"Reputacion fuera de rango";
			}
		}
	}	

	private void showTalents(){	
		talentList.clear();
		talentList.addAll(player.getTalents().entrySet());
		options.clear();
		talents="";
		conditions="";
		//Mostrar los que NO hayan sido tratados
		for(int i=1;i<=talentList.size();i++){
			Talent currentTalent=talentList.get(i-1).getKey();
			Integer number=talentList.get(i-1).getValue();
			talents+=i+" : Talent > "+currentTalent.getName()+", Wage > "+currentTalent.getWage()*wageMultiplicator+", Amount > "+number+"\n";
			options.add(i);
			conditions=conditions+","+i;
		}
		System.out.println(talents);
	}
}
