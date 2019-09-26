package product_operations.taxes;

import application.Application;
import basket.ShoppingBasket;
import products.Product;
import products.ProductType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicSalesTaxVisitor implements TaxVisitor {
    private final double basicSalesTax;
    private final List<ProductType> noBasicSalesTaxEnums;

    public BasicSalesTaxVisitor(){
        this(0.1);
    }

    public BasicSalesTaxVisitor(double basicSalesTax) {
        this.basicSalesTax = basicSalesTax;
        noBasicSalesTaxEnums = new ArrayList<>(Arrays.asList(ProductType.BOOK, ProductType.FOOD, ProductType.MEDICAL));
    }

    @Override
    public double getTaxes(Product product) {
        return !(noBasicSalesTaxEnums.contains(product.getProductType())) ? TaxVisitor.roundTax(
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
