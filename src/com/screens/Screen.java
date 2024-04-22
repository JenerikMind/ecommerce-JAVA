package com.screens;

public abstract class Screen {
	public enum ScreenType {
        MAIN_MENU, SHOPPING_CART, ORDER_SUMMARY, PRODUCTS, GOODBYE
    }

    public ScreenType display() {
        return ScreenType.MAIN_MENU;
    };
}
