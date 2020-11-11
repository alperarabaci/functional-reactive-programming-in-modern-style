package main22_unaryop;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class UnaryOpPractice {

	public static void main(String[] args) {
		List<Integer> list = List.of(10, 20, 30, 40, 50);

		UnaryOperator<Integer> operator1 = i -> i * 100;

		List<Integer> newList = mapper(list, operator1);

		System.out.println(newList);

		// with stream:
		System.out.println("-----");
		System.out.println("using stream");

		newList = mapper2(list, operator1);

		System.out.println(newList);

		// andThen
		System.out.println("-----");
		System.out.println("andThen");
		UnaryOperator<Integer> operator2 = t -> t + 10;
		int result = operator1.andThen(operator2).apply(10);
		System.out.println(result);

		System.out.println("-----");
		System.out.println("compose");
		// Using compose()
		// Returns a composed function that first applies the before function to its
		// input, and then applies this function to the result
		int b = operator1.compose(operator2).apply(10);
		System.out.println(b);
	}

	private static <T> List<T> mapper2(List<T> list, UnaryOperator<T> operator) {
		return list.stream().map(operator).collect(Collectors.toList());
	}

	private static <T> List<T> mapper(List<T> list, UnaryOperator<T> operator) {
		List<T> newList = new ArrayList<>();

		for (T t : list) {
			T element = operator.apply(t);
			newList.add(element);
		}

		return newList;
	}

}
