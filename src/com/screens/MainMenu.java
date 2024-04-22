package com.screens;

import java.util.Scanner;

public class MainMenu extends Screen {
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
