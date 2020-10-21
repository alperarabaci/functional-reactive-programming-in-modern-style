package main05;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		MyFunInterface fun = () -> System.out.println("hello");
		fun.myMethod();
		
		onTheFly(() -> System.out.println("hello2"));
	}
	
	public static void onTheFly(MyFunInterface fun) {
		fun.myMethod();
	}
	
}
