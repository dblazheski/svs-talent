package presistence.actions;

import core.application.RecordNotFoundException;
import core.entities.Book;
import presistence.services.BookViewService;

public class UpdateBookAction extends Action{
	private Long option;
	private String title;
	
	public UpdateBookAction(String nameOfAction) {
		super(nameOfAction);
		setCommandAction("Enter Book id and Corrected Title: ");
	}

	@Override
	public void execute(BookViewService bookViewService) {
		screen.print(getCommandAction());
		option = getInput().readLong();
		title = getInput().readString();
		Book book = null;
		try {
		book = bookViewService.getBookById(option);
		book.setTitle(title);
		bookViewService.updateBook(book);
		} catch(RecordNotFoundException | NullPointerException e){
			screen.print("Book not found !");
		}
	}

}
