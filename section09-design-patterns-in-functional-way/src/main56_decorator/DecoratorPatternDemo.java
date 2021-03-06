package main56_decorator;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
		Burger myOrder = new BurgerShop(burger -> burger.addVeggies())
				.use(new Burger());
		System.out.println("I get " + myOrder);
		
		System.out.println("----------------------------");
		
		Burger myOrder2 = new BurgerShop(burger -> burger.addCheese())
				.use(new BurgerShop(burger -> burger.addVeggies()).use(new Burger()));
		System.out.println("I get " + myOrder2);
	}
}
