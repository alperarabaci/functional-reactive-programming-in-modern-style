package main58_factory;

import java.util.function.Supplier;

public class FlooringFactory {

	public static Flooring getFlooring(int minTemprature, int maxTemprature) {
		
		Supplier<Flooring> flooring;
		
		if(minTemprature <= 5 && maxTemprature <= 20) {
			//flooring = () ->  new WoodenFlooring();
			flooring = WoodenFlooring::new;
		}else if(minTemprature <= 5 && maxTemprature >= 45) {
			flooring = () ->  new CorkFlooring();
		}else {
			flooring = () -> new ConcreteFlooring();
		}
		return flooring.get();
	}
}
