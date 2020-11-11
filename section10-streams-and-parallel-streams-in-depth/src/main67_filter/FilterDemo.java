package main67_filter;

import java.util.stream.Stream;

public class FilterDemo {

	public static void main(String[] args) {
		Stream.of(34, 233, 904, 949, 92)
		.filter(i -> i%2 == 0)
		.forEach(System.out::println);
	}
}
