package products;

import special_product_traits.NoBasicSalesTax;

public class Food extends Product implements NoBasicSalesTax {
    public Food(String name, double price) {
        super(name, price);
    }

    public Food(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}
