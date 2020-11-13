package com.trainint.l128_hot_and_cold_observables;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

/**
 * https://medium.com/tompee/rxjava-ninja-hot-and-cold-observables-19b30d6cc2fa
 * In contrast to cold observables, hot observables emit items regardless of
 * whether there are observers. In a hot observable, there is a single source of
 * emission and depending on when observers subscribe, they may miss some of
 * those emissions.
 * 
 * @author alper
 *
 */
public class HotObservablesDemo {

	public static void main(String[] args) throws InterruptedException {
		multicastTest();
	}

	public static void multicastTest() throws InterruptedException {
		Observable<Long> myObservable = Observable.interval(1, TimeUnit.SECONDS);
		ConnectableObservable<Long> connectableObservable = myObservable.publish();
		connectableObservable.subscribe(item -> System.out.println("Observer 1: " + item));
		connectableObservable.connect();
		Thread.sleep(3000);
		connectableObservable.subscribe(item -> System.out.println("Observer 2: " + item));
		Thread.sleep(5000);
	}
}
