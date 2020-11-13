package com.training.l130_observable_variants;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class VariantsDemo {

	public static void main(String[] args) {
		@NonNull
		Observable<String> source = Observable.just("Alex", "Justin", "Jack");
		@NonNull
		Observable<Object> source2 = Observable.empty();
		
		source
		.first("Name")
		.subscribe(System.out::println);
		
		Single.just("Alex")
		.subscribe(System.out::println);
		
		source2
		.firstElement()
		.subscribe(System.out::println,
				   e -> e.printStackTrace(),
				   ()->System.out.println("Completed"));
		
		Completable completable = Completable.complete();
		System.out.println("----");
		completable.subscribe(()->System.out.println("Completed"));
		
		Completable
		.fromRunnable(()->System.out.println("Some process executing"))
		.subscribe( ()-> System.out.println("The process successfully"));
	}
	
}
