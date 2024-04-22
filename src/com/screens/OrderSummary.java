package com.screens;

import java.util.Scanner;

import com.ecommerce.Customer;
import com.ecommerce.orders.Order;

public class OrderSummary extends Screen {
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
