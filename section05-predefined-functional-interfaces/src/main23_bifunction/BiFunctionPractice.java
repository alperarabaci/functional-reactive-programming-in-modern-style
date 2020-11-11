package main23_bifunction;

import java.util.function.BiFunction;

public class BiFunctionPractice {

	public static void main(String[] args) {
		BiFunction<String, String, String> biFunction = (a, b) -> a + b;
		
		System.out.println(biFunction.apply("wordyourself", "app"));

		BiFunction<String, String, Integer> biFunction2 = (a, b) -> (a + b).length();
		
		System.out.println(biFunction2.apply("wordyourself", "app"));
	}
	
}
