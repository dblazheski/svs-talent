package aliexpress;

public class Product {
	String key;
	String name;
	int quantity;
	int price;
	
	public Product(String key, String name, int quantity, int price) {
		this.key = key;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void print(){
		System.out.println(key+"\t"+name+"\t"+quantity+"\t"+price);
	}

}
