package utiles.factoria;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import tipos.Cadenas;

public class readDataFromKeyBoard {

	public static Integer takeParametersToInteger(String message){
		Integer number=-1;
		try {
			System.out.print(message.toString());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String linea = br.readLine();
			number = Integer.parseInt(linea);
		} catch (Exception e) {
		}
		return number;
	}

	public static String takeParametersToStringRestricted(String message,String condition){
		List<String> conditions=Cadenas.separaElementos(condition,",");
		String line="";
		while(!conditions.contains(line)){
			line= readDataFromKeyBoard.takeParametersToString(message);
		}
		return line;		
	}

	public static Integer takeParametersToIntegerRestricted(String message, String condition){
		Integer number = -1;
		List<String> conditions=Cadenas.separaElementos(condition,",");
		while(!conditions.contains(number.toString())){
			number= takeParametersToInteger(message);
		}
		return number;		
	}

	public static Integer takeParametersToIntegerTopValue(String message, Integer top){
		Integer number = -1;
		while(!(number >= 0 && number <= top)){
			number= takeParametersToInteger(message);
		}
		return number;		
	}

	public static String takeParametersToString(String message){
		String line=null;
		try {
			System.out.print(message.toString());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch (Exception e) {
		}
		return line;
	}

}
