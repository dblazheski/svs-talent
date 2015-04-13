package presistence.actions;

import presistence.services.BookViewService;

public class RemoveBookAction extends Action{
	private Long option;

	public RemoveBookAction(String nameOfAction) {
		super(nameOfAction);
		setCommandAction("Enter number of Book: ");
	}

	@Override
	public void execute(BookViewService bookViewService) {
		screen.print(getCommandAction());
		option = getInput().readLong();
		bookViewService.removeBook(option);
	}

}
