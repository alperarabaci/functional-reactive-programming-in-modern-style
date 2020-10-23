package main17;

public class FunctionalGenericDemo {

	public static void main(String[] args) {
		FunctionalGenerics<String, String> fun = s -> s.substring(1, 5);
		System.out.println(fun.execute("wordyourself.app"));
		
		FunctionalGenerics<String, Integer> fun2 = s -> s.length();
		System.out.println(fun2.execute("wordyourself.app"));
	}
	
}
