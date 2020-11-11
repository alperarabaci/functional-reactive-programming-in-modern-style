package main21_function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionPractice {

	public static void main(String[] args) {

		List<String> list = List.of("Kit", "Kat", "Shake");

		Function<String, Integer> function = e -> e.length();

		List<Integer> newList = map(list, function);
		List<Integer> newList2 = map2(list, function);

		System.out.println(newList);
		System.out.println("--------");
		System.out.println(newList2);
	}

	private static <T, R> List<R> map2(List<T> list, Function<T, R> function) {
		return list.stream()
				.map(function)
				.collect(Collectors.toList());
	}

	private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
		List<R> newList = new ArrayList<>();
		for (T e : list) {
			newList.add(function.apply(e));
		}
		return newList;
	}

}
