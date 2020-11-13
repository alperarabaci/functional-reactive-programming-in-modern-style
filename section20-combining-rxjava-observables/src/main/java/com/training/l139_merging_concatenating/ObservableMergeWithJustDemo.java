package com.training.l139_merging_concatenating;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class ObservableMergeWithJustDemo {

	public static void main(String[] args) {
		@NonNull
		Observable<String> source1 = Observable.just("Ella", "Alexa", "Lily");
		@NonNull
		Observable<String> source2 = Observable.just("Priya", "Chloe");
		
		Observable.merge(source1, source2)
		.subscribe(e -> System.out.println("Received:" + e));
	}

}
