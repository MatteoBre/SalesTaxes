package application;

import basket.ShoppingBasket;
import products.Component;
import product_operations.receipts.ReceiptVisitor;
import product_operations.taxes.TaxVisitor;

import java.util.ArrayList;

public class Application extends ArrayList<ShoppingBasket> implements Component {
    @Override
    public double getTaxes(TaxVisitor visitor) {
        return visitor.getTaxes(this);
    }

    @Override
    public String getReceipt(ReceiptVisitor visitor) {
        return visitor.getReceipt(this);
    }
}
