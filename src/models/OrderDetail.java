package models;

public class OrderDetail {
	
	private final double HST = 0.13;
	
	private int quantity;
	private Pizza pizza;
	private double subtotal;	

	public OrderDetail(int _quantity, String _size, String _type, String[] _toppings) {
		this.quantity = _quantity;
		this.pizza = new Pizza(_size, _type, _toppings);
		this.subtotal = pizza.getPrice() * quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}
	
	public boolean isEmpty() {
		return quantity <= 0 || pizza.getType().isBlank() || pizza.getSize().isBlank();
	}
	
	@Override
	public String toString() {
		String orderDetails = "";
		
		orderDetails += String.format("\tPizza Type:\t\t%s\n\tPizza Size:\t\t%s\n"
				+ "\tQuantities:\t\t%d\n\n", pizza.getType(), pizza.getSize(), quantity);
		
		orderDetails += String.format("\t======================\n\n");
		orderDetails += String.format("\tTotal before tax:\t$ %.2f\n", 
														subtotal);
		orderDetails += String.format("\tTotal to be paid:\t$ %.2f\n", 
											subtotal * (1 + HST));
		
		return orderDetails;
	}

}
