package main10;

public class L10LambdaPractice1 {

	public static void main(String[] args) {
		Name name = () -> System.out.println("John");
		name.myName();
	}
}
