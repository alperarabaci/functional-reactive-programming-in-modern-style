package com.training.l140_flatMap_concatMap;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class ObservableFlatMapDemo {

	public static void main(String[] args) {
		List<String> list = List.of("Hello", "Reactive", "Programming");
		
		System.out.println("- flatMap");
		//flatMap
		Observable.fromIterable(list)
		.flatMap(e -> Observable.fromArray(e.split("")))
		.toList()
		.subscribe(System.out::println);
		
		System.out.println("- map");
		//map
		Observable.fromIterable(list)
		.map(e -> e.length())
		.toList()
		.subscribe(System.out::println);
	}
	
}
