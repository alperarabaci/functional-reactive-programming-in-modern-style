package main32;

import java.util.Optional;

public class OptionalCreation {

	/**
	 * Optionals are immutable
	 * @param args
	 */
	public static void main(String[] args) {
		String val = "";
		//this gets null pointer exception if val = null
		Optional<String> optional = Optional.of(val);
		
		//empty
		
		Optional<Integer> empty = Optional.empty();
		
		//nullable
		String val2 = null;
		Optional<String> nullable = Optional.ofNullable(val2);
		Optional<String> emptyOptional = Optional.ofNullable(null);
	}
}
