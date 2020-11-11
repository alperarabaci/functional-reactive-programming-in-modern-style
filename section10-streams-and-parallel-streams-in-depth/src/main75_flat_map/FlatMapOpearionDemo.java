package main75_flat_map;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapOpearionDemo {
	
	public static void main(String[] args) throws URISyntaxException {
		System.out.println("Example 1:");
		streamOfAndFlatMapExample();
		System.out.println("Example 2:");
		flatMapExample();
	}

	private static void streamOfAndFlatMapExample() {
		Stream<String> a = Stream.of("Hello", "there!");
		Stream<String> b = Stream.of("Learning", "Java?");
		
		Stream<Stream<String>> of = Stream.of(a, b);
		
		Stream<String> flatMap= Stream.of(a, b)
			.flatMap(e->e);
		
		flatMap.forEach(System.out::println);
	}

	private static void flatMapExample() {
		Path p = Paths.get("./resource/text.txt");
		try(Stream<String> book = Files.lines(p);) {
			book.flatMap(line -> Arrays.stream(line.split(" ")))
			.forEach(System.out::println);
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
}
