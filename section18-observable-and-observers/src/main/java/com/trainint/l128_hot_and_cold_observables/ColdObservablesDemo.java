package com.trainint.l128_hot_and_cold_observables;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

/**
 * https://medium.com/tompee/rxjava-ninja-hot-and-cold-observables-19b30d6cc2fa
 * Cold observables are sequences that only emits item upon subscription. Each
 * observer will have its own set of items emitted to them and depending on how
 * the observable was created, will have different instances of emitted items.
 * 
 * @author alper
 *
 */
public class ColdObservablesDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(16);
		list.add(17);
		list.add(18);

		Observable<Integer> source = Observable.fromIterable(list);
		System.out.println("subscribe:");
		source.subscribe(System.out::println);

		list = getData(list);

		System.out.println("subscribe:");
		source.subscribe(System.out::println);
	}

	private static List<Integer> getData(List<Integer> list) {
		list.add(19);
		return list;
	}

}
