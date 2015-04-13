package presistence;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	private Scanner scanner;
	
	public Input() {
		this.scanner = new Scanner(System.in);
	}
	
	public String readString(){
		return scanner.next();
	}
	
	public Integer readInteger() throws InputMismatchException{
		if(!scanner.hasNextInt())
			throw new InputMismatchException();
		return scanner.nextInt();
	}
	
	public Long readLong(){
		if(!scanner.hasNextLong())
			throw new InputMismatchException();
		return scanner.nextLong();
	}

	public void closeInput(){
		scanner.close();
	}
}
