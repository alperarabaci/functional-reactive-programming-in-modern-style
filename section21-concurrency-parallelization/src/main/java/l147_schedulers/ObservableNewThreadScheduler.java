package l147_schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Same result with ObservalbeIOScheduler. One thread for each subscriber.
 * 
	Computation done by: Pasta - RxNewThreadScheduler-2
	Computation done by: Pasta - RxNewThreadScheduler-4
	Computation done by: Pasta - RxNewThreadScheduler-3
	Computation done by: Pasta - RxNewThreadScheduler-1
	Computation done by: Pasta - RxNewThreadScheduler-5
	Computation done by: Pasta - RxNewThreadScheduler-6
	Computation done by: Pasta - RxNewThreadScheduler-7
	Computation done by: Pasta - RxNewThreadScheduler-10
	Computation done by: Pasta - RxNewThreadScheduler-9
	Computation done by: Pasta - RxNewThreadScheduler-8
	Computation done by: Pizza - RxNewThreadScheduler-5
	Computation done by: Pizza - RxNewThreadScheduler-1
	Computation done by: Pizza - RxNewThreadScheduler-2
	Computation done by: Pizza - RxNewThreadScheduler-4
	Computation done by: Pizza - RxNewThreadScheduler-6
	Computation done by: Pizza - RxNewThreadScheduler-3
	Computation done by: Pizza - RxNewThreadScheduler-10
	Computation done by: Pizza - RxNewThreadScheduler-7
	Computation done by: Pizza - RxNewThreadScheduler-8
	Computation done by: Pizza - RxNewThreadScheduler-9
	Computation done by: Fries - RxNewThreadScheduler-2
	Computation done by: Fries - RxNewThreadScheduler-5

 * @author alper
 *
 */
public class ObservableNewThreadScheduler {

	public static void main(String[] args) throws InterruptedException {
		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
				.subscribeOn(Schedulers.newThread());
		
		src.subscribe(e -> task(e, 1));
		src.subscribe(e -> task(e, 2));
		
		//Thread.sleep(5000);
		
		src.subscribe(e -> task(e, 3));
		src.subscribe(e -> task(e, 4));
		src.subscribe(e -> task(e, 5));//5
		src.subscribe(e -> task(e, 6));
		src.subscribe(e -> task(e, 7));
		src.subscribe(e -> task(e, 8));
		src.subscribe(e -> task(e, 9));
		src.subscribe(e -> task(e, 10));//10
		
		Thread.sleep(50000);
	}

	public static void task(String e, Integer subscriberId) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println(subscriberId + ".subscriber computation done by: " + e + " - " + Thread.currentThread().getName());
	}
}
