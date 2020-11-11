package main62_strams_introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntroductionDemo {
	
	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		books.add(new Book("book1", "author1", "History", 5));
		books.add(new Book("book2", "author1", "Horror", 4.5));
		books.add(new Book("book3", "author1", "Horror", 2.5));
		books.add(new Book("book4", "author1", "Dystopian", 2.5));
		
		List<Book> horrorBooks = new ArrayList<>();
		
		for (Book book : books) {
			if(book.getGenre().equalsIgnoreCase("Horror")
					&& book.getRating()>3.5){
				horrorBooks.add(book);
			}
		}
		
		System.out.println("Classic:");
		System.out.println(horrorBooks);
		
		/**
		 * https://stackoverflow.com/questions/24054773/java-8-streams-multiple-filters-vs-complex-condition
		 */
		List<Book> horrorBooks2 = books.stream()
				.filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
				.filter(book -> book.getRating()>3.5)
				.collect(Collectors.toList());
		
		System.out.println("Streams:");
		System.out.println(horrorBooks2);
	}

}
