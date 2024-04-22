import java.util.ArrayList;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.screens.*;

public class ShoppingApp {
    ArrayList<Product> products = new ArrayList<Product>();
    boolean isShopping = true;
    Screen currentScreen;

    public void UI() {
        Customer customer = new Customer(1, "John");
        currentScreen = new MainMenu();
        
        while(isShopping){
            switch(currentScreen.display()){
                case MAIN_MENU:
                    currentScreen = new MainMenu();
                    break;
                case SHOPPING_CART:
                    currentScreen = new ShoppingCart(customer);
                    break;
                case ORDER_SUMMARY:
                    currentScreen = new OrderSummary(customer);
                    break;
                case PRODUCTS:
                    currentScreen = new Products(customer);
                    break;
                case GOODBYE:
                    System.out.println("Thank you for shopping with us!");
                    isShopping = false;
                    break;
            }
        }
    }
}
