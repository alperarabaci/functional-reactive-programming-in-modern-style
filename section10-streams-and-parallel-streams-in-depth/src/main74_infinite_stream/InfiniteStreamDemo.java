package main74_infinite_stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreamDemo {

	public static void main(String[] args) {
		//infiniteStream();
		limitedStream(10);
		//infiniteStringStream();
		//infiniteRandomIntegerStream();
	}

	private static void infiniteStringStream() {
		Stream.generate(() -> "Hello")
			.forEach(System.out::println);
	}
	
	private static void infiniteRandomIntegerStream() {
		Stream.generate(new Random()::nextInt)
		.forEach(System.out::println);
	}

	private static void infiniteStream() {
		//infinite stream:
		//alternative
		//Stream.iterate(0, i->i+1)
		//.forEach(System.out::println);
		
		IntStream.iterate(0, i -> i-1)
		.forEach(System.out::println);
	}

	private static void limitedStream(int startIndex) {
		//infinite stream:
		//alternative
		//Stream.iterate(0, i->i+1);
		
		IntStream.iterate(startIndex, i -> i-1)
		.limit(15)
		.forEach(System.out::println);
	}
}
