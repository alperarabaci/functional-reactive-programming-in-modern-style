package com.training.l131_dispose;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class MultipleDisposingDemo {

	private static final CompositeDisposable disp = new CompositeDisposable();
	
	public static void main(String[] args) throws InterruptedException {
		@NonNull
		Observable<@NonNull Long> source = Observable.interval(1, TimeUnit.SECONDS);
		
		@NonNull
		Disposable d1 = source.subscribe(e -> System.out.println("Observable 1:"+ e));
		
		@NonNull
		Disposable d2 = source.subscribe(e -> System.out.println("Observable 2:"+ e));
		disp.addAll(d1, d2);

		Thread.sleep(5000);
		
		disp.dispose();
		
		System.out.println("Disposed...");
		//continue a bit more to see second one
		Thread.sleep(10000);
		
		System.out.println("Completed...");
	}
	
}
