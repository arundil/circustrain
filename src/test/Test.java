package test;

import game.factory.GameFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import tipos.Cadenas;

public class Test {
	
	public static String takeParametersToStringRestricted1(String message,String condition){
		List<String> conditions=Cadenas.separaElementos(condition,",");
		String line="";
		while(!conditions.contains(line)){
			line= GameFactory.takeParametersToString(message);
		}
		return line;		
	}
	public static String takeParametersToStringRestricted(String message,String condition){
		List<String> conditions=Cadenas.separaElementos(condition,",");
		String line="";
		while((!line.equals(conditions.get(0))) || (!line.equals(conditions.get(1)))){
			line= GameFactory.takeParametersToString(message);
			if((line.equals(conditions.get(0))) || (line.equals(conditions.get(1)))){
				break;
			}
		}
		return line;		
	}	
	
	public static void main(String[] args) {
//		String line2=takeParametersToStringRestricted("ohhhh, que bueno, negra: si,no", "si,no");
		String line= takeParametersToStringRestricted1("le?: 1,2,3,4","1,2,3,4");
		
		
	}  

}
