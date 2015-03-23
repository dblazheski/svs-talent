package aliexpress;

public class BasketProduct {
	Product product;
	int basketQuantity;
	int total;
	
	public BasketProduct(Product product, int basketQuantity) throws InvalidQuantityException {
		this.product = product;
		setbasketQuantity(basketQuantity);
		this.total=calculateTotal();
	}
	
	public int calculateTotal(){
		return basketQuantity*product.price;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public void setbasketQuantity(int qty) throws InvalidQuantityException{
		int productQuantity=product.getQuantity();
		int total;
		if(qty>productQuantity||qty<0)
			throw new InvalidQuantityException();
		this.basketQuantity=qty;
		total=calculateTotal();
		setTotal(total);
		
	}
	
	public void print(){
		System.out.println(product.name+"\t"+product.price+"\t"+basketQuantity+"\t"+total);
	}

}
