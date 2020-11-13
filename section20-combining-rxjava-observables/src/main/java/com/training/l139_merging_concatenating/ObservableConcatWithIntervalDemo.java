package com.training.l139_merging_concatenating;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * Wait until first observable finish, concatted observables runs sequentially.
 * Other observables does not work. They wait until first one finish. 
 * But in this scenario it is not! 
 * Console log: 
 *  Received:source 1:0
	Received:source 1:1
	Received:source 1:2
	Received:source 1:3
	Received:source 1:4
	Received:source 1:5
	Received:source 1:6
	Received:source 1:7
	Received:source 1:8
	Received:source 1:9
 *
 * @author alper
 *
 */
public class ObservableConcatWithIntervalDemo {

	public static void main(String[] args) throws InterruptedException {

		Observable<String> source1 = Observable
				.interval(1, TimeUnit.SECONDS)
				.map(e -> "source 1:" +e);

		Observable<String> source2 = Observable
				.interval(1, TimeUnit.SECONDS)
				.map(e -> "source 2:" +e);

		Observable<String> source3 = Observable
				.interval(1, TimeUnit.SECONDS)
				.map(e -> "source 3:" +e);

		Observable<String> source4 = Observable
				.interval(1, TimeUnit.SECONDS)
				.map(e -> "source 4:" +e);

		Observable<String> source5 = Observable
				.interval(1, TimeUnit.SECONDS)
				.map(e -> "source 5:" +e);
		
		//Observable.merge(source1, source2)
		//.subscribe(e -> System.out.println("Received:" + e));
		
		Observable
		.concatArray(source1, source2, source3, source4, source5)
		.subscribe(e -> System.out.println("Received:" + e));
		
		Thread.sleep(10000);
	}

}
