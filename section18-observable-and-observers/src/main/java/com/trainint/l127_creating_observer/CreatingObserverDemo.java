package com.trainint.l127_creating_observer;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObserverDemo {

	public static void main(String[] args) {
		Observable<String> source = Observable.just("Orange", "Black", "Red");
		source.subscribe(i -> System.out.println(i), 
				Throwable::printStackTrace, 
				() -> System.out.println("Completed"));
		
		System.out.println("- Alternative 1:");
		
		source.subscribe(i -> System.out.println(i), 
				Throwable::printStackTrace);
		
		System.out.println("- Alternative 2:");
		
		source.subscribe(i -> System.out.println(i));
	}
	
}
