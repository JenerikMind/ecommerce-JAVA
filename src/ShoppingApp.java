import java.util.ArrayList;
import java.util.Scanner;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Order;

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

    abstract class Screen {
        enum ScreenType {
            MAIN_MENU, SHOPPING_CART, ORDER_SUMMARY, PRODUCTS, GOODBYE
        }

        public ScreenType display() {
            return ScreenType.MAIN_MENU;
        };
    }

    class MainMenu extends Screen {
        Scanner scanner = new Scanner(System.in);

        public ScreenType display() {
            System.out.println("Welcome to the E-Commerce App!");
            System.out.println("Please select the option you would like to proceed with: ");
            System.out.println("1. Shop Products");
            System.out.println("2. Shopping Cart");
            System.out.println("3. Order Summary");

            int option = scanner.nextInt();
            System.out.println("You selected option: " + option);
            switch (option) {
                case 1:
                    return ScreenType.PRODUCTS;
                case 2:
                    return ScreenType.SHOPPING_CART;
                case 3:
                    return ScreenType.ORDER_SUMMARY;
                default:
                    return ScreenType.GOODBYE;
            }
        }
    }

    class ShoppingCart extends Screen {
        Customer customer;
        ArrayList<Product> products;

        public ShoppingCart(Customer customer) {
            this.customer = customer;
            products = customer.GetShoppingCartItems();
        }

        public ScreenType display() {

            // display items in the shopping cart
            // ask user if they want to remove an item
            // ask user if they want to checkout
            System.out.println("Shopping Cart");
            displayItemsInCart(customer);
            System.out.println("Would you like to remove an item from your shopping cart? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();

            // if user wants to remove an item, remove it and
            // display the updated shopping cart
            if (response.equals("y")) {
                removeItemFromCart();
            }

            // if ready to checkout, move to order summary
            System.out.println("Would you like to checkout? (y/n)");
            response = scanner.next();
            scanner.close();
            if (response.equals("y")) {
                return ScreenType.ORDER_SUMMARY;
            }else{
                return ScreenType.SHOPPING_CART;
            }
        }

        private void displayItemsInCart(Customer customer) {
            System.out.println("Items in your shopping cart: ");
            for (Product p : customer.GetShoppingCartItems()) {
                System.out.println(p.GetProductId() + " - " + p.GetName() + " - " + p.GetPrice());
            }
        }

        private void removeItemFromCart() {

            System.out.println("Please enter the product ID you would like to remove: ");
            Scanner scanner = new Scanner(System.in);
            int productId = scanner.nextInt();
            customer.RemoveFromShoppingCart(products.get(productId - 1));
            displayItemsInCart(customer);

            System.out.println("Remove another?");
            String response = scanner.next();
            if (response.equals("y")) {
                removeItemFromCart();
            }

            scanner.close();
        }
    }

    class OrderSummary extends Screen {
        Customer customer;

        public ScreenType display() {
            Order order = customer.PlaceOrder();
            System.out.println(order.OrderSummary());

            System.out.println("Would you like to checkout? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            if (response.equals("y")) {
                return ScreenType.GOODBYE;
            }
            return ScreenType.MAIN_MENU;
        }

        public OrderSummary(Customer customer) {
            this.customer = customer;
        }

        public Customer getCustomer(){ return customer; }
    }

    class Products extends Screen {
        ArrayList<Product> products = new ArrayList<Product>();
        Customer customer;

        public Products(Customer customer) {
            this.customer = customer;
            createItems();
        }

        public ScreenType display() {
            displayProducts(products);
            System.out.println("Enter the number of the itme you want to add to your cart: ");
            Scanner scanner = new Scanner(System.in);
            int productId = scanner.nextInt();
            customer.AddToShoppingCart(products.get(productId - 1));
            
            System.out.println("Would you like to purchase another item? (y/n)");
            String response = scanner.next();
            if (response.equals("y")) {
                return ScreenType.PRODUCTS;
            }
            return ScreenType.MAIN_MENU;
        }

        private void createItems() {
            products.add(new Product(1, 999.99, "Luis Vuitton Dish Cloth"));
            products.add(new Product(2, 49.99, "Saffron"));
            products.add(new Product(3, 99.99, "Gold Leaf Instant Coffee"));
        }
    
        private void displayProducts(ArrayList<Product> products) {
            for (Product p : products) {
                System.out.println(
                        p.GetProductId() + " - " + p.GetName() + " - " + p.GetPrice());
            }
        }
    }
}
