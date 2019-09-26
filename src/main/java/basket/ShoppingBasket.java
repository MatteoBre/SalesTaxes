package basket;

import products.Component;
import products.Product;
import product_operations.receipts.ReceiptVisitor;
import product_operations.taxes.TaxVisitor;

public class ShoppingBasket extends java.util.ArrayList<Product> implements Component {
    @Override
    public double getTaxes(TaxVisitor visitor) {
        return visitor.getTaxes(this);
    }

    @Override
    public String getReceipt(ReceiptVisitor visitor) {
        return visitor.getReceipt(this);
    }
}
