package view;

public class LibraryUi {
	
	public static void main(String[] args) {
		LibraryMenu menu = new LibraryMenu();
		boolean run=true;
		menu.printOptions();
		while(run){
			menu.readOption();
			switch(menu.option){
			case 0:menu.quitMenu();run=false;break;
			case 1:menu.registerBook();break;
			case 2:menu.listBooks();break;
			case 3:menu.updateBook();break;
			default :menu.printOptions();break;
			}
		}
	}

}