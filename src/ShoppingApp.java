import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import com.ecommerce.Customer;
import com.ecommerce.Product;

public class ShoppingApp {
    ArrayList<Product> products = new ArrayList<Product>();
    boolean isShopping = true;

    public void UI() {
        Customer customer = new Customer(1, "John");
        createItems();

        introduction();
        displayProducts(products);

        while (isShopping) {
            purchaseProduct(customer);
        }

        goodbye();
    }

    private void introduction() {
        System.out.println("Welcome to the E-Commerce App!");
        System.out.println("Items for sale: ");
    }

    private void goodbye() {
        System.out.println("Thank you for shopping with us!");
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

    private void purchaseProduct(Customer customer) {
        System.out.println("Please enter the product ID you would like to purchase: ");
        Scanner scanner = new Scanner(System.in);
        int productId = scanner.nextInt();
        customer.AddToShoppingCart(products.get(productId - 1));
        System.out.println("Would you like to purchase another item? (y/n)");
        String response = scanner.next();

        if (response.equals("n")) {
            changeOrder(customer);
        }
    }

    private void createOrder(Customer customer) {
        System.out.println("Your order summary: ");
        System.out.println("Customer ID: " + customer.GetId());
        System.out.println("Items: ");
        for (Product p : customer.GetShoppingCartItems()) {
            System.out.println(p.GetName() + " - " + p.GetPrice());
        }
        System.out.println("Total: " + customer.CalculateShoppingCartTotal());
    }

    private void changeOrder(Customer customer) {
        displayProducts(customer.GetShoppingCartItems());
        System.out.println("Would you like to remove an item from your order? (y/n)");
        
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();

        if (response.equals("y")) {
            System.out.println("Please enter the product ID you would like to remove: ");
            int productId = scanner.nextInt();
            customer.RemoveFromShoppingCart(products.get(productId - 1));
            System.out.println("Your updated order summary: ");
            System.out.println("Customer ID: " + customer.GetId());
            System.out.println("Items: ");

            for (Product p : customer.GetShoppingCartItems()) {
                System.out.println(p.GetName() + " - " + p.GetPrice());
            }

            System.out.println("Total: " + customer.CalculateShoppingCartTotal());
        } else {
            createOrder(customer);
        }
    }
}
