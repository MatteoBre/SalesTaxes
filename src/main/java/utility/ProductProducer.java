package utility;

import products.Product;
import products.ProductType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductProducer {
    public static Product parseString(String input){
        String[] inputParts = input.split(" ");
        List<String> foodWords = new ArrayList<>(Arrays.asList("chocolate", "chocolates"));
        List<String> medicalWords = new ArrayList<>(Arrays.asList("pills"));

        int quantity = Integer.parseInt(inputParts[0]);
        double price = Double.parseDouble(inputParts[inputParts.length - 1]);

        StringBuilder nameBuilder = new StringBuilder();
        ProductType productType = ProductType.STANDARD;
        for(int i=1; i<inputParts.length - 2; i++){
            nameBuilder.append(inputParts[i] + " ");
            if(inputParts[i].equals("book"))
                productType = ProductType.BOOK;
            if(foodWords.contains(inputParts[i]))
                productType = ProductType.FOOD;
            if(medicalWords.contains(inputParts[i]))
                productType = ProductType.MEDICAL;
        }
        String name = nameBuilder.toString().substring(0, nameBuilder.length() - 1);

        return new Product(name, productType, price, quantity);
    }
}
