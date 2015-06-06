package com.test;

import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;

public class ParseData {
	
	private static Set<String> bigrams;
	
	private static Set<String> trigrams;

	public Set<String> getBigrams() {
		return bigrams;
	}

	public Set<String> getTrigrams() {
		return trigrams;
	}
	
	public ArrayList<String> parseDataIntoTokenArray(String text){
	   StringTokenizer st = new StringTokenizer(text);
	   ArrayList<String> s = new ArrayList<String>();
	   while(st.hasMoreTokens()){
		s.add(st.nextToken()); 
	   }
	   return s;
	}
	
	public void createBigram(ArrayList<String> textArray){
		for(int i=0; (i<textArray.size()&& i+1<textArray.size()) ; i = i+2){
			bigrams.add(textArray.get(i)+ textArray.get(i+1));
		}
	}
	
	public void createTrigram(ArrayList<String> textArray){
		for(int i=0; (i<textArray.size()&& i+1<textArray.size() && i+2<textArray.size()); i = i+3){
			trigrams.add(textArray.get(i)+ textArray.get(i+1)+ textArray.get(i+2));
		}
	}
}
