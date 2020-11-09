package main24;

import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorPractice {

	public static void main(String[] args) {
		BinaryOperator<String> operator = (a,b) -> a + "." + b;
		
		System.out.println(operator.apply("wordyourself", "app"));
		
		System.out.println("--------");
		System.out.println("Stream:");
		List<String> words = List.of("foo", "boo", "woo", "zoo");
		String singleWord = words.stream()
				.reduce(operator)
				.orElse("");
		
		System.out.println(singleWord);
	}
	
}
