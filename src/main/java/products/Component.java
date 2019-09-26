package products;

import product_operations.receipts.ReceiptVisitor;
import product_operations.taxes.TaxVisitor;

public interface Component {
    double getTaxes(TaxVisitor visitor);
    String getReceipt(ReceiptVisitor visitor);
}
