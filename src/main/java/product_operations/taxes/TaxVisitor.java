package product_operations.taxes;

import application.Application;
import basket.ShoppingBasket;
import products.Product;

public interface TaxVisitor {
    double getTaxes(Product product);
    double getTaxes(ShoppingBasket shoppingBasket);
    double getTaxes(Application application);

    // This function is used to round the tax to the nearest 0.05
    static double roundTax(double tax){
        // Es. 1.5625 -> 15.625 - 15 = 0.625 -> 6.25 this variable represents the value of the centesimal position
        double centesimalValue = (tax * 10 - (int)(tax * 10)) * 10;
        //if the value is 0 or 5, we already have a precise amount
        if(centesimalValue == 0 || centesimalValue == 5)
            return tax;
        //this variable represents the value of the tax truncated after centesimal place (Es. 1.5625 -> 1.56)
        double centesimalTax = ((int)(tax * 100))/100.0;
        if(centesimalValue > 5)
            // Es. 1.56 + (10 - 6)/100 = 1.56 + 0.04 = 1.60
            return centesimalTax + (10 - (int)centesimalValue)/100.0;
        // Es. 1.52 + (5 - 2)/100 = 1.52 + 0.03 = 1.55
        return centesimalTax + (5 - (int)centesimalValue)/100.0;
    }
}
