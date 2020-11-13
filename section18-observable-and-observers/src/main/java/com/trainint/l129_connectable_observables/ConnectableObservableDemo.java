package com.trainint.l129_connectable_observables;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

/**
 * Hot observable example
 * @author alper
 *
 */
public class ConnectableObservableDemo {

	public static void main(String[] args) throws InterruptedException {
		@NonNull
		ConnectableObservable<@NonNull Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();
		
		source.connect();
		
		source.subscribe(e -> System.out.println("Observable 1:"+ e));
		
		Thread.sleep(10000);
		
		source.subscribe(e -> System.out.println("Observable 2:"+ e));
		
		//continue a bit more to see second one
		Thread.sleep(10000);
	}
}
