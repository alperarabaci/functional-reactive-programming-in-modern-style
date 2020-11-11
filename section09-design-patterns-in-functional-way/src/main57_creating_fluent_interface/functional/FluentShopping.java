package main57_creating_fluent_interface.functional;

public class FluentShopping {

	public static void main(String[] args) {
		/**
		 * Tutor claim that which I don't agree. I prefer method_chaining :
		 * so see no difference in the result we're getting the result
		 * but the implementation is much better than the previous ones
		 * so the code seems lighter elegant concise
		 * and in a smooth flow
		 */
		// functional:
		Order.place(order -> 
			order.add("shoes")
			.add("Headphones")
			.deliverAt("Street no 45, Jodhpur")
			);
	}

}
