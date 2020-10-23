package main23;

import java.util.function.BiFunction;

public class BiFunctionPractice {

	public static void main(String[] args) {
		BiFunction<String, String, String> biFunction = (a, b) -> a + b;
		
		System.out.println(biFunction.apply("wordyourself", "app"));
	}
	
}
