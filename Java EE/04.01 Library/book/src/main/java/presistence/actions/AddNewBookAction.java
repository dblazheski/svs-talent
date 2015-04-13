package presistence.actions;


import presistence.services.BookViewService;

public class AddNewBookAction extends Action{

	private String title;
	private String isbn;
	
	public AddNewBookAction(String nameOfAction) {
		super(nameOfAction);
		setCommandAction("Enter Book title and isbn: ");
	}

	@Override
	public void execute(BookViewService bookViewService) {
		screen.print(getCommandAction());
		title = getInput().readString();
		isbn = getInput().readString();
		bookViewService.createBook(isbn, title);
	}

}
