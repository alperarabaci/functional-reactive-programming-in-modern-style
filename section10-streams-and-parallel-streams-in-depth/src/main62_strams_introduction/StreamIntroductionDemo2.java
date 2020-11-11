package main62_strams_introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Try using stream multiple times, console log:
 * Book [name=book5, Author=author2, genre=Horror, rating=4.5]
 * Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
 * ...
 * at s10/main62_strams_introduction.StreamIntroductionDemo2.main(StreamIntroductionDemo2.java:38)
 * 
 * @author alper
 *
 */
public class StreamIntroductionDemo2 {
	
	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		books.add(new Book("book1", "author1", "History", 5));
		books.add(new Book("book2", "author1", "Romance", 4.5));
		books.add(new Book("book3", "author1", "Horror", 2.5));
		books.add(new Book("book4", "author1", "Dystopian", 2.5));
		books.add(new Book("book5", "author2", "Horror", 4.5));
		
		Stream<Book> streams = books.stream();
		
		List<Book> horrorBooks3 = streams
				.filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
				.filter(book -> book.getRating()>3.5)
				.collect(Collectors.toList());
		
		horrorBooks3.forEach(System.out::println);

		List<Book> romanticBooks3 = streams
				.filter(book -> book.getGenre().equalsIgnoreCase("Romance"))
				.filter(book -> book.getRating()>3.5)
				.collect(Collectors.toList());
		
		romanticBooks3.forEach(System.out::println);
	}

}
