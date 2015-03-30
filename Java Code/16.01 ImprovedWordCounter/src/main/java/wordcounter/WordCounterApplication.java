package wordcounter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class WordCounterApplication {

	public static void main(String[] args) {
		WordCounter counter = new WordCounter();
		HashMap<String,Integer> hash;
		String delimiter=" ";
		try {
			counter.openTxt("C:\\words.txt");
			while(counter.readLine()){
				counter.addWordsToHashMap(delimiter);
			}
			hash = counter.getHashMap();
			listHashMap(hash);
			counter.closeTxt();
		} catch (IOException e) {}
	}
	
	public static void listHashMap(HashMap<String, Integer> hashmap){
	for(Entry<String, Integer> values : hashmap.entrySet()){
		String key=values.getKey();
		Integer value=values.getValue();
		System.out.println(key+": "+value);
	}
	}

}
