package com.training.l142_zip_combineLatest;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ObservableCombineLatestDemo {

	public static void main(String[] args) throws InterruptedException {
		//take method limits Observable.
		Observable<Long> source1 = Observable.interval(200, TimeUnit.MILLISECONDS).take(20);
		Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS).take(20);
		
		Observable.combineLatest(source1, source2, (e1, e2) -> "Source 1: " +e1 + " Source 2: " +e2)
		.subscribe(System.out::println);
		
		Thread.sleep(20000);
	}

}
