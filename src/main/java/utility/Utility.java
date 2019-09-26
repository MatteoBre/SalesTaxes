package utility;

import application.Application;
import basket.ShoppingBasket;
import products.Book;
import products.Food;
import products.MedicalProduct;
import products.Product;

public class Utility {
    // Here I will implement the application used in testing and in the Main file
    public static Application getApplication(){
        ShoppingBasket basket1 = new ShoppingBasket();
        basket1.add(new Book("book", 12.49,2));
        basket1.add(new Product("music CD", 14.99));
        basket1.add(new Food("chocolate bar", 0.85));

        ShoppingBasket basket2 = new ShoppingBasket();
        basket2.add(new Food("imported box of chocolates", 10));
        basket2.add(new Product("imported bottle of perfume", 47.50));

        ShoppingBasket basket3 = new ShoppingBasket();
        basket3.add(new Product("imported bottle of perfume", 27.99));
        basket3.add(new Product("bottle of perfume", 18.99));
        basket3.add(new MedicalProduct("packet of headache pills", 9.75));
        basket3.add(new Food("box of imported chocolates", 11.25, 3));

        Application application = new Application();
        application.add(basket1);
        application.add(basket2);
        application.add(basket3);

        return application;
    }
}
