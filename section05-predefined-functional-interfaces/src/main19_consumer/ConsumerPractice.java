package main19_consumer;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractice {
	
	public static void main(String[] args) {
		List<Integer> list = List.of(34, 67, 8, 23, 67, 89, 90);
		
		Consumer<Integer> consumer = e -> System.out.println(e);
		
		consumer.accept(56);
		
		printElements(list, consumer);
		printElements2(list, consumer);
	}

	private static <T> void printElements(List<T> list, Consumer<T> consumer) {
		for (T t: list) {
			consumer.accept(t);
		}
	}

	private static <T> void printElements2(List<T> list, Consumer<T> consumer) {
		list.forEach(consumer);
	}
 
}
