package main56_decorator;

import java.util.function.Function;

public class BurgerShop {

	private Function<Burger, Burger> decoration;
	
	public Burger use(Burger baseBurger) {
		System.out.println("Base burger:" + baseBurger);
		return decoration.apply(baseBurger);
	}
	
	public BurgerShop(Function<Burger, Burger> decoration) {
		this.decoration = decoration;
	}
}
