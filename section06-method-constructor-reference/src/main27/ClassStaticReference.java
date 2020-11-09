package main27;

import java.util.function.BiFunction;

public class ClassStaticReference {

	public static void main(String[] args) {
		/**
		 * Class:staticMethod
		 */
		//BiFunction<String, String, String> biFunction2 = (a, b) -> A_Class.staticMethod(a, b);
		BiFunction<String, String, String> biFunction = A_Class :: staticMethod;
		
		System.out.println(biFunction.apply("Basics", "Strong"));

	}
	
}

class A_Class{
	
	static String staticMethod(String a, String b) {
		return a+b;
	}
}

	
	
	