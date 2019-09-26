package products;

import special_product_traits.NoBasicSalesTax;

public class MedicalProduct extends Product implements NoBasicSalesTax {
    public MedicalProduct(String name, double price) {
        super(name, price);
    }

    public MedicalProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}
