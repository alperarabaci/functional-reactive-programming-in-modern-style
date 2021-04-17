package l147_schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 
 *  Thread count as much as the number of subscribers:
 * 
	Computation done by: Pasta - RxCachedThreadScheduler-3
	Computation done by: Pasta - RxCachedThreadScheduler-5
	Computation done by: Pasta - RxCachedThreadScheduler-6
	Computation done by: Pasta - RxCachedThreadScheduler-2
	Computation done by: Pasta - RxCachedThreadScheduler-1
	Computation done by: Pasta - RxCachedThreadScheduler-4
	Computation done by: Pasta - RxCachedThreadScheduler-7
	Computation done by: Pasta - RxCachedThreadScheduler-8
	Computation done by: Pasta - RxCachedThreadScheduler-10
	Computation done by: Pasta - RxCachedThreadScheduler-9
	
	Computation done by: Pizza - RxCachedThreadScheduler-3
	Computation done by: Pizza - RxCachedThreadScheduler-8
	Computation done by: Pizza - RxCachedThreadScheduler-7
	Computation done by: Pizza - RxCachedThreadScheduler-4
	Computation done by: Pizza - RxCachedThreadScheduler-5
	Computation done by: Pizza - RxCachedThreadScheduler-6
	Computation done by: Pizza - RxCachedThreadScheduler-2
	Computation done by: Pizza - RxCachedThreadScheduler-1
	Computation done by: Pizza - RxCachedThreadScheduler-10
	Computation done by: Pizza - RxCachedThreadScheduler-9
	
	...
 * 
 * 
 * @author alper
 *
 */
public class ObservalbeIOScheduler {

	public static void main(String[] args) throws InterruptedException {
		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
				.subscribeOn(Schedulers.io());
		
		src.subscribe(e -> ioOperation(e, 1));
		src.subscribe(e -> ioOperation(e, 2));
		
		Thread.sleep(5000);
		
		src.subscribe(e -> ioOperation(e, 3));
		src.subscribe(e -> ioOperation(e, 4));
		src.subscribe(e -> ioOperation(e, 5));
		src.subscribe(e -> ioOperation(e, 6));
		src.subscribe(e -> ioOperation(e, 7));
		src.subscribe(e -> ioOperation(e, 8));
		src.subscribe(e -> ioOperation(e, 9));
		src.subscribe(e -> ioOperation(e, 10));//10
		
		Thread.sleep(50000);
	}
	
	public static void ioOperation(String e, Integer subscriberId) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println(subscriberId + ".subscriber computation done by: " + e + " - " + Thread.currentThread().getName());
	}
	
}
