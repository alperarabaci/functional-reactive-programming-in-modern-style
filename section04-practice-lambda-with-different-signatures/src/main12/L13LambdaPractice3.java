package main12;

public class L13LambdaPractice3 {

	public static void main(String[] args) {
		LengthOfString len = (str) -> str.length();
		int length = len.length("Wordyourself.app");
		
		System.out.println(length);
	}
}
