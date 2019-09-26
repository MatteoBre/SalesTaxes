package utility;

import application.Application;
import basket.ShoppingBasket;
import products.Product;
import products.ProductType;

public class Utility {
    // Here I will implement the application used in testing and in the Main file
    public static Application getApplication(){
        ShoppingBasket basket1 = new ShoppingBasket();
        basket1.add(new Product("book", ProductType.BOOK, 12.49,2));
        basket1.add(new Product("music CD", ProductType.STANDARD, 14.99));
        basket1.add(new Product("chocolate bar", ProductType.FOOD, 0.85));

        ShoppingBasket basket2 = new ShoppingBasket();
        basket2.add(new Product("imported box of chocolates",ProductType.FOOD, 10));
        basket2.add(new Product("imported bottle of perfume", ProductType.STANDARD, 47.50));

        ShoppingBasket basket3 = new ShoppingBasket();
        basket3.add(new Product("imported bottle of perfume", ProductType.STANDARD, 27.99));
        basket3.add(new Product("bottle of perfume", ProductType.STANDARD,18.99));
        basket3.add(new Product("packet of headache pills", ProductType.MEDICAL, 9.75));
        basket3.add(new Product("box of imported chocolates", ProductType.FOOD, 11.25, 3));

        Application application = new Application();
        application.add(basket1);
        application.add(basket2);
        application.add(basket3);

        return application;
    }
}
