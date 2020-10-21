package main06;

import main05.MyFunInterface;

public class Main06 {

	public static void main(String[] args) {
		
		MyFunInterface fun1 = new MyFunInterface() {
			
			@Override
			public void myMethod() {
				System.out.println("Implementation 1");
			}
		};
		
		MyFunInterface fun2 = new MyFunInterface() {
			
			@Override
			public void myMethod() {
				System.out.println("Implementation 2");
			}
		};
		
		MyFunInterface fun3 = ()-> System.out.println("Implementation 1");;
	}
}
