package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
	
	public static String takeParametersToString(String message){
		String line=null;
		try {
			System.out.print(message.toString());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in.));
			line = br.readLine();
			if(!){
			}
		} catch (Exception e) {
		}
		return line;
	}


	public static void main(String[] args) {
		
		String line= takeParametersToString("le?");
		
		System.out.println(line.toString());
		
		
	}  

}
