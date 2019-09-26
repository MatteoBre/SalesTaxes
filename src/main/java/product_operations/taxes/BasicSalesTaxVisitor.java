package product_operations.taxes;

import application.Application;
import basket.ShoppingBasket;
import products.Product;
import special_product_traits.NoBasicSalesTax;

public class BasicSalesTaxVisitor implements TaxVisitor {
    private final double basicSalesTax;

    public BasicSalesTaxVisitor(){
        basicSalesTax = 0.1;
    }

    public BasicSalesTaxVisitor(double basicSalesTax) {
        this.basicSalesTax = basicSalesTax;
    }

    @Override
    public double getTaxes(Product product) {
        return !(product instanceof NoBasicSalesTax) ? TaxVisitor.roundTax(
                product.getPrice() * basicSalesTax) * product.getQuantity() : 0;
    }

    @Override
    public double getTaxes(ShoppingBasket shoppingBasket) {
        return shoppingBasket.stream().mapToDouble(p -> p.getTaxes(this)).sum();
    }

    @Override
    public double getTaxes(Application application) {
        return application.stream().mapToDouble(s -> s.getTaxes(this)).sum();
    }
}
