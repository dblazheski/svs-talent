package aliexpress;

import java.io.IOException;
import java.util.ArrayList;

public class Warehouse {
	Database date;
	ArrayList<Product> products;
	
	public Warehouse(String file) {
		this.products=new ArrayList<Product>();
		try {
			this.date=new Database(file);
		} catch (IOException e) {}
	}

	public void loadProducts() throws IOException, NullPointerException{
		String[] attributes;
		String delimiter="\\|";
		while(date.readLine()){
			date.createWords(delimiter);
			attributes=date.getWords();
			addProduct(attributes);
		}
		date.closeTxt();
	}
	
	public void addProduct(String[] attributes){
		String key=attributes[0];
		String name=attributes[1];
		int quantity=Integer.parseInt(attributes[2]);
		int price=Integer.parseInt(attributes[3]);
		Product temp= new Product(key, name, quantity, price);
		products.add(temp);
	}
	
	public boolean isProductExsist(int number){
		return (number>products.size()||number<0);
	}
	
	public Product getProduct(int number){
		return products.get(number);
	}
	
	public void listProducts(){
		for(Product product : products){
			product.print();
		}
	}
}
