package main35;

import java.util.Optional;
import java.util.stream.Stream;

public class MoreOperations {

	public static void main(String[] args) {

		// ifPresent

		Optional<String> optional = Optional.of("Value");

		optional.ifPresent(val -> System.out.println("ifPresent: This is a " + val));

		// isPresent
		if (optional.isPresent()) {
			System.out.println("isPresent: This is a " + optional.get());
		}

		// ifPresentOrElse

		Optional.empty().ifPresentOrElse(System.out::println,
				() -> System.out.println("ifPresentOrElse: Value is absent"));

		optional.ifPresentOrElse(System.out::println, () -> System.out.println("Value is absent"));

		// stream

		Stream<String> stream = optional.stream();

		Optional.empty().stream().forEach(System.out::println);

		// or

		// If a value is present, returns an Optional describing the value, otherwise
		// returns an Optional produced by the supplying function.
		System.out.print("Optional.or:");
		optional.or(() -> Optional.of("New Value")).ifPresent(System.out::println);

		System.out.print("Optional.or(empty):");
		Optional.empty().or(() -> Optional.of("New Value")).ifPresent(System.out::println);
		
		// return null value get exception! java.lang.NullPointerException
		//Optional.empty().or(() -> null).ifPresent(System.out :: println);

		// equals

		// optional
		// either both are empty
		// or if the values in optionals are equal to each other via equals method

		System.out.println(optional.equals(Optional.of("Value")));

		// hashcode

		System.out.println(Optional.empty().hashCode());

	}

}
