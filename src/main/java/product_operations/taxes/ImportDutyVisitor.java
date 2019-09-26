package product_operations.taxes;

import application.Application;
import basket.ShoppingBasket;
import products.Product;

public class ImportDutyVisitor implements TaxVisitor {
    private final double importDuty;

    public ImportDutyVisitor(){
        importDuty = 0.05;
    }

    public ImportDutyVisitor(double importDuty) {
        this.importDuty = importDuty;
    }

    @Override
    public double getTaxes(Product product) {
        return (product.isImported()) ? TaxVisitor.roundTax(
                product.getPrice() * importDuty) * product.getQuantity() : 0;
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
