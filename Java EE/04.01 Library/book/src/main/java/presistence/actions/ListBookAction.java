package presistence.actions;

import presistence.services.BookViewService;


public class ListBookAction extends Action{

	public ListBookAction(String nameOfAction) {
		super(nameOfAction);
		setCommandAction("List of Books: ");
	}

	@Override
	public void execute(BookViewService bookViewService) {
		screen.print(getCommandAction());
		bookViewService.getAllBooks();
	}

}
