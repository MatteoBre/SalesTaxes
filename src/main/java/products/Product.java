package products;

import product_operations.receipts.ReceiptVisitor;
import product_operations.taxes.TaxVisitor;

import java.util.Objects;

public class Product implements Component{
    private final double price;
    private final ProductType productType;
    private final String name;
    private final int quantity;
    private final boolean imported;

    public Product(String name, ProductType productType, double price){
        this(name, productType, price, 1);
    }

    public Product(String name, ProductType productType, double price, int quantity){
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.quantity = quantity;
        // if the name of the product contains the word "imported", then I consider it an imported product
        imported = name.toLowerCase().indexOf("imported") != -1;
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

    public boolean isImported() {
        return imported;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                quantity == product.quantity &&
                productType == product.productType &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, productType, name, quantity);
    }
}
