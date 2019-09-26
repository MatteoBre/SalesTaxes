package product_operations.receipts;

import application.Application;
import basket.ShoppingBasket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import products.Book;
import utility.Utility;

public class InputReceiptVisitorTest {
    private InputReceiptVisitor visitor;

    @Before
    public void initializeVisitor(){
        visitor = new InputReceiptVisitor();
    }

    @Test
    public void productReceiptTest(){
        Book book = new Book("book", 10.49, 4);
        String actualReceipt = visitor.getReceipt(book);
        String expectedReceipt = "4 book at 10.49\r\n";
        Assert.assertEquals(actualReceipt, expectedReceipt);
    }

    @Test
    public void basketReceiptTest(){
        ShoppingBasket basket = Utility.getApplication().get(0);
        String actualReceipt = visitor.getReceipt(basket);
        String expectedReceipt = "2 book at 12.49\r\n" +
                "1 music CD at 14.99\r\n" +
                "1 chocolate bar at 0.85\r\n";
        Assert.assertEquals(actualReceipt, expectedReceipt);
    }

    @Test
    public void applicationReceiptTest(){
        Application application = Utility.getApplication();
        String actualReceipt = visitor.getReceipt(application);
        String expectedReceipt = "INPUT:\r\n" +
                "\r\n" +
                "Input 1:\r\n" +
                "2 book at 12.49\r\n" +
                "1 music CD at 14.99\r\n" +
                "1 chocolate bar at 0.85\r\n" +
                "\r\n" +
                "Input 2:\r\n" +
                "1 imported box of chocolates at 10.00\r\n" +
                "1 imported bottle of perfume at 47.50\r\n" +
                "\r\n" +
                "Input 3:\r\n" +
                "1 imported bottle of perfume at 27.99\r\n" +
                "1 bottle of perfume at 18.99\r\n" +
                "1 packet of headache pills at 9.75\r\n" +
                "3 box of imported chocolates at 11.25\r\n\r\n";
        Assert.assertEquals(actualReceipt, expectedReceipt);
    }
}
