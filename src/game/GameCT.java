package game;

public interface GameCT {
	
	public void startGame(); //Aqui estara el algoritmo que preguntara las condiciones del juego
	public void runGame(); //Aqui se implementara el juego con muchos if.
	public void finishGame(); //Reglas finales del juego
	
	public void finishMonthGame(); //Aqui se implementara las acciones que se hacen al final del mes.
	
	public void addCityBoard(); //Añadir las ciudades que faltan al tablero.
}
