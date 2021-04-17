package com.training.l130_observable_variants;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableMaybeObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class VariantsDemo {

	public static void main(String[] args) throws InterruptedException {
		@NonNull
		Observable<String> source = Observable.just("Alex", "Justin", "Jack");
		@NonNull
		Observable<Object> source2 = Observable.empty();
		
		source
		.first("Name")
		.subscribe(System.out::println);
		
		Single.just("Alex")
		.subscribe(System.out::println);
		
		source2
		.firstElement()
		.subscribe(System.out::println,
				   e -> e.printStackTrace(),
				   ()->System.out.println("Completed"));
		
		Completable completable = Completable.complete();
		System.out.println("----");
		completable.subscribe(()->System.out.println("Completed"));
		
		Completable
		.fromRunnable(()->System.out.println("Some process executing"))
		.subscribe( ()-> System.out.println("The process successfully"));
		
		System.out.println("Maybe: ");
		
		Disposable d = Maybe.just("Hello World")
			    .delay(1, TimeUnit.SECONDS, Schedulers.io())
			    .subscribeWith(new DisposableMaybeObserver<String>() {
			        @Override
			        public void onStart() {
			            System.out.println("Started");
			        }

			        @Override
			        public void onSuccess(String value) {
			            System.out.println("Success: " + value);
			        }

			        @Override
			        public void onError(Throwable error) {
			            error.printStackTrace();
			        }

			        @Override
			        public void onComplete() {
			            System.out.println("Done!");
			        }
			    });
			 
			 Thread.sleep(5000);
			 
			 d.dispose();
			
	}
	
}
