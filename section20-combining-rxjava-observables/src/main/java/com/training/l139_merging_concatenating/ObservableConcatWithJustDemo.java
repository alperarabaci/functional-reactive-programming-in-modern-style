package com.training.l139_merging_concatenating;

import io.reactivex.rxjava3.core.Observable;

/**
 * Concatted observables runs sequentially.
 * Console log:
 *  
	Received:Ella
	Received:Alexa
	Received:Lily
	Received:Ella 2
	Received:Alexa 2
	Received:Lily 2
	Received:Priya
	Received:Chloe
	Received:Priya 2
	Received:Chloe 2
 *
 * @author alper
 *
 */
public class ObservableConcatWithJustDemo {

	public static void main(String[] args) throws InterruptedException {

		Observable<String> source1 = Observable.just("Ella", "Alexa", "Lily");
		Observable<String> source2 = Observable.just("Ella 2", "Alexa 2", "Lily 2");
		Observable<String> source3 = Observable.just("Priya", "Chloe");
		Observable<String> source4 = Observable.just("Priya 2", "Chloe 2");
		
		//Observable.merge(source1, source2)
		//.subscribe(e -> System.out.println("Received:" + e));
		
		Observable
		.concatArray(source1, source2, source3, source4)
		.subscribe(e -> System.out.println("Received:" + e));
		
		Thread.sleep(10000);
	}

}
