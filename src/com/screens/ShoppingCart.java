package com.screens;

import java.util.ArrayList;
import java.util.Scanner;
import com.ecommerce.Customer;
import com.ecommerce.Product;

public class ShoppingCart extends Screen {
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

        if (response.equals("y")) {
            return ScreenType.ORDER_SUMMARY;
        } else {
            return ScreenType.SHOPPING_CART;
        }
    }

    // display items in the shopping cart via index + 1
    private void displayItemsInCart(Customer customer) {
        System.out.println("Items in your shopping cart: ");
        ArrayList<Product> products = customer.GetShoppingCartItems();
        for (Product p : products) {
            System.out.println(products.indexOf(p) + 1 + " - " + p.GetName() + " - " + p.GetPrice());
        }
    }

    // remove an item from the shopping cart
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
    }
}
