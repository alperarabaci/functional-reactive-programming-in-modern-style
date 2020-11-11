package main57_creating_fluent_interface;

import java.util.ArrayList;
import java.util.List;

class Order{
	
	private List<String> cart = new ArrayList<>();
	private String address = "";
	
	public Order() {
		
	}
	
	public Order(List<String> cart, String address) {
		this.cart = cart;
		this.address = address;
	}

	public void add(String item) {
		cart.add(item);
		System.out.println(item + " added to the cart");
	}

	public void deliverAt(String location){
		this.address = location;
		System.out.println("The delivery address set by you is '"+location+"'");
	}
	
	public void place() {
		System.out.println("Order placed!");
		System.out.println(this.cart.size()+" items ordered by you will be delivered at "+this.address+" by tomorrow");
	}
	
}
