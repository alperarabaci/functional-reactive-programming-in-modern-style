package main83_custom_spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class ReadingObjectFromFileDemo {

	public static void main(String[] args) {
		Path p = Paths.get("./resource/books.txt");
		try(Stream<String> lines = Files.lines(p);) {
			Spliterator<String> baseSpliterator = lines.spliterator();
			Spliterator<Book> spliterator = new BookSpliterator(baseSpliterator);
			
			Stream<Book> stream = StreamSupport.stream(spliterator, false);
			stream.forEach(System.out::println);
			
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
}
