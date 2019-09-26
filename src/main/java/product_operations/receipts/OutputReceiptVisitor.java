package product_operations.receipts;

import application.Application;
import basket.ShoppingBasket;
import product_operations.taxes.TaxVisitor;
import products.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class OutputReceiptVisitor implements ReceiptVisitor{
    private List<TaxVisitor> taxes;

    public OutputReceiptVisitor(List<TaxVisitor> taxes) {
        this.taxes = taxes;
    }
    @Override
    public String getReceipt(Product product) {
        double totalTaxes = taxes.stream().mapToDouble(tax -> tax.getTaxes(product)).sum();
        double totalCosts = totalTaxes + product.getPrice() * product.getQuantity();

        String name = fixName(product.getName());
        return product.getQuantity() + " " + name + ": " +
                ReceiptVisitor.stringPrice(totalCosts) + "\r\n";
    }

    @Override
    public String getReceipt(ShoppingBasket shoppingBasket) {
        double totalTaxes = shoppingBasket.stream().mapToDouble(
                p -> taxes.stream().mapToDouble(tax -> tax.getTaxes(p)).sum()).sum();
        double totalCosts = totalTaxes + shoppingBasket.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();

        StringBuilder basketReceiptOutput = new StringBuilder();
        shoppingBasket.stream().forEach(p -> basketReceiptOutput.append(getReceipt(p)));
        basketReceiptOutput.append("Sales Taxes: " + ReceiptVisitor.stringPrice(totalTaxes) + "\r\n");
        basketReceiptOutput.append("Total: " + ReceiptVisitor.stringPrice(totalCosts) + "\r\n");
        return basketReceiptOutput.toString();
    }

    @Override
    public String getReceipt(Application application) {
        StringBuilder outputReceipt = new StringBuilder();
        outputReceipt.append("OUTPUT:\r\n\r\n");
        IntStream.range(0, application.size()).forEach(i -> outputReceipt.append(
                "Output " + (i+1) + ":\r\n" + getReceipt(application.get(i)) + "\r\n"));
        return outputReceipt.toString();
    }

    // When I have an imported product, I want the word "imported" in the beginning of its name
    public static String fixName(String name){
        if(name.toLowerCase().indexOf("imported") == -1)
            return name;
        StringBuilder stringBuilder = new StringBuilder("imported");
        Arrays.stream(name.split(" ")).filter(s -> !s.toLowerCase().equals("imported"))
                .forEach(s -> stringBuilder.append(" " + s));
        return stringBuilder.toString();
    }
}
