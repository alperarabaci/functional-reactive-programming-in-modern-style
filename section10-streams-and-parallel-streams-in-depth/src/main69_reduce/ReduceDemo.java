package main69_reduce;

import java.util.stream.Stream;

public class ReduceDemo {

	public static void main(String[] args) {
		Integer sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
				.reduce(0, (a,b)->a+b);
				
		System.out.println("Sum: " + sum);
	}
}
