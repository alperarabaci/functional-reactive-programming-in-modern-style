package main87_terminal_analogous_collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.stream.Collectors;
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
			List<Employee> employees = stream.collect(Collectors.toList());
			
			List<String> names = employees.stream()
					.map(employee -> employee.getName())
			.collect(Collectors.toList());
			

			Set<String> designations = employees.stream()
					.map(e -> e.getDesignation())
			.collect(Collectors.toSet());
			
			System.out.println("names:");
			names.forEach(System.out::println);
			
			System.out.println("designations:");
			designations.forEach(System.out::println);
			
			TreeSet<Employee> employeeSorted = employees.stream()
			.collect(Collectors.toCollection(TreeSet<Employee>::new));
			
			System.out.println("sorted:");
			employeeSorted.forEach(System.out::println);
			
			Map<Integer, String> mapName = employees.stream()
			.collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));
			
			//partitioningBy
			System.out.println("map:");
			System.out.println(mapName);
			
			Map<Boolean, List<Employee>> collect = employees.stream()
			.collect(Collectors.partitioningBy(e -> e.getGender() == 'M'));
			
			System.out.println("Partition by Gender(M)");
			System.out.println(collect.get(true));
			System.out.println("Partition by Gender(!M)");
			System.out.println(collect.get(false));
			
			
			Map<String, List<Employee>> collect2 = employees.stream()
			.collect(Collectors.groupingBy(e -> e.getDesignation()));
			
			System.out.println("Map groupBy designation:");
			System.out.println(collect2);
			
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}

}
