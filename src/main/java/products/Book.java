package products;

import special_product_traits.NoBasicSalesTax;

public class Book extends Product implements NoBasicSalesTax {
    public Book(String name, double price) {
        super(name, price);
    }

    public Book(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}
