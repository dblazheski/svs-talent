package aliexpress;

public class ProductExsistException extends Exception {
	public ProductExsistException() {}

	public ProductExsistException(String string) {
		System.out.println(string);
	}

}
