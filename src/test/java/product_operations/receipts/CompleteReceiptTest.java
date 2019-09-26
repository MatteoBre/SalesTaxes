package product_operations.receipts;

import application.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import product_operations.taxes.BasicSalesTaxVisitor;
import product_operations.taxes.ImportDutyVisitor;
import product_operations.taxes.TaxVisitor;
import utility.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompleteReceiptTest {
    private InputReceiptVisitor inputVisitor;
    private OutputReceiptVisitor outputVisitor;

    @Before
    public void initializeVisitor(){
        BasicSalesTaxVisitor basicSalesTaxes = new BasicSalesTaxVisitor(0.1);
        ImportDutyVisitor importDuties = new ImportDutyVisitor(0.05);
        List<TaxVisitor> taxes = new ArrayList<>(Arrays.asList(basicSalesTaxes, importDuties));
        inputVisitor = new InputReceiptVisitor();
        outputVisitor = new OutputReceiptVisitor(taxes);
    }

    @Test
    public void receiptTest(){
        Application application = Utility.getApplication();
        String actualReceipt = inputVisitor.getReceipt(application) + outputVisitor.getReceipt(application);
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
                "3 box of imported chocolates at 11.25\r\n" +
                "\r\n" +
                "OUTPUT:\r\n" +
                "\r\n" +
                "Output 1:\r\n" +
                "2 book: 24.98\r\n" +
                "1 music CD: 16.49\r\n" +
                "1 chocolate bar: 0.85\r\n" +
                "Sales Taxes: 1.50\r\n" +
                "Total: 42.32\r\n" +
                "\r\n" +
                "Output 2:\r\n" +
                "1 imported box of chocolates: 10.50\r\n" +
                "1 imported bottle of perfume: 54.65\r\n" +
                "Sales Taxes: 7.65\r\n" +
                "Total: 65.15\r\n" +
                "\r\n" +
                "Output 3:\r\n" +
                "1 imported bottle of perfume: 32.19\r\n" +
                "1 bottle of perfume: 20.89\r\n" +
                "1 packet of headache pills: 9.75\r\n" +
                "3 imported box of chocolates: 35.55\r\n" +
                "Sales Taxes: 7.90\r\n" +
                "Total: 98.38\r\n\r\n";
        Assert.assertEquals(actualReceipt, expectedReceipt);
    }
}
