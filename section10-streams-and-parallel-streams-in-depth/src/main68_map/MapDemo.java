package main68_map;

import java.util.stream.Stream;

public class MapDemo {
	
	public static void main(String[] args) {
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
		.map(e -> e * 2)
		.forEach(System.out::println);
	}
	
}
