package com.ecommerce;

public class Product {
	int productId;
	double price;
	String name;
	
	/**
	 * Constructor for Product
	 * @param productId
	 * @param price
	 * @param name
	 */
	public Product(int productId, double price, String name) {
		this.productId = productId;
		this.price = price;
		this.name = name;
	}
	
	// Getters
	public int GetProductId() { return productId; }
	public double GetPrice() { return price; }
	public String GetName() { return name; }
}
