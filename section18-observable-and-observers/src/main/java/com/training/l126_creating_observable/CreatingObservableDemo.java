package com.training.l126_creating_observable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class CreatingObservableDemo {

	public static void main(String[] args) {
		System.out.println("Observable.create:");
		Observable<Integer> source = Observable.create(e -> {
			e.onNext(10);
			e.onNext(11);
			e.onNext(12);
			e.onComplete();
		});
		source.subscribe(System.out::println);
		
		
		// just() Converts n items into an Observable that emits those items.
		System.out.println("Observable.just:");
		Observable<Integer> just = Observable.just(21,32,43);
		just.subscribe(System.out::println);
		
		//fromIterable
		System.out.println("Observable.fromIterable:");
		List<String> list = List.of("Ram", "Shyam", "Mike");
		
		@NonNull
		Observable<String> fromIterable = Observable.fromIterable(list);
		fromIterable.subscribe(System.out::println);
		
	}
}
