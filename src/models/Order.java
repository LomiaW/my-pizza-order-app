package models;

public class Order {

	private Customer customer;
	private OrderDetail orderDetail;

	public Order() {}
	
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String name, String phone) {
		this.customer = new Customer(name, phone);
	}

	/**
	 * @param orderDetail the orderDetail to set
	 */
	public void setOrderDetail(int quantity, 
			 String size, String type, String[] toppings) {
		this.orderDetail = new OrderDetail(quantity, size, type, toppings);
	}

	public Customer getCustomer() {
		return customer;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	
	/**
	 * A method that returns the order summary to be displayed
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		String orderSummary = "";
		
		// check if customer and order detailed is valid
		if (!customer.isEmpty() && !orderDetail.isEmpty()) {
			
			// print the order summary's header
			orderSummary += String.format("\n\t\t\tOrder Summary\n\n");
			
			// print the customer info
			orderSummary += customer.toString();
			
			// print the order details
			orderSummary += orderDetail.toString();
			
		} else {
			orderSummary += "Order information is invalid.\n Please enter again.";
		}
		
		return orderSummary;
	}
}
