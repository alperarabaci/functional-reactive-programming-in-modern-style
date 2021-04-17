package l150_observeOn;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserveOn {

	/**
	 *  RxComputationThreadPool-1
		PASTA: printed by:  RxComputationThreadPool-1
		RxComputationThreadPool-1
		PIZZA: printed by:  RxComputationThreadPool-1
		RxComputationThreadPool-1
		RxComputationThreadPool-1
		RxComputationThreadPool-1
		------
		RxComputationThreadPool-2
		RxComputationThreadPool-2
		RxComputationThreadPool-2
		PASTA: printed by:  RxNewThreadScheduler-2
		RxComputationThreadPool-2
		PIZZA: printed by:  RxNewThreadScheduler-2
		RxComputationThreadPool-2
		
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		/*
		Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
				.subscribeOn(Schedulers.computation())
				.map(e -> e.toUpperCase())
				.subscribeOn(Schedulers.newThread())
				.filter(e -> e.startsWith("P"))
				.subscribe(e -> print(e));
		*/
		
		
		Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
		.subscribeOn(Schedulers.computation())
		.map(e -> e.toUpperCase())
		.doOnNext(e -> System.out.println(Thread.currentThread().getName()))
		.subscribeOn(Schedulers.newThread())
		.filter(e -> e.startsWith("P"))
		.subscribe(e -> print(e));
		
		
		Thread.sleep(5000);
		System.out.println("------");
		
		Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
		.subscribeOn(Schedulers.computation())
		.map(e -> e.toUpperCase())
		.doOnNext(e -> System.out.println(Thread.currentThread().getName()))
		.observeOn(Schedulers.newThread())
		.filter(e -> e.startsWith("P"))
		.subscribe(e -> print(e));
		
		Thread.sleep(5000);
	}
	
	public static void print(String e) throws InterruptedException {
		System.out.println( e + ": printed by:  " + Thread.currentThread().getName());
	}
}
