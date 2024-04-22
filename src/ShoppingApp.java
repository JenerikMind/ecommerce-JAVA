import java.util.ArrayList;

import com.ecommerce.*;
import com.screens.*;

/**
 * ShoppingApp class
 * handles the UI and the shopping process
 */
public class ShoppingApp {
    ArrayList<Product> products = new ArrayList<Product>();
    boolean isShopping = true;
    Screen currentScreen;

    public void UI() {
        // create a customer object
        Customer customer = new Customer(1, "John");

        // set the initial screen to the main menu
        currentScreen = new MainMenu();
        
        // while the customer is shopping
        while(isShopping){
            // display the current screen and switch to the next screen as dictated by the user
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
