package product_operations.receipts;

import application.Application;
import basket.ShoppingBasket;
import products.Product;

import java.util.stream.IntStream;

public class InputReceiptVisitor implements ReceiptVisitor{

    @Override
    public String getReceipt(Product product) {
        return product.getQuantity() + " " + product.getName() + " at " +
                ReceiptVisitor.stringPrice(product.getPrice()) + "\r\n";
    }

    @Override
    public String getReceipt(ShoppingBasket shoppingBasket) {
        StringBuilder basketReceiptInput = new StringBuilder();
        shoppingBasket.stream().forEach(p -> basketReceiptInput.append(getReceipt(p)));
        return basketReceiptInput.toString();
    }

    @Override
    public String getReceipt(Application application) {
        StringBuilder inputReceipt = new StringBuilder();
        inputReceipt.append("INPUT:\r\n\r\n");
        IntStream.range(0, application.size()).forEach(i -> inputReceipt.append(
                "Input " + (i+1) + ":\r\n" + getReceipt(application.get(i)) + "\r\n"));
        return inputReceipt.toString();
    }
}
