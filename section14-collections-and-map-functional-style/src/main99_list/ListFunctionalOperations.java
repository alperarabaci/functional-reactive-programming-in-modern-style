package main99_list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ListFunctionalOperations {

	public static void main(String[] args) {

		List<Movie> movies = Arrays.asList(new Movie("Spotlight", 2015, "Hollywood"),
				new Movie("Avengers: Infinity War", 2018, "Hollywood"),
				new Movie("Inception", 2010, "Hollywood"),
				new Movie("Forest Gump", 1994, "Hollywood"), 
				new Movie("3 Idiots", 2009, "Bollywood"),
				new Movie("Beauty and the beast", 2017, "Hollywood"),
				new Movie("Slumdog Millionaire", 2008, "Bollywood"));
		
		//traversal
		System.out.println("-List:");
		movies.forEach(System.out::println);
		
		//sorting (I)
		System.out.println("-Sort by name:");
		movies.sort(Comparator.naturalOrder());
		movies.forEach(System.out::println);

		//sorting (II)
		System.out.println("-Sort by release year:");
		movies.sort((o1, o2) ->  o1.getReleaseYear()-o2.getReleaseYear());
		movies.forEach(System.out::println);
		
		//filtering
		System.out.println("-Filter (Hollywood):");
		movies.stream()
			.filter(e -> "Hollywood".equals(e.getIndustry()))
			.forEach(System.out::println);
		
		//mapping
		System.out.println("-List movie names:");
		movies.stream()
			.map(movie -> movie.getName())
			.forEach(System.out::println);
		
		//reducing
		Optional<String> movieNames = movies.stream()
			.map(movie -> movie.getName())
			.reduce((a, b)-> a.concat(", ").concat(b));
		System.out.println("-Concatted movie names:");
		System.out.println(movieNames.orElse(""));
			
			
	}

}
