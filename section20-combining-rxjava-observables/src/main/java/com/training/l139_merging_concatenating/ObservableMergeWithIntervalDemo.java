package com.training.l139_merging_concatenating;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * They do not work in order.
 * Console log: 
 *  Received:source 1:8
	Received:source 3:8
	Received:source 4:8
	Received:source 5:8
	Received:source 2:8
	
	Received:source 3:9
	Received:source 1:9
	Received:source 2:9
	Received:source 4:9
	Received:source 5:9
 * @author alper
 *
 */
public class ObservableMergeWithIntervalDemo {

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
		.mergeArray(source1, source2, source3, source4, source5)
		.subscribe(e -> System.out.println("Received:" + e));
		
		Thread.sleep(10000);
	}

}
