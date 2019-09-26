package products;

import product_operations.receipts.ReceiptVisitor;
import product_operations.taxes.TaxVisitor;

public class Product implements Component{
    private final double price;
    private final ProductType productType;
    private final String name;
    private final int quantity;

    public Product(String name, ProductType productType, double price){
        this(name, productType, price, 1);
    }

    public Product(String name, ProductType productType, double price, int quantity){
        this.name = name;
        this.productType = productType;
        this.price = approximatePrice(price);
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public int getQuantity() {
        return quantity;
    }

    // if the name of the product contains the word "imported", then I consider it an imported product
    public boolean isImported() {
        return name.toLowerCase().indexOf("imported") != -1;
    }

    @Override
    public double getTaxes(TaxVisitor visitor) {
        return visitor.getTaxes(this);
    }

    @Override
    public String getReceipt(ReceiptVisitor visitor) {
        return visitor.getReceipt(this);
    }

    // this is used in order to have a price rounded to the second decimal
    public static double approximatePrice(double price){
        return (int)((price + 0.005) * 100) / 100.0;
    }
}
