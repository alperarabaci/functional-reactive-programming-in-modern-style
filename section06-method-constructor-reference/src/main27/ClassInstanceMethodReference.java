package main27;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ClassInstanceMethodReference {

	public static void main(String[] args) {
		
		List<String> list = List.of("Kit", "Kat", "Shake");
		/**
		 * Class::instanceMethod
		 * Method reference to an instance method of an input object of a
		 * particular type
		 */
		//Function<String, Integer> function = e-> e.length();
		Function<String, Integer> function = String :: length;
		
		List<Integer> newList = map(list, function);
		
		System.out.println(newList);
	}

	private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
		List<R> newList = new ArrayList<>();
		for (T e : list) {
			newList.add(function.apply(e));
		}
		return newList;
	}
	
}
