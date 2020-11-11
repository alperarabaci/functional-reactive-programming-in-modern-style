package main57_creating_fluent_interface.method_chaining;

public class FluentShoppingDemo {

	public static void main(String[] args) {		
		//method chaining:
		new Order()
			.add("Shoes")
			.add("Headphones")
			.deliverAt("Street no 45, Jodhpur")
			.place();
	}

}
