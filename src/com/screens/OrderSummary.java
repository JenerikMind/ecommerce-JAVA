package com.screens;

import java.util.Scanner;

import com.ecommerce.Customer;
import com.ecommerce.orders.Order;

/**
 * The screen that displays the order summary.
 */
public class OrderSummary extends Screen {
	Customer customer;

    public ScreenType display() {
        Order order = customer.PlaceOrder();
        System.out.println(order.OrderSummary());

        System.out.println("Would you like to finish checking out? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();

        if (response.equals("y")) {
            System.out.println("Your order has been placed.");
            return ScreenType.GOODBYE;
        }
        return ScreenType.MAIN_MENU;
    }

    public OrderSummary(Customer customer) {
        this.customer = customer;
    }
}
