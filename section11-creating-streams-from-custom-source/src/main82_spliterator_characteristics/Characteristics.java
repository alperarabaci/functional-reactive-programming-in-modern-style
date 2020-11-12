package main82_spliterator_characteristics;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class Characteristics {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(7);
		list.add(9);
		list.add(0);
		list.add(1);
		
		Stream<Integer> stream = list.stream();
		Spliterator<Integer> spliterator = stream.spliterator();
		int characteristics = spliterator.characteristics();
		System.out.println(Integer.bitCount(characteristics));
	}
}
