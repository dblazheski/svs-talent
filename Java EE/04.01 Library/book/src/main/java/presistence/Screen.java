package presistence;

import presistence.actions.Action;

public class Screen {
	Input input;
	
	public Screen() {
	}
	
	public void startUpScreen(){
		print("---------------------");
		print("|     Library       |");
		print("---------------------");
	}
	
	public void printAllActions(Action[] actions){
		print("Availible commands: ");
		for(int i = 0; i<actions.length;i++){
			print((i+1)+". "+actions[i].getNameOfAction());
		}
	}
	
	public void print(String message){
		System.out.println(message);
	}
}
