package utiles.factoria;




public class CollectionsFactory {

	private CollectionsFactory(){}

	public static ListFactory createListFactory(){
		return new ListFactory();
	}

	public static SetFactory createSetFactory(){
		return new SetFactory();
	}
	
	public static MapFactory createMapFactory(){
		return new MapFactory();
	}
	
	public static GraphFactory createGraphFactory(){
		return new GraphFactory();
	}
	
	public static VertexFactory createVertexFactory(){
		return new VertexFactory();
	}
}