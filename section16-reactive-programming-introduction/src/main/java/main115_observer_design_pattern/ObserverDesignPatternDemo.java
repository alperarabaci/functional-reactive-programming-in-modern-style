package main115_observer_design_pattern;

public class ObserverDesignPatternDemo {
	
	public static void main(String[] args) {
		Book book = new Book("Goosebumps", "Horror", "Xyz", 200, "Sold Out");
		EndUser user1 = new EndUser("Bob", book);
		EndUser user2 = new EndUser("Rob", book);
		
		System.out.println(book.getInStock());
		
		book.setInStock("In Stock");
	}
	
}
