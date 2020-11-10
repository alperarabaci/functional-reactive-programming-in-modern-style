package main34;

import java.util.Optional;

public class Operations {

	public static void main(String[] args) {

		Optional<String> optional = Optional.of("Value");
		Optional<String> optional2 = Optional.of("Another Value");
		Optional<String> optional3 = Optional.empty();

		// map()

		// If a value is present, returns an Optional describing (as if by ofNullable)
		// the result of applying the given mapping function to the value, otherwise
		// returns an empty Optional.
		// val is not Empty, map
		
		String orElse = optional.map(val -> "Replaced").orElse("Empty");
		System.out.println(orElse);// Replaced

		// value not found, orElse
		Optional<String> map = optional3.map(val -> "Replaced");
		System.out.println(map.orElse("Empty"));// Empty

		// value not found, get exception!
		//String orElse3 = optional3.map(val -> "Replaced").get();
		//System.out.println(orElse3);// Empty

		// filter()
		// If a value is present, and the value matches the given predicate, returns an
		// Optional describing the value, otherwise returns an empty Optional.
		Optional<String> filter = optional.filter(val -> val.equalsIgnoreCase("Value"));
		System.out.println("filter:" + filter.get());// Value

		Optional<String> filter2 = optional2.filter(val -> val.equalsIgnoreCase("Value"));
		System.out.println("filter:" + filter2.orElse("Filtered"));// Filtered

		// flatMap()

		// If a value is present, returns the result of applying the given
		// Optional-bearing mapping function to the value, otherwise returns an empty
		// Optional.
		
		//diff with map: return type of flatMap is Optional
		Optional<String> flatMap = optional.flatMap(val -> Optional.of("Replaced By FlatMap"));
		System.out.println("flatMap:" + flatMap.get());// Replaced By FlatMap

		Optional<String> flatMap2 = optional3.flatMap(val -> Optional.of("Replaced By FlatMap"));
		System.out.println("flatMap:" + flatMap2.get());// NoSuchElementException: No value present

	}

}