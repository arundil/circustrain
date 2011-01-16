package talent;

/*
 * Objeto payaso
 */

public class ClownImpl extends TalentImpl implements Clown {

	public ClownImpl() {
		super(1);
	}
	
	public String toString(){
		return "Payaso";
	}
}
