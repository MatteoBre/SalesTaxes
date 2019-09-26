package product_operations.receipts;

import application.Application;
import basket.ShoppingBasket;
import products.Product;

import java.util.Locale;

public interface ReceiptVisitor {
    String getReceipt(Product product);
    String getReceipt(ShoppingBasket shoppingBasket);
    String getReceipt(Application application);

    // This function is used to return a price in a standard notation
    static String stringPrice(double price){
        return String.format(Locale.US,"%.2f", Product.approximatePrice(price));
    }
}
