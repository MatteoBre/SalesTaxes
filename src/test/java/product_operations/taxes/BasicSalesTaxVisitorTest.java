package product_operations.taxes;

import application.Application;
import basket.ShoppingBasket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import products.Product;
import products.ProductType;
import utility.Utility;

public class BasicSalesTaxVisitorTest {
    private BasicSalesTaxVisitor visitor;

    @Before
    public void initializeApplication(){
        visitor = new BasicSalesTaxVisitor(0.1);
    }

    @Test
    public void productTaxesTest(){
        Product chair = new Product("chair", ProductType.STANDARD, 24.99, 25);
        double actualTaxes = visitor.getTaxes(chair);
        double expectedTaxes = TaxVisitor.roundTax(24.99 * 0.1) * 25;
        Assert.assertEquals(actualTaxes, expectedTaxes, 0);
    }

    @Test
    public void basketTaxesTest(){
        ShoppingBasket basket = Utility.getApplication().get(2);
        double actualTaxes = visitor.getTaxes(basket);
        double expectedTaxes = basket.stream().mapToDouble(p -> visitor.getTaxes(p)).sum();
        Assert.assertEquals(actualTaxes, expectedTaxes, 0);
    }

    @Test
    public void applicationTaxesTest(){
        Application application = Utility.getApplication();
        double actualTaxes = visitor.getTaxes(application);
        double expectedTaxes = application.stream().mapToDouble(s -> visitor.getTaxes(s)).sum();
        Assert.assertEquals(actualTaxes, expectedTaxes, 0);
    }
}
