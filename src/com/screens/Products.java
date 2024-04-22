package com.screens;

import java.util.ArrayList;
import java.util.Scanner;

import com.ecommerce.Customer;
import com.ecommerce.Product;

/**
 * The screen that displays the products available for purchase.
 */
public class Products extends Screen {
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
        customer.AddToShoppingCart(products.get(productId - 1)); // add the product to the customer's shopping cart
        
        System.out.println("Would you like to purchase another item? (y/n)");
        String response = scanner.next();
        if (response.equals("y")) {
            return ScreenType.PRODUCTS;
        }
        return ScreenType.MAIN_MENU;
    }

    // create the items to display
    private void createItems() {
        products.add(new Product(1, 999.99, "Luis Vuitton Dish Cloth"));
        products.add(new Product(2, 49.99, "Saffron"));
        products.add(new Product(3, 99.99, "Gold Leaf Instant Coffee"));
    }

    // small helper method to display the products
    private void displayProducts(ArrayList<Product> products) {
        for (Product p : products) {
            System.out.println(
                   p.GetProductId() + " - " + p.GetName() + " - " + p.GetPrice());
        }
    }
}
