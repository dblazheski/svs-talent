package presistence.actions;

import presistence.services.BookViewService;

public class ExitAction extends Action{

	public ExitAction(String nameOfAction) {
		super(nameOfAction);
	}

	@Override
	public void execute(BookViewService bookViewService) {
		System.exit(0);
	}

}
