package presistence.actions;

import presistence.Input;
import presistence.Screen;
import presistence.services.BookViewService;

public abstract class Action {
	private String nameOfAction;
	private String commandAction;
	public Screen screen;
	private Input input;
	
	public Action(String nameOfAction) {
		this.nameOfAction = nameOfAction;
		this.screen = new Screen();
		this.input = new Input();
	}
	
	public String getNameOfAction() {
		return nameOfAction;
	}
	
	public Input getInput() {
		return input;
	}
	
	public void setCommandAction(String commandAction) {
		this.commandAction = commandAction;
	}
	
	public String getCommandAction() {
		return commandAction;
	}
	
	public abstract void execute(BookViewService bookViewService);

	
}
