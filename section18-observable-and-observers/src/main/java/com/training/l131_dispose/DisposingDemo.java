package com.training.l131_dispose;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class DisposingDemo {

public static void main(String[] args) throws InterruptedException {
	@NonNull
	Observable<@NonNull Long> source = Observable.interval(1, TimeUnit.SECONDS);
	
	
	@NonNull
	Disposable d = source.subscribe(e -> System.out.println("Observable 1:"+ e));
	
	Thread.sleep(5000);
	d.dispose();
	
	source.subscribe(e -> System.out.println("Observable 2:"+ e));
	
	//continue a bit more to see second one
	Thread.sleep(10000);
}
	
}
