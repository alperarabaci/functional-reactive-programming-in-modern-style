package l146_how_to;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {

	public static void main(String[] args) {

		/**
		 * Everything is synchronous we can't go async or concurrent until unless we don't actually ask for it.
		 * Check console log.
		 */
		Observable<String> source = Observable.create(e -> {
			e.onNext("Hello");
			e.onNext("RxJava");
		});
		
		source.subscribe(e -> System.out.println("Observer 1: " +e + " Thread is: " + Thread.currentThread().getName()));
		source.subscribe(e -> System.out.println("Observer 2: " +e + " Thread is: " + Thread.currentThread().getName()));
	}

}
