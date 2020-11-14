package l147_schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Single thread.
	1.subscriber computation done by: Pasta - RxSingleScheduler-1
	1.subscriber computation done by: Pizza - RxSingleScheduler-1
	1.subscriber computation done by: Fries - RxSingleScheduler-1
	1.subscriber computation done by: Curry - RxSingleScheduler-1
	1.subscriber computation done by: Chow mein - RxSingleScheduler-1
	2.subscriber computation done by: Pasta - RxSingleScheduler-1
	2.subscriber computation done by: Pizza - RxSingleScheduler-1
	2.subscriber computation done by: Fries - RxSingleScheduler-1
	2.subscriber computation done by: Curry - RxSingleScheduler-1
	2.subscriber computation done by: Chow mein - RxSingleScheduler-1
	3.subscriber computation done by: Pasta - RxSingleScheduler-1
 
 * @author alper
 *
 */
public class ObservableSingleScheduler {
	
	public static void main(String[] args) throws InterruptedException {
		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
				.subscribeOn(Schedulers.single());
		
		src.subscribe(e -> sensitiveTask(e, 1));
		src.subscribe(e -> sensitiveTask(e, 2));
		
		//Thread.sleep(5000);
		
		src.subscribe(e -> sensitiveTask(e, 3));
		src.subscribe(e -> sensitiveTask(e, 4));
		src.subscribe(e -> sensitiveTask(e, 5));
		src.subscribe(e -> sensitiveTask(e, 6));
		src.subscribe(e -> sensitiveTask(e, 7));
		src.subscribe(e -> sensitiveTask(e, 8));
		src.subscribe(e -> sensitiveTask(e ,9));
		src.subscribe(e -> sensitiveTask(e, 10));
		
		Thread.sleep(50000);
	}
	
	public static void sensitiveTask(String e, Integer subscriberId) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println(subscriberId + ".subscriber computation done by: " + e + " - " + Thread.currentThread().getName());
	}

}
