package main13;

import main12.LengthOfString;

public class L14LambdaPractice4 {

	public static void main(String[] args) {
		LengthOfString len = (str) -> {
			
			int l =  str.length();
			System.out.println("The length of string: "+ l);
			return l;
		};
		int length = len.length("Wordyourself.app");
		System.out.println(length);
		
	}
}
