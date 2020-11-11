package main70_laziness;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main62_strams_introduction.Book;

public class LazinessDemo {

	/**
	 * I increase books count in list. Streams method don't wait each other.
	 *  
	 * https://dzone.com/articles/java-8-streams-api-laziness
	 *  
	 * This is a really tricky question. If the laziness is utilized in the correct
	 * manner, the answer is 'yes.' Consider you are on an online shopping site and
	 * you searched for a particular type of a product. Usually, most of the
	 * websites will show the matching products immediately and a 'loading more'
	 * message at the bottom. Finally, all of the search results will be loaded in
	 * parts, as described. The intent behind doing this is to keep the user
	 * interested by immediately showing him some of the results. While the user is
	 * browsing through the loaded products, the rest of the products are being
	 * loaded. This is because the site is delaying the complete loading of the
	 * entire product list. Consider, if the site does eager loading or early
	 * loading of all of the products, the response time would increase and the user
	 * might get distracted to something else.
	 *  
	 *  Console log:
		1.step: Filtering Done !
		2.step: Filtered Book Book [name=The Alchemist, Author=Paulo Coelho, genre=Adventure, rating=4.408789797]
		2.step: Filtered Book Book [name=The Alchemist 2, Author=Paulo Coelho, genre=Adventure, rating=4.408789797]
		2.step: Filtered Book Book [name=The Alchemist 3, Author=Paulo Coelho, genre=Adventure, rating=4.408789797]
		2.step: Filtered Book Book [name=The Notebook, Author=Nicholas Sparks, genre=Romance, rating=4.1]
		2.step: Filtered Book Book [name=The Notebook 2, Author=Nicholas Sparks, genre=Romance, rating=4.1]
		2.step: Filtered Book Book [name=Horror Cocktail, Author=Robert Bloch, genre=Horror, rating=2.67]
		3.step: Filtered Book Book [name=Horror Cocktail, Author=Robert Bloch, genre=Horror, rating=2.67]
		2.step: Filtered Book Book [name=House of Leaves, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		3.step: Filtered Book Book [name=House of Leaves, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		4.step: Filtered Book Book [name=House of Leaves, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		2.step: Filtered Book Book [name=House of Leaves 2, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		3.step: Filtered Book Book [name=House of Leaves 2, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		4.step: Filtered Book Book [name=House of Leaves 2, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		2.step: Filtered Book Book [name=House of Leaves 3, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		3.step: Filtered Book Book [name=House of Leaves 3, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		4.step: Filtered Book Book [name=House of Leaves 3, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		2.step: Filtered Book Book [name=House of Leaves 4, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		3.step: Filtered Book Book [name=House of Leaves 4, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		4.step: Filtered Book Book [name=House of Leaves 4, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		5.step: Collection done!
		6.step:Book [name=House of Leaves, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		6.step:Book [name=House of Leaves 2, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		6.step:Book [name=House of Leaves 3, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
		6.step:Book [name=House of Leaves 4, Author=Mark Z. Danielewski, genre=Horror, rating=4.10908908]
	 * @param args
	 */
	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();

		books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
		books.add(new Book("The Alchemist 2", "Paulo Coelho", "Adventure", 4.408789797));
		books.add(new Book("The Alchemist 3", "Paulo Coelho", "Adventure", 4.408789797));
		books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
		books.add(new Book("The Notebook 2", "Nicholas Sparks", "Romance", 4.10));
		books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
		books.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));
		books.add(new Book("House of Leaves 2", "Mark Z. Danielewski", "Horror", 4.10908908));
		books.add(new Book("House of Leaves 3", "Mark Z. Danielewski", "Horror", 4.10908908));
		books.add(new Book("House of Leaves 4", "Mark Z. Danielewski", "Horror", 4.10908908));

		/**
		 * peek:
		 * Returns a stream consisting of the elements of this stream, additionally
		 * performing the provided action on each element as elements are consumed from
		 * the resulting stream.
		 * Stream<T> peek(Consumer<? super T> action);
		 * We know consumer:
		 * public interface Consumer<T> {
		 * 	void accept(T t);
		 * }
		 */
		Stream<Book> stream = books.stream()
				.peek(book -> System.out.println("2.step: Filtered Book " + book))
				.filter((book) -> book.getGenre().equalsIgnoreCase("Horror"))
				.peek(book -> System.out.println("3.step: Filtered Book " + book))
				.filter((book) -> book.getRating() > 3)
				.peek(book -> System.out.println("4.step: Filtered Book " + book));
		// .collect(Collectors.toList());

		System.out.println("1.step: Filtering Done !");

		collect(stream);
	}

	private static void collect(Stream<Book> stream) {
		List<Book> popularHorrorBooks = stream.collect(Collectors.toList());
		System.out.println("5.step: Collection done!");
		popularHorrorBooks.forEach(book -> System.out.println("6.step:" + book.toString()));
	}

}
