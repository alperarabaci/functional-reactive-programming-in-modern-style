package main73_bounded_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class BoundedStreamsDemo {

	public static void main(String[] args) {
		//1. Stream on a Collection
		List<Integer> list = List.of(1, 4, 7, 9, 4 );
		Stream<Integer> streamIntegers = list.stream();
		
		//Stream on a map
		Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three", 4, "four");
		Stream<Entry<Integer, String>> entries = map.entrySet().stream();
		
		Stream<String> values = map.values().stream();
		Stream<Integer> keys = map.keySet().stream();
		
		//2. Stream.of() method
		Stream<String> streamStrings = Stream.of("Hey", "Happy", "Thanksgiving");
		
		//3. Arrays.stream() method
		Integer[] integerArr = {3, 5, 7, 89, 9};
		Stream<Integer> stream = Arrays.stream(integerArr);
		int[] intArr = {3, 5, 7, 89, 9};
		IntStream stream2 = Arrays.stream(intArr);
		
		//4. Stream.builder() method
		//we don't need to first generate a list for dynamic content:
		Builder<Object> builder = Stream.builder();
		builder.add(1);
		//code
		//...
		//...
		builder.add(4);
		//condition
		//...
		//...
		builder.build();
	}
	
}
