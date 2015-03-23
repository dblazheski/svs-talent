package aliexpress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Database {
	public String line;
	public String[] words;
	private FileReader reader;
	private BufferedReader buff;
	
	public Database(String filename) throws IOException {
		this.reader = new FileReader(filename);
		this.buff = new BufferedReader(reader);
	}
	
	public boolean readLine() throws IOException{
		return (line=buff.readLine())!=null;
	}
	
	public void createWords(String delimiter){
		this.words=line.split(delimiter);
	}
	
	public String[] getWords() {
		return words;
	}
	
	public void closeTxt() throws IOException{
		buff.close();
	}

}
