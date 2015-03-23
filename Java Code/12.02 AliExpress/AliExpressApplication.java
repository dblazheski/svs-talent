package aliexpress;

import java.io.IOException;
import java.util.Scanner;

public class AliExpressApplication {
	
	public static void listOptions(){
        System.out.println("1. List All Products");
        System.out.println("2. List All Products from Basket");
        System.out.println("3. Add Product to Basket");
        System.out.println("4. Modify Quantity Product from Basket");
        System.out.println("5. Remove Product from Basket");
        System.out.println("6. Checkout\n");
    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice,product,quantity;
		try {
			Warehouse wh = new Warehouse("C:\\products.txt");
			Basket basket = new Basket();
			wh.loadProducts();
			listOptions();
			while((choice=scanner.nextInt())!=-1){
				switch(choice){
				case 1 : wh.listProducts();break;
				case 2 : basket.listBasket();break;
				case 3 : 
					product=scanner.nextInt();
					quantity=scanner.nextInt();
					if(!wh.isProductExsist(product)){
						Product p=wh.getProduct(product);
						if(!basket.productExsistToBasket(p))
						basket.addProductToBasket(wh.getProduct(product), quantity);
					}
						break;
				case 4 : 
					product=scanner.nextInt();
					quantity=scanner.nextInt();
					basket.changeQuantity(product, quantity);
					break;
				case 5 : 
					product = scanner.nextInt();
					basket.removeProductFromBasket(product);
					break;
				case 6 :
					basket.listBasket();System.out.println("Total : "+basket.total());break;
				default : listOptions();break;
				}
				
			}
			
		} catch (IOException | ProductExsistException | InvalidQuantityException  e) {
			System.out.println(e.getMessage());
			}
		scanner.close();
		
	}

}
