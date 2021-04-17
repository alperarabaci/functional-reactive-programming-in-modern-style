package com.training.l135_what_are_operators;

import io.reactivex.rxjava3.core.Observable;

public class OperatorsDemo {

	public static void main(String[] args) {
		
		//filter
		System.out.println("- filter:");
		Observable.just(60, 57, 89, 90, 23)
			.filter(e -> e>75)
			.subscribe(e -> System.out.println("Grade A with " + e));
		
		
		//filter & sorted
		System.out.println("- filter & sorted:");
		
		Observable.just(60, 57, 89, 90, 23, 100, 74)
		.filter(e -> e>75)
		.sorted()
		.subscribe(e -> System.out.println("Grade A with " + e));
	}
	
}
