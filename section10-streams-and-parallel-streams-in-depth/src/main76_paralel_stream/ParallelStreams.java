package main76_paralel_stream;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreams {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			list.add(new Employee("John", 20000));
			list.add(new Employee("Rohn", 3000));
			list.add(new Employee("Tom", 15000));
			list.add(new Employee("Bheem", 8000));
			list.add(new Employee("Shiva", 200));
			list.add(new Employee("Krishna", 50000));
		} 
		
	}
}
