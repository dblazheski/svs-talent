package wordcounter;

import java.io.IOException;

public class WordCounterApplication {

	public static void main(String[] args) {
		WordCounter counter = new WordCounter();
		try {
			counter.openTxt("C:\\words.txt");
			while(counter.readLine()){
				counter.createWords();
				counter.addWordsToHashMap();
			}
			counter.listHashMap();
			counter.closeTxt();
		} catch (IOException e) {}
	}

}
