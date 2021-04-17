package com.training.l140_flatMap_concatMap;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class ObservableConcatMapDemo {

	public static void main(String[] args) {
		List<String> list = List.of("Hello", "Reactive", "Programming");
		
		System.out.println("- concatMap");
		//concatMap
		/**
		 *  now if i write concat map here
			i will get the same output as the only difference
			between concat map and flat map is that when we perform
			merging using flat map on concurrently running
			observables returned by this mapper function
			then we get output 
		 */
		Observable.fromIterable(list)
		.concatMap(e -> Observable.fromArray(e.split("")))
		.toList()
		.subscribe(System.out::println);
	}
	
}
