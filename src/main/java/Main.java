import application.Application;
import basket.ShoppingBasket;
import product_operations.receipts.InputReceiptVisitor;
import product_operations.receipts.OutputReceiptVisitor;
import product_operations.taxes.BasicSalesTaxVisitor;
import product_operations.taxes.ImportDutyVisitor;
import product_operations.taxes.TaxVisitor;
import utility.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Application application = Utility.getApplication();
        BasicSalesTaxVisitor basicSalesTaxes = new BasicSalesTaxVisitor();
        ImportDutyVisitor importDuties = new ImportDutyVisitor();
        List<TaxVisitor> taxes = new ArrayList<>(Arrays.asList(basicSalesTaxes, importDuties));
        InputReceiptVisitor inputReceipt = new InputReceiptVisitor();
        OutputReceiptVisitor outputReceipt = new OutputReceiptVisitor(taxes);
        System.out.println(inputReceipt.getReceipt(application) + outputReceipt.getReceipt(application));
    }
}
