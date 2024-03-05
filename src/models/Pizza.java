package models;

import java.util.Arrays;
import java.util.List;


public class Pizza {
	
	private enum PizzaSize {
		SMALL(7.00),
		MEDIUM(10.00),
		LARGE(13.00),
		XLARGE(15.00);
		
		private final double price;

		PizzaSize(double _price) {
			this.price = _price;
		}
		
		public double getPrice() {
			return price;
		}
	};
	
	private final List<String> meatToppingsList = Arrays.asList(new String[] {
			"Ground Beef", "Shredded Chicken", 
			"Grilled Chicken", "Pepperoni", "Ham", "Bacon" });
	
	private final double MEAT_PRICE = 2.15;
	private final double TOPPING_PRICE = 1.10;

	private PizzaSize size;
	private String type;
	private String[] toppings;
	private double price;

	/**
	 * A constructor that instantiate a Pizza object.
	 */
	public Pizza(String _size, String _type, String[] _toppings) {

		switch(_size) {
			case "Small": 
				size = PizzaSize.SMALL;
				break;
			case "Medium":
				size = PizzaSize.MEDIUM;
				break;
			case "Large":
				size = PizzaSize.LARGE;
				break;
			case "Extra Large":
				size = PizzaSize.XLARGE;
				break;
		}
		
		type = _type;
		toppings = _toppings;
		calcPrice();
	}
	
	
	private double calcPrice() {
		double result = 0.0;
		
		for (int i=0; i < toppings.length; i++) {
			if (meatToppingsList.contains(toppings[i])) {
				result += MEAT_PRICE;
			} else {
				result += TOPPING_PRICE;
			}
		}
		
		result += size.getPrice();

		price = result;
		
		return result;
	}
	
	public String getType() {
		return type;
	}
	
	public String getSize() {
		return size.name();
	}

	/**
	 * @return the price per pizza excluding tax.
	 */
	public double getPrice() {
		return price;
	}

}
