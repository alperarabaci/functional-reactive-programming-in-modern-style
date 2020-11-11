package main68_map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import main62_strams_introduction.Book;

public class MapDemo {

	public static void main(String[] args) {
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
			.map(e -> e * 2)
			.forEach(System.out::println);

		List<Book> books = new ArrayList<>();
		books.add(new Book("book1", "author1", "History", 5));
		books.add(new Book("book2", "author1", "Horror", 4.5));
		books.add(new Book("book3", "author1", "Horror", 2.5));
		books.add(new Book("book4", "author1", "Dystopian", 2.5));
		books.add(new Book("book5", "author2", "Horror", 4.5));

		System.out.println("Filter & Map using books:");

		/**
		 * Important thing is we should not try to change the state of an object using
		 * map because in that case we might get concurrent modification exception at
		 * runtime and moreover we should try to avoid changing the state of an object
		 * when using functional programming.
		 * 
		 */
		books.stream()
			.filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
			.filter(book -> book.getRating() > 3.5)
			.map(book -> book.getName())
			.forEach(System.out::println);

	}

}
