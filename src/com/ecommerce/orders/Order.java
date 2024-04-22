package com.ecommerce.orders;

import java.text.MessageFormat;
import java.util.ArrayList;
import com.ecommerce.Customer;
import com.ecommerce.Product;

public class Order {
	int orderId;
	Customer customer;
	ArrayList<Product> products;

	public Order(int orderId, Customer customer) {
		this.orderId = orderId;
		this.customer = customer;
		this.products = this.customer.GetShoppingCartItems();
	}

	public double OrderTotal() {
		double total = 0;
		for (Product p : products) {
			total += p.GetPrice();
		}

		return total;
	}

	public void UpdateOrder(Customer customer) {
		this.customer = customer;
		this.products = this.customer.GetShoppingCartItems();
	}

	public String OrderSummary() {
		return this.formatOrderSummary();
	}

	private String formatOrderSummary() {	
		StringBuilder builder = new StringBuilder("Your Order Summary:\n");
		builder.append(String.format("ID: %d\n", this.customer.GetId()));
		builder.append(this.formatProductsSummary());
		builder.append(String.format("\nTotal: %s", this.OrderTotal()));

		return builder.toString();
	}

	private String formatProductsSummary() {
		StringBuilder builder = new StringBuilder("Items: \n");
		for (Product p : products) {
			String summaryBase = "\s\s\s\s{0} - {1} \n";
			String productSummary = MessageFormat.format(
					summaryBase, 
					p.GetName(), 
					p.GetPrice());
			builder.append(productSummary);
		}

		return builder.toString();
	}
}
