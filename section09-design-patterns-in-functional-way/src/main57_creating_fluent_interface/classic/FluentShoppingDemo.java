package main57_creating_fluent_interface.classic;

public class FluentShoppingDemo {

	public static void main(String[] args) {
		Order myOrder = new Order();
		myOrder.add("Shoes");
		myOrder.add("Headphones");
		myOrder.deliverAt("Street no 45, Jodhpur");
		myOrder.place();
	}

}
