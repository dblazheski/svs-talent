package presistence;

import presistence.actions.Action;
import presistence.actions.AddNewBookAction;
import presistence.actions.ExitAction;
import presistence.actions.ListBookAction;
import presistence.actions.RemoveBookAction;
import presistence.actions.UpdateBookAction;
import presistence.services.BookViewService;

public class Ui {

	private Screen screen;
	private Input input;
	private Action actions[];
	private Integer option;
	private BookViewService bookViewService;
	
	public Ui() {
		this.screen = new Screen();
		this.input = new Input();
		this.actions = initActions();
	}
	
	public void setBookViewService(BookViewService bookViewService) {
		this.bookViewService = bookViewService;
	}
	
	public void run(){
		screen.startUpScreen();
		while(true){
			screen.printAllActions(actions);
			option = input.readInteger();
			if(option>actions.length||option<1){
				screen.print("Invalid command!");
				continue;
			}
			actions[option-1].execute(bookViewService);
		}
	}

	private Action[] initActions() {
		 Action actions[] = {
			new AddNewBookAction("Insert New Book"),
			new ListBookAction("List All Books"),
			new UpdateBookAction("Update Existing Book"),
			new RemoveBookAction("Remove Book"),
			new ExitAction("Exit")
		};
		return actions;
	}
}
