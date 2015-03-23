package aliexpress;

import java.util.ArrayList;

public class Basket {
	ArrayList<BasketProduct> products;
	int total;
	
	public Basket() {
		this.products = new ArrayList<BasketProduct>();
	}
	
	public void addProductToBasket(Product product, int qty) throws ProductExsistException, InvalidQuantityException{
			if(productExsistToBasket(product))
				throw new ProductExsistException();
			BasketProduct BasketProduct = new BasketProduct(product, qty);
			products.add(BasketProduct);
	}
	
	public boolean productExsistToBasket(Product product){
		boolean exsist=false;
		String basketProductKey;
		String productKey;
		for(BasketProduct basketProduct : products){
		basketProductKey=basketProduct.product.key;
		productKey=product.key;
		if(basketProductKey.equals(productKey))
			exsist=true;
		}
		return exsist;
	}
	
	public void removeProductFromBasket(int number) throws ArrayIndexOutOfBoundsException{
		int numberOfBasketProducts = products.size();
		if(number>numberOfBasketProducts||number<0)
			throw new ArrayIndexOutOfBoundsException();
		products.remove(number);
	}
	
	public void changeQuantity(int number, int qty) throws InvalidQuantityException{
		BasketProduct basketproduct = products.get(number);
			basketproduct.setbasketQuantity(qty);
	}
	
	public int total(){
		int total=0;
		for(BasketProduct basketProduct : products){
			total+=basketProduct.total;
		}
		return total;
	}
	
	public void listBasket(){
		for(BasketProduct product: products){
			product.print();
		}
	}

}
