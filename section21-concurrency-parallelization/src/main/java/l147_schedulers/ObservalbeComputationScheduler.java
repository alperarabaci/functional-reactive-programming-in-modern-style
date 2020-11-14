package l147_schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 
 * Thread count as much as machine's CPU number (8):
 * We have 10 subscriber. 2 of them wait a bit.
 * 
	Computation done by: Pasta - RxComputationThreadPool-1
	Computation done by: Pasta - RxComputationThreadPool-8
	Computation done by: Pasta - RxComputationThreadPool-6
	Computation done by: Pasta - RxComputationThreadPool-3
	Computation done by: Pasta - RxComputationThreadPool-2
	Computation done by: Pasta - RxComputationThreadPool-7
	Computation done by: Pasta - RxComputationThreadPool-5
	Computation done by: Pasta - RxComputationThreadPool-4
	Computation done by: Pizza - RxComputationThreadPool-8
	Computation done by: Pizza - RxComputationThreadPool-6
	Computation done by: Pizza - RxComputationThreadPool-7
	Computation done by: Pizza - RxComputationThreadPool-2
	Computation done by: Pizza - RxComputationThreadPool-3
	Computation done by: Pizza - RxComputationThreadPool-5
	Computation done by: Pizza - RxComputationThreadPool-1
	Computation done by: Pizza - RxComputationThreadPool-4
	Computation done by: Fries - RxComputationThreadPool-8
	Computation done by: Fries - RxComputationThreadPool-6
	Computation done by: Fries - RxComputationThreadPool-4
	Computation done by: Fries - RxComputationThreadPool-3
	Computation done by: Fries - RxComputationThreadPool-2
	Computation done by: Fries - RxComputationThreadPool-1
	Computation done by: Fries - RxComputationThreadPool-5
	Computation done by: Fries - RxComputationThreadPool-7
	Computation done by: Curry - RxComputationThreadPool-8
	Computation done by: Curry - RxComputationThreadPool-4
	Computation done by: Curry - RxComputationThreadPool-3
	Computation done by: Curry - RxComputationThreadPool-6
	Computation done by: Curry - RxComputationThreadPool-1
	Computation done by: Curry - RxComputationThreadPool-7
	Computation done by: Curry - RxComputationThreadPool-2
	Computation done by: Curry - RxComputationThreadPool-5
	Computation done by: Chow mein - RxComputationThreadPool-4
	Computation done by: Chow mein - RxComputationThreadPool-8
	Computation done by: Chow mein - RxComputationThreadPool-6
	Computation done by: Chow mein - RxComputationThreadPool-3
	Computation done by: Chow mein - RxComputationThreadPool-7
	Computation done by: Chow mein - RxComputationThreadPool-5
	Computation done by: Chow mein - RxComputationThreadPool-2
	Computation done by: Chow mein - RxComputationThreadPool-1

	After threads finish first cycle, they run for remaining subscribers.
	Again sequentially!
	
	Computation done by: Pasta - RxComputationThreadPool-2
	Computation done by: Pasta - RxComputationThreadPool-1
	Computation done by: Pizza - RxComputationThreadPool-2
	Computation done by: Pizza - RxComputationThreadPool-1
	Computation done by: Fries - RxComputationThreadPool-2
	Computation done by: Fries - RxComputationThreadPool-1
	Computation done by: Curry - RxComputationThreadPool-2
	Computation done by: Curry - RxComputationThreadPool-1
	Computation done by: Chow mein - RxComputationThreadPool-2
	Computation done by: Chow mein - RxComputationThreadPool-1
 * @author alper
 *
 */
public class ObservalbeComputationScheduler {

	public static void main(String[] args) throws InterruptedException {
		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
				.subscribeOn(Schedulers.computation());
		
		src.subscribe(e -> compute(e));
		src.subscribe(e -> compute(e));
		src.subscribe(e -> compute(e));
		src.subscribe(e -> compute(e));
		src.subscribe(e -> compute(e));//5
		src.subscribe(e -> compute(e));
		src.subscribe(e -> compute(e));
		src.subscribe(e -> compute(e));
		src.subscribe(e -> compute(e));
		src.subscribe(e -> compute(e));//10
		
		Thread.sleep(50000);
	}
	
	public static void compute(String e) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Computation done by: " + e + " - " + Thread.currentThread().getName());
	}

}
