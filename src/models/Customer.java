package models;

public class Customer {
	
	private String name;
	private String phoneNo;

	
	public Customer(String _name, String _phoneNo) {
		this.name = _name;
		this.phoneNo = _phoneNo;
	}
	
	public boolean isEmpty() {
		return name.isBlank() || phoneNo.isBlank();
	}
	
	@Override
	public String toString() {
		String customerInfo = "";
		
		customerInfo += String.format("\tCustomer Name:\t%s\n", name);
		customerInfo += String.format("\tCustomer Phone:\t%s\n\n", phoneNo);
		
		return customerInfo;
	}

}
