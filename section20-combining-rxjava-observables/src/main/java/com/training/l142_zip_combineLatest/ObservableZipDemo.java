package com.training.l142_zip_combineLatest;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ObservableZipDemo {

	public static void main(String[] args) throws InterruptedException {
		Observable<Long> source1 = Observable.interval(200, TimeUnit.MILLISECONDS);
		Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);
		
		Observable.zip(source1, source2, (e1, e2) -> "Source 1: " +e1 + " Source 2: " +e2)
		.subscribe(System.out::println);
		
		Thread.sleep(10000);
	}

}
