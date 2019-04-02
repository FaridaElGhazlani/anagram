package anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mot {

	String mot;
	
	public Mot(String mot) {
		super();
		this.mot = mot;
	}

	public static boolean isMot1InMot2(String mot1, String mot2) {
	
		List<String> listmot1 = new ArrayList<>();
		String[] splitmot1 = mot1.toLowerCase().split("");
		listmot1= new ArrayList(Arrays.asList(splitmot1));
		
		List<String> listmot2 = new ArrayList<>();
		String[] splitmot2 = mot2.toLowerCase().split("");
		listmot2= new ArrayList(Arrays.asList(splitmot2));
		
		for (String letter : listmot1) {
			if (listmot2.isEmpty()) {return false;}
			if(!listmot2.remove(letter)){
				return false;
			}
		}
		return true;
		
	}
	
	public boolean isIn(Mot conteneur) {
		return isMot1InMot2(mot, conteneur.mot);
	}
	
	@Override
	public String toString() {
		return mot;
	}
}
