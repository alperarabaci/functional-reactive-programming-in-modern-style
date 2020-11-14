package com.training.l141_disposing_of_duplicate_emitting_sources;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * 
 * Console log:
    Ob 2:0
	Ob 2:1
	Ob 2:2
	Ob 2:3
	Ob 2:4
	Ob 2:5
	Ob 2:6
	Ob 2:7
	Ob 2:8
	Ob 2:9

 * @author alper
 *
 */
public class AmbigouousDemo {

	public static void main(String[] args) throws InterruptedException {
		
		Observable<String> ob1 = Observable
								.interval(1, TimeUnit.SECONDS)
								.take(10)
								.map(e -> "Ob 1:" + e);
		
		Observable<String> ob2 = Observable
								.interval(1, TimeUnit.MICROSECONDS)
								.take(10)
								.map(e -> "Ob 2:" + e);

		//faster one wins
		Observable.amb(Arrays.asList(ob1, ob2))
				.subscribe(System.out::println);
		
		Thread.sleep(5000);
	}
	
}
