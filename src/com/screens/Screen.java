package com.screens;

public abstract class Screen {
	public enum ScreenType {
        MAIN_MENU, SHOPPING_CART, ORDER_SUMMARY, PRODUCTS, GOODBYE
    }

    /**
     * Display the screen
     * @return ScreenType the next screen to display
     */
    public ScreenType display() {
        return ScreenType.MAIN_MENU;
    };
}
