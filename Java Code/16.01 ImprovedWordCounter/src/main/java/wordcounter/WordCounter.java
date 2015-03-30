package wordcounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

public class WordCounter {
	private String line;
	private String[] words;
	private HashMap<String, Integer> wordHash;
	private FileReader reader;
	private BufferedReader buff;
	
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
	
	private void createWords(String delimiter){
		this.words=line.split(delimiter);
	}
	
	public void addWordsToHashMap(String delimiter){
		String word;
		Integer value;
		createWords(delimiter);
		for(int i=0;i<words.length;i++){
			word=StringUtils.lowerCase(words[i]);
			if(wordHash.containsKey(word)){
				value=wordHash.get(word)+1;
				wordHash.put(word, value);
			}
			else
				wordHash.put(word, 1);
		}
	}
	
	public HashMap<String, Integer> getHashMap(){
		return wordHash;
	}
	
	public void closeTxt() throws IOException{
		buff.close();
	}
}
