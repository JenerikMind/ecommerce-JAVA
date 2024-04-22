package com.ecommerce;

import java.util.ArrayList;
import com.ecommerce.orders.*;

public class Customer {
	private int customerId;
	private String name;
	private ArrayList<Product> shoppingCart;
	
	/**
	 * Customer constructor. Creates new shopping cart
	 * when customer object is created.
	 * @param customerId
	 * @param name
	 */
	public Customer(int customerId, String name) {
		this.customerId = customerId;
		this.name = name;
		shoppingCart = new ArrayList<Product>();
	}
	
	public int GetId() { return customerId; }
	public String GetName() { return name; }
	
	public ArrayList<Product> GetShoppingCartItems() {
		return shoppingCart;
	}
	
	public void AddToShoppingCart(Product product) {
		shoppingCart.add(product);
	}

	public void RemoveFromShoppingCart(Product product) {
		shoppingCart.remove(product);
	}
	
	public double CalculateShoppingCartTotal() {
		double total = 0;
		for (Product product : shoppingCart) {
			total += product.price;
		}
		return total;
	}

	public Order PlaceOrder() {
		Order order = new Order(1, this);
		return order;
	}
}
