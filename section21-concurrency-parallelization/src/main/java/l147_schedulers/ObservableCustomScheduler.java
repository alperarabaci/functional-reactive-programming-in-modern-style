package l147_schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * We set thread count 20 but it is not exceed subscriber count.
 * 
 *
	3.subscriber computation done by: Pasta - pool-1-thread-3
	1.subscriber computation done by: Pasta - pool-1-thread-1
	2.subscriber computation done by: Pasta - pool-1-thread-2
	8.subscriber computation done by: Pasta - pool-1-thread-8
	10.subscriber computation done by: Pasta - pool-1-thread-10
	7.subscriber computation done by: Pasta - pool-1-thread-7
	5.subscriber computation done by: Pasta - pool-1-thread-5
	9.subscriber computation done by: Pasta - pool-1-thread-9
	4.subscriber computation done by: Pasta - pool-1-thread-4
	6.subscriber computation done by: Pasta - pool-1-thread-6
	1.subscriber computation done by: Pizza - pool-1-thread-1
	8.subscriber computation done by: Pizza - pool-1-thread-8
	2.subscriber computation done by: Pizza - pool-1-thread-2
	3.subscriber computation done by: Pizza - pool-1-thread-3
	9.subscriber computation done by: Pizza - pool-1-thread-9
	6.subscriber computation done by: Pizza - pool-1-thread-6
	7.subscriber computation done by: Pizza - pool-1-thread-7
	10.subscriber computation done by: Pizza - pool-1-thread-10
	4.subscriber computation done by: Pizza - pool-1-thread-4
	5.subscriber computation done by: Pizza - pool-1-thread-5
	3.subscriber computation done by: Fries - pool-1-thread-3 
 * 
 * @author alper
 *
 */
public class ObservableCustomScheduler {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(20);
		
		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
				.subscribeOn(Schedulers.from(executor))
				.doFinally(executor::shutdown);
		
		src.subscribe(e -> compute(e, 1));
		src.subscribe(e -> compute(e, 2));
		
		//Thread.sleep(5000);
		
		src.subscribe(e -> compute(e, 3));
		src.subscribe(e -> compute(e, 4));
		src.subscribe(e -> compute(e, 5));
		src.subscribe(e -> compute(e, 6));
		src.subscribe(e -> compute(e, 7));
		src.subscribe(e -> compute(e, 8));
		src.subscribe(e -> compute(e, 9));
		src.subscribe(e -> compute(e, 10));//10
		
		Thread.sleep(50000);
	}
	
	public static void compute(String e, Integer subscriberId) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println(subscriberId + ".subscriber computation done by: " + e + " - " + Thread.currentThread().getName());
	}
	
}
