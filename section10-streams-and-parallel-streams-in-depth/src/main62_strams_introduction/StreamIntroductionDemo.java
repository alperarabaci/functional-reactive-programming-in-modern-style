package main62_strams_introduction;

import java.util.ArrayList;
import java.util.List;

public class StreamIntroductionDemo {
	
	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		books.add(new Book("book1", "author1", "History", 5));
		books.add(new Book("book2", "author1", "Horror", 4.5));
		books.add(new Book("book3", "author1", "Horror", 2.5));
		books.add(new Book("book3", "author1", "Dystopian", 2.5));
		
		List<Book> horrorBooks = new ArrayList<>();
		
		for (Book book : books) {
			if(book.getGenre().equalsIgnoreCase("Horror")
					&& book.getRating()>3.5){
				horrorBooks.add(book);
			}
		}
		
		System.out.println(horrorBooks);
	}

}
