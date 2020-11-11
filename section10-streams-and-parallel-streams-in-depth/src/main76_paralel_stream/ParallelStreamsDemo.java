package main76_paralel_stream;

import java.util.ArrayList;
import java.util.List;

import main76_paralel_stream.warmup.ManualClassLoader;

/**
 * 
 *  Console log:
 *  
 *  Performing Sequential:50000000
 *	Total time (sequential):170
 *	Performing Paralel:50000000
 *	Total time (paralel):127
 *	
 *  For less data it's not efficient:
 *	Performing Sequential:500000
 *	Total time (sequential):14
 *	Performing Paralel:500000
 *	Total time (paralel):80
 * 
 * 
 * @author alper
 *
 */
public class ParallelStreamsDemo {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		
		for (int i = 0; i < 100000; i++) {
			list.add(new Employee("John", 20000));
			list.add(new Employee("Rohn", 3000));
			list.add(new Employee("Tom", 15000));
			list.add(new Employee("Bheem", 8000));
			list.add(new Employee("Shiva", 200));
			list.add(new Employee("Krishna", 50000));
		}
		/**
		 * https://www.baeldung.com/java-jvm-warmup#what-is-warming-up-the-jvm
		 */
		ManualClassLoader.warmUp();
		
		runStream(list);
		runParalelStream(list);
	}

	private static void runStream(List<Employee> list) {
		long startTime = System.currentTimeMillis();
		
		long count = list.stream()
			.filter(e -> e.getSalary()>1000)
			.count();
		System.out.println("Performing Sequential:" + count);
		
		long endTime = System.currentTimeMillis();
		System.out.println("Total time (sequential):" + (endTime-startTime));
	}

	private static void runParalelStream(List<Employee> list) {
		long startTime = System.currentTimeMillis();
		
		long count = list.parallelStream()
				.filter(e -> e.getSalary()>1000)
				.count();
		System.out.println("Performing Paralel:" + count);
		
		long endTime = System.currentTimeMillis();
		System.out.println("Total time (paralel):" + (endTime-startTime));
	}
}
