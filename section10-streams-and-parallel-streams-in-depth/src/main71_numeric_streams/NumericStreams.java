package main71_numeric_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import main62_strams_introduction.Book;

public class NumericStreams {

	public static void main(String[] args) {
		
		List<Book> list = new ArrayList<>();

		list.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
		list.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
		list.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
		list.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));
		
		OptionalDouble average = list.stream()
		.map(book -> book.getRating())
		.mapToDouble(rating -> rating)
		.average();
		
		System.out.println(average.orElse(0));
		
		//map: Object
		//mapToDouble: primitive Double
	}
}
