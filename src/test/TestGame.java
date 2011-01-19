package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import game.CircusTrainGame;
import game.factory.GameFactory;

public class TestGame {
	public static void main (String[] args){		
		//initData();
		CircusTrainGame game= GameFactory.createCircusTrainGame();
		game.runGame();
	}
	//Crea los ficheros .txt necesarios para el funcionamiento del juego
//	private static void initData() {
//		
//		createDir();
//		try { createBoard();
//		} catch (IOException e) { 
//			System.out.print("ERROR al crear el fichero \"boardcfg.txt\""); 
//		}
//		try { createPermormances();
//		} catch (IOException e) { 
//			System.out.print("ERROR al crear el fichero \"performancecfg.txt\""); 
//		}
//	}
//	//Crea una directorio
//	private static void createDir() {
//		//Creamos una referencia al objeto File(por si solo no es nada). 
//		//Lo que se hace es darle un nombre y un lugar mediante una ruta relativa
//		//al fichero .jar
//		File dir = new File("data");
//		//El método nos devolvera true si el fichero ya existe.
//		//Si no existe lo creamos mediante el método .mkdir()
//		if (!dir.exists()) {
//			dir.mkdir();
//		}
//	}
//	//Similar al createPerformaces
//	private static void createBoard() throws IOException {
//		File file1 = new File("data/boardcfg.txt");
//		file1.createNewFile();
//		FileWriter fileWriter = new FileWriter(file1);
//		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//		
//		String content = initStringBoard();
//		String[] content_array = content.split("\n");
//		
//		int index = 0;
//		
//		for (String string_content : content_array) {
//			++index;
//			bufferedWriter.write(string_content);
//			if (index < content_array.length) {
//				bufferedWriter.newLine();
//			}
//		}
//		bufferedWriter.close();
//	}
//
//	private static void createPermormances() throws IOException {
//		//Creamos una referencia al objeto File(por si solo no es nada). 
//		//Lo que se hace es darle un nombre y un lugar mediante una ruta relativa
//		//al fichero .jar
//		File file2 = new File("data/performancecfg.txt");
//		//Aqui SE CREA el fichero
//		file2.createNewFile();
//		//Para escribir hacen falta 2 objetos: un tipo FileWriter, necesario para
//		//saber en qué fichero se va a escribir, y un BufferedWriter que necesita como
//		//parametro un FileWriter para saber el fichero de destino y tener la opcion
//		//de añadir nuevas lineas
//		FileWriter fileWriter = new FileWriter(file2);
//		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//		
//		//initStringPerform crea un String con Todo lo que contendra el fichero .txt
//		String content = initStringPerform();
//		//Metemos en un array (no es que me gusten, pero el método devuelve eso)
//		//los distintos String separados por "\n". El método split es similar al
//		//Cadenas.separaElementos
//		String[] content_array = content.split("\n");
//		
//		int index = 0;
//		//Recorremos el array
//		for (String string_content : content_array) {
//			++index;
//			//vamos escribiendo los diferentes Strings en el fichero mediante
//			//el bufferedWriter metiendole como parametros estos String
//			bufferedWriter.write(string_content);
//			//si estamos en el ultimo fragmento de un String hara un salto de linea
//			if (index < content_array.length) {
//				bufferedWriter.newLine();
//			}
//		}
//		//Para que se guarde la informacion y se cierre el flujo del buffer
//		//hay que cerrarlo con el .close()
//		bufferedWriter.close();
//	}
//	
//	private static String initStringBoard() {
//		
//		String content = 
//			"C,Winnipeg,true\n" +
//			"C,Toronto,true\n" +
//			"C,Montreal,true\n" +
//			"C,Duluth,false\n" +
//			"C,Madison,false\n" +
//			"C,Milwaukee,false\n" +
//			"C,Detroit,false\n" +
//			"C,Buffalo,false\n" +
//			"C,Rochester,false\n" +
//			"C,Albany,false\n" +
//			"C,Boston,false\n" +
//			"C,New Heaven,false\n" +
//			"C,New York,false\n" +
//			"C,Philadelphia,false\n" +
//			"C,Richmond,false\n" +
//			"C,Pittsburg,false\n" +
//			"C,Columbus,false\n" +
//			"C,Cincinnati,false\n" +
//			"C,Louisville,false\n" +
//			"C,Indianapolis,false\n" +
//			"C,St. Louis,false\n" +
//			"C,Peoria,false\n" +
//			"C,Des Moines,false\n" +
//			"C,Omaha,false\n" +
//			"C,St. Paul,false\n" +
//			"C,Chicago,false\n" +
//			"C,Cleveland,false\n" +
//			"R,Winnipeg,Duluth\n" +
//			"R,Duluth,Madison\n" +
//			"R,Madison,Milwaukee\n" +
//			"R,Madison,Chicago\n" +
//			"R,Chicago,Detroit\n" +
//			"R,Detroit,Toronto\n" +
//			"R,Toronto,Buffalo\n" +
//			"R,Buffalo,Rochester\n" +
//			"R,Rochester,Montreal\n" +
//			"R,Albany,Boston\n" +
//			"R,Montreal,Albany\n" +
//			"R,Boston,New Heaven\n" +
//			"R,New Heaven,New York\n" +
//			"R,New York,Philadelphia\n" +
//			"R,Philadelphia,Pittsburg\n" +
//			"R,Pittsburg,Columbus\n" +
//			"R,Pittsburg,Richmond\n" +
//			"R,Columbus,Cincinnati\n" +
//			"R,Cincinnati,Indianapolis\n" +
//			"R,Indianapolis,Louisville\n" +
//			"R,Indianapolis,St. Louis\n" +
//			"R,Indianapolis,Chicago\n" +
//			"R,Chicago,Peoria\n" +
//			"R,Peoria,Des Moines\n" +
//			"R,Des Moines,Omaha\n" +
//			"R,Des Moines,St. Paul\n" +
//			"R,St. Paul,Winnipeg\n" +
//			"R,Chicago,Madison\n" +
//			"R,Columbus,Cleveland\n" +
//			"R,New York,Albany\n" +
//			"R,Detroit,Cleveland\n" ;
//		
//		return content;
//	}
//	
//	private static String initStringPerform() {
//		
//		String content = 
//			"D,G,false,2,5,0,5,0,0,0,0\n" +
//			"D,G,false,2,3,0,0,0,0,0,7\n" +
//			"D,G,false,3,0,5,0,0,0,0,7\n" +
//			"D,G,false,2,0,7,0,0,0,0,7\n" +
//			"D,G,false,2,3,0,0,10,0,0,0\n" +
//			"D,G,false,2,2,5,0,0,0,10,0\n" +
//			"D,G,false,3,0,5,2,10,0,0,0\n" +
//			"D,G,false,2,0,0,3,0,0,10,0\n" +
//			"D,G,false,3,0,0,2,0,15,0,0\n" +
//			"D,G,false,3,0,0,2,0,0,0,5\n" +
//			"D,G,false,2,0,7,0,0,0,3,0\n" +
//			"D,G,false,2,2,0,0,0,0,10,0\n" +
//			"D,Y,false,2,5,0,0,10,0,0,5\n" +
//			"D,Y,false,2,0,0,3,0,0,15,10\n" +
//			"D,Y,false,3,5,0,5,0,15,15,0\n" +
//			"D,Y,false,3,0,8,0,15,0,5,7\n" +
//			"D,Y,false,2,0,8,5,0,10,0,7\n" +
//			"D,Y,false,3,0,7,10,15,0,8,0\n" +
//			"D,Y,false,2,3,0,0,0,15,2,0\n" +
//			"D,Y,false,2,0,0,5,10,0,0,5\n" +
//			"D,Y,false,2,0,0,5,10,0,0,5\n" +
//			"D,Y,false,2,5,5,0,0,0,0,10\n" +
//			"D,Y,false,2,0,5,3,0,15,0,0\n" +
//			"D,Y,false,3,10,0,0,0,10,15,0\n" +
//			"D,R,true,10,10,15,5,20,40,0,15\n" +
//			"D,R,true,10,5,15,10,0,0,25,15\n" +
//			"D,R,true,15,5,0,10,20,40,25,15\n" +
//			"D,R,true,10,10,15,5,20,40,25,15\n" +
//			"D,R,true,10,10,0,5,0,40,40,25,14\n" +
//			"D,R,true,10,5,15,10,20,40,25,0\n" +
//			"D,R,true,7,10,10,5,20,40,0,10\n" +
//			"D,R,true,7,5,5,10,25,40,0,10\n" +
//			"D,R,true,10,5,15,10,25,40,25,0\n" +
//			"D,R,true,15,5,10,5,0,25,40,5,15\n" +
//			"D,R,false,5,7,25,3,0,25,0,10,\n" +
//			"D,R,false,5,10,10,0,20,25,5,10\n" +
//			"D,R,false,5,7,10,3,20,0,0,0\n" +
//			"D,R,false,5,3,10,7,20,0,25,15\n" +
//			"D,R,false,5,5,10,10,20,25,25,0\n" +
//			"V,G,2\n" +
//			"V,G,2\n" +
//			"V,Y,3\n" +
//			"V,Y,3\n" +
//			"V,Y,1\n" +
//			"V,R,3\n" +
//			"V,R,3\n" +
//			"V,R,3\n" +
//			"V,R,3\n" +
//			"V,R,2\n" +
//			"V,R,4\n" +
//			"B,G,Clown,Acrobat\n" +
//			"B,G,Freak Show,Acrobat\n" +
//			"B,G,Clown,Horse\n" +
//			"B,G,Clown,Big Cat\n" +
//			"B,G,Horse,Big Cat\n" +
//			"B,G,Elephant,Human Cannon Ball\n" +
//			"B,Y,Clown,Freak Show,Elephant\n" +
//			"B,Y,Acrobat,Freak Show,Big Cat\n" +
//			"B,Y,Clown,Freak Show,Big Cat\n" +
//			"B,Y,Acrobat,Human Cannon Ball,Elephant\n" +
//			"B,Y,Horse,Freak Show,Big Cat\n";
//		
//		return content;
//	}
	
}
