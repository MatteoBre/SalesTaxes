package utility;

import org.junit.Assert;
import org.junit.Test;
import products.Product;
import products.ProductType;

public class ProductProducerTest {
    @Test
    public void parseStringChangedPriceTest_1(){
        Product expectedResult = new Product("book", ProductType.BOOK, 13.49, 2);
        Product actualResult = ProductProducer.parseString("2 book at 13.49");
        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertEquals(actualResult.getPrice(), 13.49, 0);
    }

    @Test
    public void parseStringChangedPriceTest_2(){
        Product expectedResult = new Product("book", ProductType.BOOK, 12.49, 2);
        Product actualResult = ProductProducer.parseString("2 book at 12.49");
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void parseStringChangedQuantityTest(){
        Product expectedResult = new Product("book", ProductType.BOOK, 13.49, 4);
        Product actualResult = ProductProducer.parseString("4 book at 13.49");
        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertEquals(actualResult.getQuantity(), 4);
    }

    @Test
    public void parseStringChangedNameTest(){
        Product expectedResult = new Product("imported box of chocolates", ProductType.FOOD, 13.49, 4);
        Product actualResult = ProductProducer.parseString("4 imported box of chocolates at 13.49");
        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertEquals(actualResult.getName(), "imported box of chocolates");
    }

    @Test
    public void parseStringIsImportedTest_1(){
        Product product = ProductProducer.parseString("4 imported box of chocolates at 13.49");
        Assert.assertEquals(product.isImported(), true);
    }

    @Test
    public void parseStringIsImportedTest_2(){
        Product product = ProductProducer.parseString("4 box of chocolates at 13.49");
        Assert.assertEquals(product.isImported(), false);
    }

    @Test
    public void parseStringChangedProductTypeTest_1(){
        Product expectedResult = new Product("book", ProductType.BOOK, 13.49, 4);
        Product actualResult = ProductProducer.parseString("4 book at 13.49");
        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertEquals(actualResult.getProductType(), ProductType.BOOK);
    }

    @Test
    public void parseStringChangedProductTypeTest_2(){
        Product expectedResult = new Product("chocolate bar", ProductType.FOOD, 13.49, 4);
        Product actualResult = ProductProducer.parseString("4 chocolate bar at 13.49");
        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertEquals(actualResult.getProductType(), ProductType.FOOD);
    }

    @Test
    public void parseStringChangedProductTypeTest_3(){
        Product expectedResult = new Product("packet of headache pills", ProductType.MEDICAL, 13.49, 4);
        Product actualResult = ProductProducer.parseString("4 packet of headache pills at 13.49");
        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertEquals(actualResult.getProductType(), ProductType.MEDICAL);
    }

    @Test
    public void parseStringChangedProductTypeTest_4(){
        Product expectedResult = new Product("music CD", ProductType.STANDARD, 13.49, 4);
        Product actualResult = ProductProducer.parseString("4 music CD at 13.49");
        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertEquals(actualResult.getProductType(), ProductType.STANDARD);
    }
}
