package main87_terminal_analogous_collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class CollectorsInActionDemo {
	
	public static void main(String[] args) {
		Path p = Paths.get("./resource/employee-data.txt");
		try(Stream<String> lines = Files.lines(p);) {
			//27827,Richard,M,1988-06-10,Boston,Developer,2017-12-12,60000.00			
			//split lines to string stream (check section11 ReadingObjectFromFileDemo)
			//then create object from them using custom spliterator
			Stream<String> fields = lines.flatMap(line -> Arrays.stream(line.split(",")));
			Spliterator<String> baseSpliterator = fields.spliterator();
			Spliterator<Employee> spliterator = new EmployeeSpliterator(baseSpliterator);
			
			Stream<Employee> stream = StreamSupport.stream(spliterator, false);
			stream.forEach(System.out::println);
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}

}
