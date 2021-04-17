package com.training.l137_operators_in_action;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class OperatorsInAction {

	public static void main(String[] args) {
		
		System.out.println("- filter, sorted, map, take:");
		@NonNull
		Observable<Employee> obs = Observable.just(
				new Employee(101, "Alexa", 60000, 4.0),
				new Employee(121, "Emma", 55000, 3.7),
				new Employee(509, "Harry", 75000, 4.3),
				new Employee(510, "Ella", 85000, 4.4),
				new Employee(511, "Mike", 65000, 4.0),
				new Employee(512, "Lucy", 94000, 4.7),
				new Employee(512, "George", 50000, 3.6)
		);
		obs
		.filter(e-> e.getRating() > 4.0)
		.sorted((e1, e2) -> Double.compare(e2.getRating(), e1.getRating()))
		.map(e -> e.getName())
		.take(4)
		//.toList()
		.subscribe(System.out::println);
		
		obs
		.filter(e-> e.getRating() < 4.0)
		.sorted((e1, e2) -> Double.compare(e2.getRating(), e1.getRating()))
		.map(e -> e.getName())
		.toSortedList()
		.subscribe(System.out::println);
		
		System.out.println("- scan:");
		//cumulative total with scan
		//takes accumulator function and apply to the first item and feeds result to next
		List<Integer> expenses = List.of(200, 500, 300, 340, 129, 234, 999, 1030, 3400, 890, 996, 789);
		Observable.fromIterable(expenses)
		.scan((a,b) -> a + b)
		.subscribe(System.out::println);
		
		System.out.println("- reduce:");
		//total with reduce
		Observable.fromIterable(expenses)
		.reduce((a,b) -> a + b)
		.subscribe(System.out::println);
	}
	
}
