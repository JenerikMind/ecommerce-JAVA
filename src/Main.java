import java.util.ArrayList;

import com.ecommerce.*;
import com.ecommerce.orders.*;

public class Main {

	ArrayList<Product> products = new ArrayList<Product>();

	public static void main(String[] args) {
		// // Create some products
		// Product product = new Product(1, 999.99, "Luis Vuitton Dish Cloth");
		// Product product2 = new Product(2, 49.99, "Saffron");

		// // Create a customer
		// Customer customer = new Customer(1, "John");

		// // Add products to the shopping cart
		// customer.AddToShoppingCart(product);
		// customer.AddToShoppingCart(product2);
		// customer.AddToShoppingCart(product); // accidentally add the same product again

		// // Place the order
		// Order order = customer.PlaceOrder();
		// System.out.println(order.OrderSummary());

		// // Oh no! The customer added the same product twice. Let's remove it.
		// customer.RemoveFromShoppingCart(product);
		// order.UpdateOrder(customer); // update the order with the new shopping cart

		// System.out.println("\nAfter having removed the duplicate product...");
		// System.out.println(order.OrderSummary());

		ShoppingApp shoppingApp = new ShoppingApp();
		shoppingApp.UI();
	}
}
