package wordcounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class WordCounter {
	public String line;
	public String[] words;
	public HashMap<String, Integer> wordHash;
	FileReader reader;
	BufferedReader buff;
	
	public WordCounter() {
		wordHash= new HashMap<String, Integer>();
		this.reader=null;
		this.buff=null;
	}
	
	public void openTxt(String filename) throws IOException{
		reader = new FileReader(filename);
		buff = new BufferedReader(reader);
	}
	
	public boolean readLine() throws IOException{
		return (line=buff.readLine())!=null;
	}
	
	public void createWords(){
		this.words=line.split(" ");
	}
	
	public void addWordsToHashMap(){
		String word;
		Integer value;
		for(int i=0;i<words.length;i++){
			word=words[i];
			if(wordHash.containsKey(word)){
				value=wordHash.get(word)+1;
				wordHash.put(word, value);
			}
			else
				wordHash.put(word, 1);
		}
	}
	
	public void listHashMap(){
		for(Entry<String, Integer> values : wordHash.entrySet()){
			String key=values.getKey();
			Integer value=values.getValue();
			System.out.println(key+": "+value);
		}
	}
	
	public void closeTxt() throws IOException{
		buff.close();
	}
}
