import presistence.Ui;
import presistence.services.BookViewService;
import infrastructure.hibernate.HBookDao;
import infrastructure.hibernate.HibernateUtil;
import core.application.BookManagment;
import core.application.services.BookService;
import core.application.services.bookDao;
import core.controller.BookManagmentController;


public class BookApplication {
	public static void main(String[] args) {
		bookDao bookDao = new HBookDao();
		BookService bookService = new BookService(bookDao);
		BookManagment bookManagment = new BookManagment(bookService);
		BookViewService bookViewService = new BookViewService();
		BookManagmentController bookManagmentController = new BookManagmentController(bookManagment, bookViewService);
		HibernateUtil.getSessionFactory();
		Ui ui = new Ui();
		ui.setBookViewService(bookViewService);
		ui.run();
		HibernateUtil.shutdown();
	}
}
