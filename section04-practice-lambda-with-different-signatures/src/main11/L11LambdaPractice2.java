package main11;

public class L11LambdaPractice2 {

	public static void main(String[] args) {
		MathOperation add = (a,b) -> System.out.println(a+b);
		add.operation(10, 20);
		
		MathOperation multiply = (a,b) -> System.out.println(a*b);
		multiply.operation(10, 20);
	}
	
}
