package main91_cascading_collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import main87_terminal_analogous_collectors.Employee;
import main87_terminal_analogous_collectors.EmployeeSpliterator;

public class DownstreamCollectorsDemo {

	public static void main(String[] args) {
		Path p = Paths.get("./resource/employee-data.txt");
		try(Stream<String> lines = Files.lines(p);) {
			//27827,Richard,M,1988-06-10,Boston,Developer,2017-12-12,60000.00			
			//split lines to string stream (check section11 ReadingObjectFromFileDemo)
			//then create object from them using custom spliterator
			Stream<String> fields = lines.flatMap(line -> Arrays.stream(line.split(",")));
			Spliterator<String> baseSpliterator = fields.spliterator();
			Spliterator<Employee> spliterator = new EmployeeSpliterator(baseSpliterator);
			
			List<Employee> employees = StreamSupport.stream(spliterator, false)
											.collect(Collectors.toList());
			
			Map<String, Long> countByDesignation = employees.stream()
			.collect(Collectors.groupingBy(e -> e.getDesignation(), Collectors.counting()));
			System.out.println("countByDesignation: ");
			System.out.println(countByDesignation);

			
			Map<String, Double> fundDistribution = employees.stream().collect(
					Collectors.groupingBy(e -> e.getDesignation(), Collectors.summingDouble(e -> e.getSalary())));
			System.out.println("fundDistribution: ");
			System.out.println(fundDistribution);
			
			Map<String, Optional<Employee>> maxSalary = employees.stream().collect(
					Collectors.groupingBy(e -> e.getDesignation(), Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))));
			
			System.out.println("maxSalary:");
			System.out.println(maxSalary);
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
